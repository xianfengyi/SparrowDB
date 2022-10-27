package com.pioneer.sparrowdb.planner;

import com.pioneer.sparrowdb.planner.plan.*;
import com.pioneer.sparrowdb.sqlparser.tree.*;

import java.util.List;
import java.util.Optional;

public class LogicalPlanner {

    public PlanNode planStatement(Statement statement) {
        if (statement instanceof Insert) {
            return createInsertPlan((Insert) statement);
        } else if (statement instanceof Delete) {
            return createDeletePlan((Delete) statement);
        } else if (statement instanceof Query) {
            return createQueryPlan((Query) statement);
        }
        throw new RuntimeException("not support this statement plan");
    }

    private PlanNode createQueryPlan(Query statement) {
        QuerySpecification querySpecification = (QuerySpecification) statement.getQueryBody();
        PlanNode root = null;

        root = getTableScanNode(querySpecification.getFrom());

        root = getWhereNode(root, querySpecification.getWhere());

        root = getLimitNode(root, querySpecification.getLimit());

        root = getOrderByNode(root, querySpecification.getOrderBy());

        root = getGroupByNode(root, querySpecification.getGroupBy());

        return getProjectNode(root, querySpecification.getSelect());
    }

    private PlanNode getTableScanNode(Optional<Relation> relation) {
        Table table = (Table) relation.get();
        return new TableScanNode(1, table.getName().toString());
    }

    private PlanNode getWhereNode(PlanNode source, Optional<Expression> where) {
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

    private PlanNode createDeletePlan(Delete statement) {
        return null;
    }

    private PlanNode createInsertPlan(Insert statement) {
        return null;
    }

}
