package com.pioneer.sparrowdb.storage.file.btree;

import com.pioneer.sparrowdb.storage.*;
import com.pioneer.sparrowdb.storage.exception.StorageException;

public class BTreeFile implements DBFile {

    @Override
    public DBFileType getDBFileType() {
        return DBFileType.BTREE_TUPLE_FILE;
    }

    @Override
    public int getPageSize() {
        return 0;
    }

    @Override
    public Page readPage(PageID pageId) {
        return null;
    }

    @Override
    public void writePage(Page page) {

    }

    @Override
    public void insertTuple(Tuple tuple) {

    }

    @Override
    public void deleteTuple(Tuple tuple) {

    }

    @Override
    public DBFileIterator getIterator() {
        return null;
    }

    @Override
    public String getFileID() {
        return null;
    }

    @Override
    public TupleDesc getTupleDesc() {
        return null;
    }

    private class BTreeFileIterator  implements DBFileIterator{
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
}
