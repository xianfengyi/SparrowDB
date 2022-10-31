package com.pioneer.sparrowdb.storage.file.heap;


import com.pioneer.sparrowdb.storage.*;
import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.exception.TransactionException;
import com.pioneer.sparrowdb.storage.transaction.TransactionID;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * HeapFile is an implementation of a TableFile that stores a collection of tuples in no particular order.
 * Tuples are stored on pages, each of which is a fixed size, and the file is simply a collection of those pages.
 *
 * <p>
 * HeapFile works closely with HeapPage. The format of HeapPages is described in the HeapPage constructor.
 * </p>
 */
public class HeapFile implements TableFile {

    private TupleDesc tupleDesc;

    private File file;

    public HeapFile(File file, TupleDesc tupleDesc) {
        this.file = file;
        this.tupleDesc = tupleDesc;
    }

    @Override
    public int getTableId() {
        return this.file.getAbsoluteFile().hashCode();
    }

    @Override
    public TupleDesc getTupleDesc() {
        return tupleDesc;
    }

    @Override
    public Page readPage(PageID pageID) throws StorageException {
        Page page = null;
        byte[] data = new byte[BufferPool.PAGE_SIZE];

        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            // page在HeapFile的偏移量
            int pos = pageID.getPageNo() * BufferPool.PAGE_SIZE;
            raf.seek(pos);
            raf.read(data, 0, data.length);
            page = new HeapPage((HeapPageId) pageID, data);
        } catch (IOException e) {
            throw new StorageException(e);
        }
        return page;
    }

    @Override
    public void writePage(Page page) throws StorageException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(page.getId().getPageNo() * BufferPool.PAGE_SIZE);
            byte[] data = page.serialize();
            raf.write(data);
        } catch (IOException exp) {
            throw new StorageException(exp);
        }
    }

    @Override
    public Page insertTuple(TransactionID transactionId, Tuple tuple) throws StorageException {
        int curPageCount = this.getPageCount();
        HeapPage heapPage = null;
        if (curPageCount == 0) {
            PageID pageID = new HeapPageId(this.getTableId(), 0);
            heapPage = new HeapPage((HeapPageId)pageID, HeapPage.createEmptyPageData());
            writePage(heapPage);
            heapPage = (HeapPage) Database.getBufferPool().getPage(transactionId, pageID);
        } else {
            heapPage = (HeapPage) getFirstPageHasEmptySlot(transactionId, curPageCount);
        }
        heapPage.insertTuple(tuple);
        return heapPage;
    }

    @Override
    public Page deleteTuple(TransactionID tid, Tuple tuple) throws StorageException {
        PageID pid = tuple.getRecordId().getPageId();
        HeapPage page = (HeapPage) Database.getBufferPool().getPage(tid, pid);
        page.deleteTuple(tuple);
        return page;
    }

    @Override
    public TableFileIterator iterator(TransactionID tid) {
        return new HeapFileIterator(tid);
    }

    private int getPageCount() {
        return (int) file.length() / BufferPool.PAGE_SIZE;
    }

    private Page getFirstPageHasEmptySlot(TransactionID tid, int curPageCount) {
        for (int pageNo = 0; pageNo < curPageCount; pageNo++) {
            HeapPageId heapPageId = new HeapPageId(this.getTableId(), pageNo);
            HeapPage heapPage = (HeapPage) Database.getBufferPool().getPage(tid, heapPageId);
            if (heapPage.hasEmptySlot()) {
                return heapPage;
            }
        }
        return null;
    }

    private class HeapFileIterator implements TableFileIterator {

        private int pagePos;

        private Iterator<Tuple> tuplesInPage;

        private TransactionID tid;

        public HeapFileIterator(TransactionID tid) {
            this.tid = tid;
        }

        public Iterator<Tuple> getTuplesInPage(HeapPageId pid) throws StorageException {
            HeapPage page = (HeapPage) Database.getBufferPool().getPage(tid, pid);
            return page.tupleIterator();
        }

        @Override
        public void open() throws StorageException, TransactionException {
            pagePos = 0;
            HeapPageId pid = new HeapPageId(getTableId(), pagePos);
            tuplesInPage = getTuplesInPage(pid);
        }

        @Override
        public boolean hasNext() throws StorageException, TransactionException {
            if (tuplesInPage == null) {
                return false;
            }
            if (tuplesInPage.hasNext()) {
                return true;
            }
            if (pagePos < getPageCount()) {
                pagePos++;
                HeapPageId pid = new HeapPageId(getTableId(), pagePos);
                tuplesInPage = getTuplesInPage(pid);
                return tuplesInPage.hasNext();
            } else return false;
        }

        @Override
        public Tuple next() throws StorageException, TransactionException, NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("not opened or no tuple remained");
            }
            return tuplesInPage.next();
        }

        @Override
        public void rewind() throws StorageException, TransactionException {
            open();
        }

        @Override
        public void close() {
            pagePos = 0;
            tuplesInPage = null;
        }
    }
}
