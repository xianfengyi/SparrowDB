package com.pioneer.sparrowdb.sqlparser.parser;

import com.pioneer.sparrowdb.sqlparser.ParsingException;
import com.pioneer.sparrowdb.sqlparser.codegen.SparrowSQLBaseVisitor;
import com.pioneer.sparrowdb.sqlparser.codegen.SparrowSQLLexer;
import com.pioneer.sparrowdb.sqlparser.codegen.SparrowSQLParser;
import com.pioneer.sparrowdb.sqlparser.tree.*;
import com.pioneer.sparrowdb.sqlparser.tree.literal.BooleanLiteral;
import com.pioneer.sparrowdb.sqlparser.tree.literal.DecimalLiteral;
import com.pioneer.sparrowdb.sqlparser.tree.literal.DoubleLiteral;
import com.pioneer.sparrowdb.sqlparser.tree.literal.LongLiteral;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AstBuilder extends SparrowSQLBaseVisitor<Node> {

    private final ParsingOptions parsingOptions;

    public AstBuilder(ParsingOptions parsingOptions) {
        this.parsingOptions = parsingOptions;
    }

    @Override
    public Node visitSingleStatement(SparrowSQLParser.SingleStatementContext context) {
        return visit(context.statement());
    }

    @Override
    public Node visitQuery(SparrowSQLParser.QueryContext context) {
        Query body = (Query) visit(context.queryNoWith());
        return new Query(body.getQueryBody(), Optional.empty(), Optional.empty(), Optional.empty());
    }

    @Override
    public Node visitQueryNoWith(SparrowSQLParser.QueryNoWithContext context) {
        QueryBody term = (QueryBody) visit(context.queryTerm());

        Optional<OrderBy> orderBy = Optional.empty();
        if (context.ORDER() != null) {
            orderBy = Optional.of(new OrderBy(visit(context.sortItem(), SortItem.class)));
        }

        Optional<Offset> offset = Optional.empty();
        if (context.OFFSET() != null) {
            offset = Optional.of(new Offset(getTextIfPresent(context.offset).orElseThrow(() -> new IllegalStateException("Missing OFFSET row count"))));
        }

        if (term instanceof QuerySpecification) {
            // When we have a simple query specification
            // followed by order by limit, fold the order by and limit
            // clauses into the query specification (analyzer/planner
            // expects this structure to resolve references with respect
            // to columns defined in the query specification)
            QuerySpecification query = (QuerySpecification) term;
            return new Query(new QuerySpecification(
                    query.getSelect(),
                    query.getFrom(),
                    query.getWhere(),
                    query.getGroupBy(),
                    orderBy,
                    offset,
                    getTextIfPresent(context.limit)), Optional.empty(), Optional.empty(), Optional.empty());
        }

        return new Query(term, Optional.empty(), Optional.empty(), Optional.empty());
    }

    @Override
    public Node visitQuerySpecification(SparrowSQLParser.QuerySpecificationContext context) {
        Optional<Relation> from = Optional.empty();
        List<SelectItem> selectItems = visit(context.selectItem(), SelectItem.class);

        List<Relation> relations = visit(context.relation(), Relation.class);
        if (!relations.isEmpty()) {
            // synthesize implicit join nodes
            Iterator<Relation> iterator = relations.iterator();
            Relation relation = iterator.next();

            from = Optional.of(relation);
        }

        Optional<Expression> where = visitIfPresent(context.where, Expression.class);
        Optional<GroupBy> groupBy = visitIfPresent(context.groupBy(), GroupBy.class);
        return new QuerySpecification(new Select(isDistinct(context.setQuantifier()), selectItems),
                from,
                where,
                groupBy,
                Optional.empty(),
                Optional.empty(),
                Optional.empty());
    }

    @Override
    public Node visitSelectAll(SparrowSQLParser.SelectAllContext context)
    {
        if (context.qualifiedName() != null) {
            return new AllColumns(getQualifiedName(context.qualifiedName()));
        }
        return new AllColumns();
    }

    @Override
    public Node visitSelectSingle(SparrowSQLParser.SelectSingleContext context) {
        SelectItem selectItem = new SingleColumn((Expression) visit(context.expression()), Optional.empty());
        return selectItem;
    }

    @Override
    public Node visitColumnReference(SparrowSQLParser.ColumnReferenceContext context) {
        return visit(context.identifier());
    }

    @Override
    public Node visitTableName(SparrowSQLParser.TableNameContext context) {
        return new Table(getQualifiedName(context.qualifiedName()));
    }

    @Override
    public Node visitUnquotedIdentifier(SparrowSQLParser.UnquotedIdentifierContext context) {
        String text = context.getText();
        Node node = new Identifier(text, false);
        return node;
    }

    @Override
    public Node visitSortItem(SparrowSQLParser.SortItemContext ctx) {
        Expression sortKey =(Expression) visit(ctx.expression());
        SortItem.Ordering ordering = Optional.ofNullable(ctx.ordering)
                .map(AstBuilder::getOrderingType)
                .orElse(SortItem.Ordering.ASCENDING);
        return new SortItem(sortKey,ordering);
    }

    @Override
    public Node visitGroupBy(SparrowSQLParser.GroupByContext context)
    {
        return new GroupBy(visit(context.groupingElement(), GroupingElement.class));
    }

    @Override
    public Node visitPredicated(SparrowSQLParser.PredicatedContext context) {
        if (context.predicate() != null) {
            return visit(context.predicate());
        }

        return visit(context.valueExpression);
    }

    @Override
    public Node visitComparison(SparrowSQLParser.ComparisonContext context) {
        return new ComparisonExpression(
                getComparisonOperator(((TerminalNode) context.comparisonOperator().getChild(0)).getSymbol()),
                (Expression) visit(context.value),
                (Expression) visit(context.right));
    }

    @Override
    public Node visitIntegerLiteral(SparrowSQLParser.IntegerLiteralContext context) {
        return new LongLiteral(context.getText());
    }

    @Override
    public Node visitDecimalLiteral(SparrowSQLParser.DecimalLiteralContext context) {
        switch (parsingOptions.getDecimalLiteralTreatment()) {
            case AS_DOUBLE:
                return new DoubleLiteral(context.getText());
            case AS_DECIMAL:
                return new DecimalLiteral(context.getText());
            case REJECT:
                throw new ParsingException("Unexpected decimal literal: " + context.getText());
        }
        throw new AssertionError("Unreachable");
    }

    @Override
    public Node visitDoubleLiteral(SparrowSQLParser.DoubleLiteralContext context) {
        return new DoubleLiteral(context.getText());
    }

    @Override
    public Node visitBooleanValue(SparrowSQLParser.BooleanValueContext context) {
        return new BooleanLiteral(context.getText());
    }

    private <T> List<T> visit(List<? extends ParserRuleContext> contexts, Class<T> clazz) {
        return contexts.stream().map(this::visit).map(clazz::cast).collect(toList());
    }

    private static boolean isDistinct(SparrowSQLParser.SetQuantifierContext setQuantifier) {
        return setQuantifier != null && setQuantifier.DISTINCT() != null;
    }

    private <T> Optional<T> visitIfPresent(ParserRuleContext context, Class<T> clazz) {
        return Optional.ofNullable(context).map(this::visit).map(clazz::cast);
    }

    private QualifiedName getQualifiedName(SparrowSQLParser.QualifiedNameContext context) {
        List<String> parts = visit(context.identifier(), Identifier.class).stream().map(Identifier::getValue) //
                // TODO: preserve quotedness
                .collect(Collectors.toList());

        return QualifiedName.of(parts);
    }

    private static Optional<String> getTextIfPresent(ParserRuleContext context)
    {
        return Optional.ofNullable(context).map(ParseTree::getText);
    }

    private static Optional<String> getTextIfPresent(Token token)
    {
        return Optional.ofNullable(token).map(Token::getText);
    }

    private static SortItem.Ordering getOrderingType(Token token)
    {
        switch (token.getType()) {
            case SparrowSQLLexer.ASC:
                return SortItem.Ordering.ASCENDING;
            case SparrowSQLLexer.DESC:
                return SortItem.Ordering.DESCENDING;
        }
        throw new IllegalArgumentException("Unsupported ordering: " + token.getText());
    }

    private static ComparisonExpression.Operator getComparisonOperator(Token symbol) {
        switch (symbol.getType()) {
            case SparrowSQLParser.EQ:
                return ComparisonExpression.Operator.EQUAL;
            case SparrowSQLParser.NEQ:
                return ComparisonExpression.Operator.NOT_EQUAL;
            case SparrowSQLParser.LT:
                return ComparisonExpression.Operator.LESS_THAN;
            case SparrowSQLParser.LTE:
                return ComparisonExpression.Operator.LESS_THAN_OR_EQUAL;
            case SparrowSQLParser.GT:
                return ComparisonExpression.Operator.GREATER_THAN;
            case SparrowSQLParser.GTE:
                return ComparisonExpression.Operator.GREATER_THAN_OR_EQUAL;
        }

        throw new IllegalArgumentException("Unsupported operator: " + symbol.getText());
    }
}
