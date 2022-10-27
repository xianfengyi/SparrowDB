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

    private int insertCount;

    public InsertNode(DbIterator dbIterator) {
        this.dbIterator = dbIterator;
    }

    public void execute() throws TransactionAbortedException {
        while (dbIterator.hasNext()) {
            Tuple next = dbIterator.next();
            try {
                // FIXME: now, the table is a fix value
                int tableId = 1;
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
