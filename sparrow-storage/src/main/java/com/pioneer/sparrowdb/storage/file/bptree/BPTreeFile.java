package com.pioneer.sparrowdb.storage.file.bptree;

import com.pioneer.sparrowdb.storage.*;
import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.transaction.TransactionAbortedException;
import com.pioneer.sparrowdb.storage.transaction.TransactionId;

public class BPTreeFile implements TableFile {
    @Override
    public int getTableId() {
        return 0;
    }

    @Override
    public TupleDesc getTupleDesc() {
        return null;
    }

    @Override
    public Page readPage(PageID id) throws StorageException {
        return null;
    }

    @Override
    public void writePage(Page page) throws StorageException {

    }

    @Override
    public Page insertTuple(TransactionId transactionId, Tuple tuple) throws StorageException {
        return null;
    }

    @Override
    public Page deleteTuple(TransactionId tid, Tuple t) throws StorageException, TransactionAbortedException {
        return null;
    }

    @Override
    public TableFileIterator iterator(TransactionId tid) {
        return null;
    }
}
