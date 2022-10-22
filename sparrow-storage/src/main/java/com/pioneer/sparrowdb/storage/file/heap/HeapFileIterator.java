package com.pioneer.sparrowdb.storage.file.heap;

import com.pioneer.sparrowdb.storage.DBFileIterator;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.exception.StorageException;

import java.util.Iterator;

public class HeapFileIterator implements DBFileIterator {

    private int pagePos;

    private int numPages;

    private Iterator<Tuple> iterators;

    @Override
    public void open() throws StorageException {

    }

    @Override
    public boolean hasNext() throws StorageException {
        if(pagePos>=numPages){
            return false;
        }

        return false;
    }

    @Override
    public Tuple next() throws StorageException {
        if (!hasNext()) {
            return null;
        }
        return iterators.next();
    }

    @Override
    public void rewind() throws StorageException {

    }

    @Override
    public void close() {

    }
}
