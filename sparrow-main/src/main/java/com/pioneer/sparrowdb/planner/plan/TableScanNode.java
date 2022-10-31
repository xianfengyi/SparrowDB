package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.SeqScan;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.exception.TransactionException;
import com.pioneer.sparrowdb.storage.transaction.TransactionID;

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

    public TableScanNode(int id, String name, TransactionID transactionId) {
        this.id = id;
        this.name = name;
        seqScan = new SeqScan(transactionId, id);
        try {
            seqScan.open();
        } catch (TransactionException e) {
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
        } catch (TransactionException e) {
            throw new RuntimeException(e);
        }
    }
}
