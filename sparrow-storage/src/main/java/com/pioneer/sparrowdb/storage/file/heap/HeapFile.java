package com.pioneer.sparrowdb.storage.file.heap;

import com.pioneer.sparrowdb.storage.*;
import com.pioneer.sparrowdb.storage.exception.StorageException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class HeapFile implements DBFile {

    /**
     * The minimum page size is 512 bytes.
     */
    public static final int MIN_PAGESIZE = 512;

    /**
     * The maximum page size is 64K bytes.
     */
    public static final int MAX_PAGESIZE = 65536;

    /**
     * The default page size is 8K bytes.
     */
    public static final int DEFAULT_PAGESIZE = 8192;

    /**
     * The actual data file on disk.
     */
    private File dataFile;

    /**
     * This is the size of pages that are read and written to the data file.
     * This value will be a power of two, between the minimum and maximum
     * page sizes.
     */
    private int pageSize;

    @Override
    public DBFileType getDBFileType() {
        return DBFileType.HEAP_TUPLE_FILE;
    }

    @Override
    public int getPageSize() {
        return 0;
    }

    @Override
    public Page readPage(PageID pageId) {
        byte[] pageData = new byte[DEFAULT_PAGESIZE];
        try {
            FileInputStream in = new FileInputStream(dataFile);
            in.skip(pageId.getPageNumber() * DEFAULT_PAGESIZE);
            in.read(pageData);
            return new HeapPage(pageId, pageData);
        } catch (IOException e) {
            throw new StorageException("read Page from disk error", e);
        }
    }

    @Override
    public void writePage(Page page) {
        try {
            byte[] pgData = page.serialize();
            RandomAccessFile dbFile = new RandomAccessFile(dataFile, "rws");
            dbFile.skipBytes(page.getPageID().getPageNumber() * DEFAULT_PAGESIZE);
            dbFile.write(pgData);
        } catch (IOException e) {
            throw new StorageException("write page To disk error", e);
        }
    }

    @Override
    public void insertTuple(Tuple tuple) {

    }

    @Override
    public void deleteTuple(Tuple tuple) {

    }

    @Override
    public DBFileIterator getIterator() {
        return new HeapFileIterator();
    }

    @Override
    public String getFileID() {
        return null;
    }

    @Override
    public TupleDesc getTupleDesc() {
        return null;
    }

    private class HeapFileIterator implements DBFileIterator {
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
