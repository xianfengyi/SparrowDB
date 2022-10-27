package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.Database;
import com.pioneer.sparrowdb.storage.DbIterator;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.transaction.TransactionAbortedException;
import com.pioneer.sparrowdb.storage.transaction.TransactionId;

public class DeleteNode extends PlanNode {

    private TransactionId tid;

    private DbIterator dbIterator;

    private int deleteCount;

    public DeleteNode(DbIterator dbIterator) {
        this.dbIterator = dbIterator;
    }

    public void execute() throws TransactionAbortedException {
        while (dbIterator.hasNext()) {
            Tuple next = dbIterator.next();
            Database.getBufferPool().deleteTuple(tid, next);
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
