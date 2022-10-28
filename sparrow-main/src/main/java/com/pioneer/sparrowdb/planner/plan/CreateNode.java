package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.Database;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.TupleDesc;
import com.pioneer.sparrowdb.storage.Type;
import com.pioneer.sparrowdb.storage.file.heap.HeapFile;
import com.pioneer.sparrowdb.storage.model.DbTable;
import com.pioneer.sparrowdb.storage.transaction.TransactionAbortedException;

import java.io.File;
import java.io.IOException;

public class CreateNode extends PlanNode {

    private DbTable dbTable;

    public CreateNode(DbTable dbTable) {
        this.dbTable = dbTable;
    }

    public void execute() throws TransactionAbortedException {
        int len = dbTable.getColumns().size();
        Type types[] = new Type[len];
        String names[] = new String[len];

        int i=0;
        for(DbTable.Column column:dbTable.getColumns()){
            if(column.getColumnType().toLowerCase().equals("integer")){
                types[i]= Type.INT_TYPE;
            }
            names[i]=column.getColumnName();
            i++;
        }
        TupleDesc descriptor = new TupleDesc(types, names);
        try {
            String datFilePath = "data/" + dbTable.getName() + "_file.dat";
            File file = new File(datFilePath);
            if (!file.exists()){
                file.createNewFile();
            }
            HeapFile table1 = new HeapFile(new File(datFilePath), descriptor);
            Database.getCatalog().addTable(table1, dbTable.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void prepare() {

    }

    @Override
    public Tuple getNextTuple() throws IllegalStateException {
        return null;
    }
}
