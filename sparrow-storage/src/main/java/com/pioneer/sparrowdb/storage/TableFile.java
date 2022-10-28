package com.pioneer.sparrowdb.storage;

import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.transaction.TransactionAbortedException;
import com.pioneer.sparrowdb.storage.transaction.TransactionId;

import java.io.Serializable;

/**
 * The interface for database files on disk. Each table is represented by a
 * single TableFile.
 */
public interface TableFile extends Serializable {

    /**
     * Returns a unique ID used to identify this TableFile
     *
     * @return an ID uniquely identifying this HeapFile.
     */
    int getTableId();

    /**
     * Returns the TupleDesc of the table stored in this TableFile.
     *
     * @return TupleDesc of this DbFile.
     */
    TupleDesc getTupleDesc();

    /**
     * Read the specified page from disk.
     *
     * @throws StorageException if read page fail
     */
    Page readPage(PageID id) throws StorageException;

    /**
     * Push the specified page to disk.
     *
     * @param page The page to write.  page.getId().pageno() specifies the offset into the file where the page should be
     *             written.
     * @throws StorageException if the write fails
     */
    void writePage(Page page) throws StorageException;

    /**
     * Insert tuple into page and return the affect page
     *
     * @param transactionId transaction id
     * @param tuple         the taget tuple
     * @return Page the affect page
     * @throws StorageException if insert fail, throw this exception
     */
    Page insertTuple(TransactionId transactionId, Tuple tuple) throws StorageException;

    /**
     * Removes the specifed tuple from the file on behalf of the specified
     * transaction.
     *
     * @throws StorageException if the tuple cannot be deleted or is not a member
     *                          of the file
     */
    Page deleteTuple(TransactionId tid, Tuple t) throws StorageException, TransactionAbortedException;

    /**
     * Returns an iterator over all the tuples stored in this TableFile. The
     * iterator must use {@link BufferPool#getPage}, rather than
     * {@link #readPage} to iterate through the pages.
     *
     * @return an iterator over all the tuples stored in this DbFile.
     */
    TableFileIterator iterator(TransactionId tid);
}
