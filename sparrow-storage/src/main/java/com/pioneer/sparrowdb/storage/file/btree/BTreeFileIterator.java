package com.pioneer.sparrowdb.storage.file.btree;

import com.pioneer.sparrowdb.storage.DBFileIterator;
import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.Tuple;

public class BTreeFileIterator implements DBFileIterator {
    @Override
    public void open() throws StorageException {

    }

    @Override
    public boolean hasNext() throws StorageException {
        return false;
    }

    @Override
    public Tuple next() throws StorageException {
        return null;
    }

    @Override
    public void rewind() throws StorageException {

    }

    @Override
    public void close() {

    }
}
