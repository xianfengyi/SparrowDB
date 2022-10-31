package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.Database;
import com.pioneer.sparrowdb.storage.DbIterator;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.TupleDesc;
import com.pioneer.sparrowdb.storage.transaction.TransactionAbortedException;
import com.pioneer.sparrowdb.storage.transaction.TransactionId;

import java.io.IOException;

public class InsertNode extends PlanNode {

    private TransactionId transactionId;

    private TupleDesc tupleDesc;

    private DbIterator dbIterator;

    private int tableId;

    private int insertCount;

    public InsertNode(DbIterator dbIterator, int tableId, TransactionId transactionId) {
        this.dbIterator = dbIterator;
        this.tableId = tableId;
        this.transactionId = transactionId;
    }

    public void execute() throws TransactionAbortedException {
        while (dbIterator.hasNext()) {
            Tuple next = dbIterator.next();
            try {
                Database.getBufferPool().insertTuple(transactionId, tableId, next);
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
