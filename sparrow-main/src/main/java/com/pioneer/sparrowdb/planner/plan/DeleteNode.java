package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.Database;
import com.pioneer.sparrowdb.storage.DbIterator;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.exception.TransactionException;
import com.pioneer.sparrowdb.storage.transaction.TransactionID;

public class DeleteNode extends PlanNode {

    private TransactionID transactionId;

    private DbIterator dbIterator;

    private int deleteCount;

    public DeleteNode(DbIterator dbIterator, TransactionID tid) {
        this.dbIterator = dbIterator;
        this.transactionId = tid;
    }

    public void execute() throws TransactionException {
        while (dbIterator.hasNext()) {
            Tuple next = dbIterator.next();
            Database.getBufferPool().deleteTuple(transactionId, next);
            deleteCount++;
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
