package com.pioneer.sparrowdb.storage.transaction;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TransactionId is a class that contains the identifier of a transaction.
 */
public class TransactionID implements Serializable {

	private static final long serialVersionUID = 1L;
	
	static AtomicLong counter = new AtomicLong(0);
    long myid;

    public TransactionID() {
        myid = counter.getAndIncrement();
    }

    public long getId() {
        return myid;
    }

    public boolean equals(Object tid) {
        return ((TransactionID)tid).myid == myid;
    }

    public int hashCode() {
        return (int) myid;
    }
}
