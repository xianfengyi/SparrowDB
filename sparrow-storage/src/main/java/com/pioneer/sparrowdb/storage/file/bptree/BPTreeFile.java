package com.pioneer.sparrowdb.storage.file.bptree;

import com.pioneer.sparrowdb.storage.*;
import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.exception.TransactionException;
import com.pioneer.sparrowdb.storage.transaction.TransactionID;

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
    public Page insertTuple(TransactionID transactionId, Tuple tuple) throws StorageException {
        return null;
    }

    @Override
    public Page deleteTuple(TransactionID tid, Tuple t) throws StorageException, TransactionException {
        return null;
    }

    @Override
    public TableFileIterator iterator(TransactionID tid) {
        return null;
    }
}
