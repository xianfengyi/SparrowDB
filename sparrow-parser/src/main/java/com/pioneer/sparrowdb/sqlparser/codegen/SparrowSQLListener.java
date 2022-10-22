// Generated from /Users/bytedance/Project/pioneeryi/SparrowDB/SparrowDB/sparrow-parser/antlr4/SparrowSQL.g4 by ANTLR 4.10.1
package com.pioneer.sparrowdb.sqlparser.codegen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SparrowSQLParser}.
 */
public interface SparrowSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(SparrowSQLParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(SparrowSQLParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementDefault}
	 * labeled alternative in {@link SparrowSQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementDefault(SparrowSQLParser.StatementDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementDefault}
	 * labeled alternative in {@link SparrowSQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementDefault(SparrowSQLParser.StatementDefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(SparrowSQLParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(SparrowSQLParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#queryNoWith}.
	 * @param ctx the parse tree
	 */
	void enterQueryNoWith(SparrowSQLParser.QueryNoWithContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#queryNoWith}.
	 * @param ctx the parse tree
	 */
	void exitQueryNoWith(SparrowSQLParser.QueryNoWithContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryTermDefault}
	 * labeled alternative in {@link SparrowSQLParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void enterQueryTermDefault(SparrowSQLParser.QueryTermDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryTermDefault}
	 * labeled alternative in {@link SparrowSQLParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void exitQueryTermDefault(SparrowSQLParser.QueryTermDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryPrimaryDefault}
	 * labeled alternative in {@link SparrowSQLParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterQueryPrimaryDefault(SparrowSQLParser.QueryPrimaryDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryPrimaryDefault}
	 * labeled alternative in {@link SparrowSQLParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitQueryPrimaryDefault(SparrowSQLParser.QueryPrimaryDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code table}
	 * labeled alternative in {@link SparrowSQLParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterTable(SparrowSQLParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code table}
	 * labeled alternative in {@link SparrowSQLParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitTable(SparrowSQLParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inlineTable}
	 * labeled alternative in {@link SparrowSQLParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterInlineTable(SparrowSQLParser.InlineTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inlineTable}
	 * labeled alternative in {@link SparrowSQLParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitInlineTable(SparrowSQLParser.InlineTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subquery}
	 * labeled alternative in {@link SparrowSQLParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(SparrowSQLParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subquery}
	 * labeled alternative in {@link SparrowSQLParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(SparrowSQLParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#sortItem}.
	 * @param ctx the parse tree
	 */
	void enterSortItem(SparrowSQLParser.SortItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#sortItem}.
	 * @param ctx the parse tree
	 */
	void exitSortItem(SparrowSQLParser.SortItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(SparrowSQLParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(SparrowSQLParser.QuerySpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#groupBy}.
	 * @param ctx the parse tree
	 */
	void enterGroupBy(SparrowSQLParser.GroupByContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#groupBy}.
	 * @param ctx the parse tree
	 */
	void exitGroupBy(SparrowSQLParser.GroupByContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleGroupingSet}
	 * labeled alternative in {@link SparrowSQLParser#groupingElement}.
	 * @param ctx the parse tree
	 */
	void enterSingleGroupingSet(SparrowSQLParser.SingleGroupingSetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleGroupingSet}
	 * labeled alternative in {@link SparrowSQLParser#groupingElement}.
	 * @param ctx the parse tree
	 */
	void exitSingleGroupingSet(SparrowSQLParser.SingleGroupingSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#groupingSet}.
	 * @param ctx the parse tree
	 */
	void enterGroupingSet(SparrowSQLParser.GroupingSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#groupingSet}.
	 * @param ctx the parse tree
	 */
	void exitGroupingSet(SparrowSQLParser.GroupingSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void enterSetQuantifier(SparrowSQLParser.SetQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void exitSetQuantifier(SparrowSQLParser.SetQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectSingle}
	 * labeled alternative in {@link SparrowSQLParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void enterSelectSingle(SparrowSQLParser.SelectSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectSingle}
	 * labeled alternative in {@link SparrowSQLParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void exitSelectSingle(SparrowSQLParser.SelectSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selectAll}
	 * labeled alternative in {@link SparrowSQLParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void enterSelectAll(SparrowSQLParser.SelectAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectAll}
	 * labeled alternative in {@link SparrowSQLParser#selectItem}.
	 * @param ctx the parse tree
	 */
	void exitSelectAll(SparrowSQLParser.SelectAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationDefault}
	 * labeled alternative in {@link SparrowSQLParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelationDefault(SparrowSQLParser.RelationDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationDefault}
	 * labeled alternative in {@link SparrowSQLParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelationDefault(SparrowSQLParser.RelationDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code joinRelation}
	 * labeled alternative in {@link SparrowSQLParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterJoinRelation(SparrowSQLParser.JoinRelationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code joinRelation}
	 * labeled alternative in {@link SparrowSQLParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitJoinRelation(SparrowSQLParser.JoinRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(SparrowSQLParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(SparrowSQLParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#joinCriteria}.
	 * @param ctx the parse tree
	 */
	void enterJoinCriteria(SparrowSQLParser.JoinCriteriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#joinCriteria}.
	 * @param ctx the parse tree
	 */
	void exitJoinCriteria(SparrowSQLParser.JoinCriteriaContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#sampledRelation}.
	 * @param ctx the parse tree
	 */
	void enterSampledRelation(SparrowSQLParser.SampledRelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#sampledRelation}.
	 * @param ctx the parse tree
	 */
	void exitSampledRelation(SparrowSQLParser.SampledRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#sampleType}.
	 * @param ctx the parse tree
	 */
	void enterSampleType(SparrowSQLParser.SampleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#sampleType}.
	 * @param ctx the parse tree
	 */
	void exitSampleType(SparrowSQLParser.SampleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#aliasedRelation}.
	 * @param ctx the parse tree
	 */
	void enterAliasedRelation(SparrowSQLParser.AliasedRelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#aliasedRelation}.
	 * @param ctx the parse tree
	 */
	void exitAliasedRelation(SparrowSQLParser.AliasedRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#columnAliases}.
	 * @param ctx the parse tree
	 */
	void enterColumnAliases(SparrowSQLParser.ColumnAliasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#columnAliases}.
	 * @param ctx the parse tree
	 */
	void exitColumnAliases(SparrowSQLParser.ColumnAliasesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableName}
	 * labeled alternative in {@link SparrowSQLParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterTableName(SparrowSQLParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableName}
	 * labeled alternative in {@link SparrowSQLParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitTableName(SparrowSQLParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryRelation}
	 * labeled alternative in {@link SparrowSQLParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryRelation(SparrowSQLParser.SubqueryRelationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryRelation}
	 * labeled alternative in {@link SparrowSQLParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryRelation(SparrowSQLParser.SubqueryRelationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesizedRelation}
	 * labeled alternative in {@link SparrowSQLParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedRelation(SparrowSQLParser.ParenthesizedRelationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesizedRelation}
	 * labeled alternative in {@link SparrowSQLParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedRelation(SparrowSQLParser.ParenthesizedRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SparrowSQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SparrowSQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link SparrowSQLParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNot(SparrowSQLParser.LogicalNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link SparrowSQLParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNot(SparrowSQLParser.LogicalNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanDefault}
	 * labeled alternative in {@link SparrowSQLParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanDefault(SparrowSQLParser.BooleanDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanDefault}
	 * labeled alternative in {@link SparrowSQLParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanDefault(SparrowSQLParser.BooleanDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalBinary}
	 * labeled alternative in {@link SparrowSQLParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalBinary(SparrowSQLParser.LogicalBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalBinary}
	 * labeled alternative in {@link SparrowSQLParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalBinary(SparrowSQLParser.LogicalBinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#predicated}.
	 * @param ctx the parse tree
	 */
	void enterPredicated(SparrowSQLParser.PredicatedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#predicated}.
	 * @param ctx the parse tree
	 */
	void exitPredicated(SparrowSQLParser.PredicatedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterComparison(SparrowSQLParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitComparison(SparrowSQLParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code between}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterBetween(SparrowSQLParser.BetweenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code between}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitBetween(SparrowSQLParser.BetweenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inList}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterInList(SparrowSQLParser.InListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inList}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitInList(SparrowSQLParser.InListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inSubquery}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterInSubquery(SparrowSQLParser.InSubqueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inSubquery}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitInSubquery(SparrowSQLParser.InSubqueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullPredicate}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterNullPredicate(SparrowSQLParser.NullPredicateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullPredicate}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitNullPredicate(SparrowSQLParser.NullPredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code distinctFrom}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterDistinctFrom(SparrowSQLParser.DistinctFromContext ctx);
	/**
	 * Exit a parse tree produced by the {@code distinctFrom}
	 * labeled alternative in {@link SparrowSQLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitDistinctFrom(SparrowSQLParser.DistinctFromContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpressionDefault}
	 * labeled alternative in {@link SparrowSQLParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpressionDefault(SparrowSQLParser.ValueExpressionDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpressionDefault}
	 * labeled alternative in {@link SparrowSQLParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpressionDefault(SparrowSQLParser.ValueExpressionDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concatenation}
	 * labeled alternative in {@link SparrowSQLParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterConcatenation(SparrowSQLParser.ConcatenationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concatenation}
	 * labeled alternative in {@link SparrowSQLParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitConcatenation(SparrowSQLParser.ConcatenationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticBinary}
	 * labeled alternative in {@link SparrowSQLParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticBinary(SparrowSQLParser.ArithmeticBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticBinary}
	 * labeled alternative in {@link SparrowSQLParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticBinary(SparrowSQLParser.ArithmeticBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticUnary}
	 * labeled alternative in {@link SparrowSQLParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticUnary(SparrowSQLParser.ArithmeticUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticUnary}
	 * labeled alternative in {@link SparrowSQLParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticUnary(SparrowSQLParser.ArithmeticUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(SparrowSQLParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(SparrowSQLParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterTypeConstructor(SparrowSQLParser.TypeConstructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitTypeConstructor(SparrowSQLParser.TypeConstructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(SparrowSQLParser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(SparrowSQLParser.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(SparrowSQLParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(SparrowSQLParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(SparrowSQLParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(SparrowSQLParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnReference}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnReference(SparrowSQLParser.ColumnReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnReference}
	 * labeled alternative in {@link SparrowSQLParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnReference(SparrowSQLParser.ColumnReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code basicStringLiteral}
	 * labeled alternative in {@link SparrowSQLParser#string}.
	 * @param ctx the parse tree
	 */
	void enterBasicStringLiteral(SparrowSQLParser.BasicStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code basicStringLiteral}
	 * labeled alternative in {@link SparrowSQLParser#string}.
	 * @param ctx the parse tree
	 */
	void exitBasicStringLiteral(SparrowSQLParser.BasicStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(SparrowSQLParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(SparrowSQLParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(SparrowSQLParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(SparrowSQLParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SparrowSQLParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(SparrowSQLParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SparrowSQLParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(SparrowSQLParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link SparrowSQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterUnquotedIdentifier(SparrowSQLParser.UnquotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link SparrowSQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitUnquotedIdentifier(SparrowSQLParser.UnquotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quotedIdentifier}
	 * labeled alternative in {@link SparrowSQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifier(SparrowSQLParser.QuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quotedIdentifier}
	 * labeled alternative in {@link SparrowSQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifier(SparrowSQLParser.QuotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code backQuotedIdentifier}
	 * labeled alternative in {@link SparrowSQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterBackQuotedIdentifier(SparrowSQLParser.BackQuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code backQuotedIdentifier}
	 * labeled alternative in {@link SparrowSQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitBackQuotedIdentifier(SparrowSQLParser.BackQuotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code digitIdentifier}
	 * labeled alternative in {@link SparrowSQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterDigitIdentifier(SparrowSQLParser.DigitIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code digitIdentifier}
	 * labeled alternative in {@link SparrowSQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitDigitIdentifier(SparrowSQLParser.DigitIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link SparrowSQLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(SparrowSQLParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link SparrowSQLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(SparrowSQLParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link SparrowSQLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDoubleLiteral(SparrowSQLParser.DoubleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link SparrowSQLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDoubleLiteral(SparrowSQLParser.DoubleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link SparrowSQLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(SparrowSQLParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link SparrowSQLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(SparrowSQLParser.IntegerLiteralContext ctx);
}