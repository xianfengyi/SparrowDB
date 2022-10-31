package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.DataBase;
import com.pioneer.sparrowdb.storage.DbIterator;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.TupleDesc;
import com.pioneer.sparrowdb.storage.exception.TransactionException;
import com.pioneer.sparrowdb.storage.transaction.TransactionID;

import java.io.IOException;

public class InsertNode extends PlanNode {

    private TransactionID transactionId;

    private TupleDesc tupleDesc;

    private DbIterator dbIterator;

    private int tableId;

    private int insertCount;

    public InsertNode(DbIterator dbIterator, int tableId, TransactionID transactionId) {
        this.dbIterator = dbIterator;
        this.tableId = tableId;
        this.transactionId = transactionId;
    }

    public void execute() throws TransactionException {
        while (dbIterator.hasNext()) {
            Tuple next = dbIterator.next();
            try {
                DataBase.getBufferPool().insertTuple(transactionId, tableId, next);
                insertCount++;
            } catch (IOException e) {
                e.printStackTrace();
            }
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
