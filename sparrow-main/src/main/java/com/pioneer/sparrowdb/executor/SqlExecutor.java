package com.pioneer.sparrowdb.executor;


import com.pioneer.sparrowdb.planner.LogicalPlanner;
import com.pioneer.sparrowdb.planner.plan.InsertNode;
import com.pioneer.sparrowdb.planner.plan.PlanNode;
import com.pioneer.sparrowdb.sqlparser.parser.SqlParser;
import com.pioneer.sparrowdb.sqlparser.tree.Delete;
import com.pioneer.sparrowdb.sqlparser.tree.Insert;
import com.pioneer.sparrowdb.sqlparser.tree.Query;
import com.pioneer.sparrowdb.sqlparser.tree.Statement;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.TupleDesc;
import com.pioneer.sparrowdb.storage.transaction.TransactionAbortedException;

import java.util.ArrayList;
import java.util.List;

public class SqlExecutor {

    private LogicalPlanner logicalPlanner = new LogicalPlanner();

    public void execute(String sql) {
        SqlParser sqlParser = new SqlParser();
        Statement statement = sqlParser.createStatement(sql);
        PlanNode planNode = logicalPlanner.planStatement(statement);
        if (planNode ==null){
            return;
        }
        if (statement instanceof Query) {
            doExecuteQuery(planNode);
        } else{
            doExecuteNonQuery(planNode);
        }
    }

    private void doExecuteQuery(PlanNode planNode) {
        try {
            // and run it
            Tuple tup = planNode.getNextTuple();
            printTupleDesc(tup.getTupleDesc());
            while (tup != null) {
                System.out.println(tup);
                tup = planNode.getNextTuple();
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }
    }

    private void printTupleDesc(TupleDesc tupleDesc) {
        List<String> columnNames = new ArrayList<>();
        for (TupleDesc.TDItem tdItem : tupleDesc.getTdItems()) {
            columnNames.add(tdItem.getFieldName());
        }
        System.out.println(String.join(" ", columnNames));
    }

    private void doExecuteNonQuery(PlanNode planNode)  {
        InsertNode insertNode = (InsertNode) planNode;
        try {
            insertNode.execute();
        } catch (TransactionAbortedException e) {
            throw new RuntimeException(e);
        }
    }
}
