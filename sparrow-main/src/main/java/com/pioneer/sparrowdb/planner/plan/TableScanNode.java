package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.SeqScan;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.transaction.TransactionAbortedException;
import com.pioneer.sparrowdb.storage.transaction.TransactionId;

public class TableScanNode extends PlanNode {

    /**
     * The table identifier to retrieve a DbFile
     */
    public int id;

    /**
     * The name (alias) of the table as it is used in the query
     */
    public String name;

    private SeqScan seqScan;

    public TableScanNode(int id, String name, TransactionId transactionId) {
        this.id = id;
        this.name = name;
        seqScan = new SeqScan(transactionId, 1);
        try {
            seqScan.open();
        } catch (TransactionAbortedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void prepare() {

    }

    @Override
    public Tuple getNextTuple() throws IllegalStateException {
        try {
            if (seqScan.hasNext()) {
                return seqScan.next();
            } else {
                seqScan.close();
                return null;
            }
        } catch (TransactionAbortedException e) {
            throw new RuntimeException(e);
        }
    }
}
