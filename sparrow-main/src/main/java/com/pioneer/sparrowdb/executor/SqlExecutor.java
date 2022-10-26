package com.pioneer.sparrowdb.executor;


import com.pioneer.sparrowdb.planner.QueryPlanner;
import com.pioneer.sparrowdb.planner.plan.PlanNode;
import com.pioneer.sparrowdb.sqlparser.parser.SqlParser;
import com.pioneer.sparrowdb.sqlparser.tree.Query;
import com.pioneer.sparrowdb.sqlparser.tree.QuerySpecification;
import com.pioneer.sparrowdb.sqlparser.tree.Statement;
import com.pioneer.sparrowdb.storage.Database;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.TupleDesc;
import com.pioneer.sparrowdb.storage.Type;
import com.pioneer.sparrowdb.storage.file.heap.HeapFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SqlExecutor {

    public void execute(String sql) {
        SqlParser sqlParser = new SqlParser();
        QueryPlanner planner = new QueryPlanner();
        Statement statement = sqlParser.createStatement(sql);
        if (statement instanceof Query) {
            Query query = ((Query) statement);
            PlanNode planNode = planner.visitQuerySpecification((QuerySpecification) query.getQueryBody());
            doExecute(planNode);
        } else {
            System.out.println("unsupported!!");
        }
    }

    private void doExecute(PlanNode planNode) {
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

    public static void main(String[] args) {
        // construct a 3-column table schema
        Type types[] = new Type[]{Type.INT_TYPE, Type.INT_TYPE, Type.INT_TYPE};
        String names[] = new String[]{"field0", "field1", "field2"};
        TupleDesc descriptor = new TupleDesc(types, names);

        // create the table, associate it with some_data_file.dat
        // and tell the catalog about the schema of this table.
        String filePath = SqlExecutor.class.getClassLoader().getResource("data/some_data_file.dat").getPath();
        HeapFile table1 = new HeapFile(new File(filePath), descriptor);
        Database.getCatalog().addTable(table1, "test");

        String sql = "select field0,field1,field2 from test where field1=1 offset 0 limit 2";

        SqlExecutor executor = new SqlExecutor();
        executor.execute(sql);
    }
}
