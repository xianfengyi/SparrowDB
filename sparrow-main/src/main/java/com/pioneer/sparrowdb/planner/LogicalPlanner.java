package com.pioneer.sparrowdb.planner;

import com.pioneer.sparrowdb.planner.plan.*;
import com.pioneer.sparrowdb.sqlparser.tree.*;
import com.pioneer.sparrowdb.sqlparser.tree.literal.LongLiteral;
import com.pioneer.sparrowdb.storage.*;
import com.pioneer.sparrowdb.storage.model.DbTable;
import com.pioneer.sparrowdb.storage.transaction.TransactionID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LogicalPlanner {

    public PlanNode planStatement(Statement statement, TransactionID transactionId) {
        if (statement instanceof Insert) {
            return createInsertPlan((Insert) statement, transactionId);
        } else if (statement instanceof Delete) {
            return createDeletePlan((Delete) statement, transactionId);
        } else if (statement instanceof Query) {
            return createQueryPlan((Query) statement, transactionId);
        } else if (statement instanceof CreateTable) {
            return createTablePlan((CreateTable) statement, transactionId);
        }
        throw new RuntimeException("not support this statement plan");
    }

    private PlanNode createTablePlan(CreateTable statement, TransactionID transactionId) {
        String tableName = statement.getName().toString();
        List<DbTable.Column> columns = new ArrayList<>();
        for (TableElement element : statement.getElements()) {
            ColumnDefinition columnDefinition = (ColumnDefinition) element;
            columns.add(new DbTable.Column(columnDefinition.getName().getValue(), columnDefinition.getType()));
        }
        return new CreateNode(new DbTable(tableName, columns));
    }

    private PlanNode createQueryPlan(Query statement, TransactionID transactionId) {
        QuerySpecification querySpecification = (QuerySpecification) statement.getQueryBody();
        PlanNode root = null;

        root = getTableScanNode(querySpecification.getFrom(), transactionId);

        root = getWhereNode(root, querySpecification.getWhere());

        root = getLimitNode(root, querySpecification.getLimit());

        root = getOrderByNode(root, querySpecification.getOrderBy());

        root = getGroupByNode(root, querySpecification.getGroupBy());

        return getProjectNode(root, querySpecification.getSelect());
    }

    private PlanNode getTableScanNode(Optional<Relation> relation, TransactionID transactionId) {
        Table table = (Table) relation.get();
        return getTableScanNode(table, transactionId);
    }

    private PlanNode getTableScanNode(Table table, TransactionID transactionId) {
        String tableName = table.getName().toString();
        int tableId = DataBase.getCatalog().getTableId(tableName);
        return new TableScanNode(tableId, tableName, transactionId);
    }

    private PlanNode getWhereNode(PlanNode source, Optional<Expression> where) {
        if (where.isEmpty()) {
            return source;
        }
        // 当前先只支持一个等于表达式
        String whereExpr = where.get().toString();
        String[] whereExprArr = whereExpr.split("=");
        return new FilterNode(source, whereExprArr[0].trim(), Integer.parseInt(whereExprArr[1].trim()));
    }

    private PlanNode getLimitNode(PlanNode source, Optional<String> limit) {
        if (limit.isEmpty()) {
            return source;
        }
        return new LimitNode(source, Integer.parseInt(limit.get()));
    }

    private PlanNode getOrderByNode(PlanNode source, Optional<OrderBy> orderBy) {
        return source;
    }

    private PlanNode getGroupByNode(PlanNode source, Optional<GroupBy> groupBy) {
        return source;
    }

    private PlanNode getProjectNode(PlanNode source, Select select) {
        // 获取要查询的字段
        List<SelectItem> selectItems = select.getSelectItems();
        return new ProjectNode(source, selectItems);
    }

    private PlanNode createDeletePlan(Delete statement, TransactionID transactionId) {
        Table table = statement.getTable();
        Optional<Expression> where = statement.getWhere();

        PlanNode root = getTableScanNode(table, transactionId);
        root = getWhereNode(root, where);
        List<Tuple> tuples = new ArrayList<>();
        while (true) {
            Tuple tuple = root.getNextTuple();
            if (tuple == null) {
                break;
            }
            tuples.add(tuple);
        }
        int tableId= DataBase.getCatalog().getTableId(table.getName().toString());
        TupleDesc tupleDesc = DataBase.getCatalog().getTupleDesc(tableId);
        TupleIterator tupleIterator = new TupleIterator(tupleDesc, tuples);
        return new DeleteNode(tupleIterator, transactionId);
    }

    private PlanNode createInsertPlan(Insert statement, TransactionID transactionId) {
        int tableId = DataBase.getCatalog().getTableId(statement.getTarget().toString());
        TupleDesc tupleDesc = DataBase.getCatalog().getTupleDesc(tableId);
        Tuple tuple = new Tuple(tupleDesc);

        QueryBody queryBody = statement.getQuery().getQueryBody();
        Values values = (Values) queryBody;
        int i = 0;
        for (Expression expression : values.getRows()) {
            Row row = (Row) expression;
            for (Expression rowExpr : row.getItems()) {
                LongLiteral longLiteral = (LongLiteral) rowExpr;
                tuple.setField(i++, new IntField((int) longLiteral.getValue()));
            }
        }
        TupleIterator tupleIterator = new TupleIterator(tupleDesc, Arrays.asList(tuple));
        return new InsertNode(tupleIterator, tableId,transactionId);
    }

}
