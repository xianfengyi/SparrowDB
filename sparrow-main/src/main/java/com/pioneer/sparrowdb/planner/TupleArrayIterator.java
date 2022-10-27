package com.pioneer.sparrowdb.planner;

import com.pioneer.sparrowdb.storage.DbIterator;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.TupleDesc;
import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.transaction.TransactionAbortedException;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TupleArrayIterator implements DbIterator {
    private List<Tuple> tuples;

    private Iterator<Tuple> iterator;

    @Override
    public void open() throws StorageException, TransactionAbortedException {
        iterator = tuples.iterator();
    }

    @Override
    public boolean hasNext() throws StorageException, TransactionAbortedException {
        return iterator.hasNext();
    }

    @Override
    public Tuple next() throws StorageException, TransactionAbortedException, NoSuchElementException {
        return iterator.next();
    }

    @Override
    public void rewind() throws StorageException, TransactionAbortedException {
        iterator = tuples.iterator();
    }

    @Override
    public TupleDesc getTupleDesc() {
        return tuples.get(0).getTupleDesc();
    }

    @Override
    public void close() {

    }
}
