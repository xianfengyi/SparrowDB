package com.pioneer.sparrowdb.storage;

import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.transaction.TransactionAbortedException;
import com.pioneer.sparrowdb.storage.transaction.TransactionId;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * The interface for database files on disk. Each table is represented by a
 * single TableFile.
 */
public interface TableFile extends Serializable {

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

     Page insertTuple(TransactionId tid, Tuple t) throws StorageException

    /**
     * Removes the specifed tuple from the file on behalf of the specified
     * transaction.
     * This method will acquire a lock on the affected pages of the file, and
     * may block until the lock can be acquired.
     *
     * @throws StorageException if the tuple cannot be deleted or is not a member
     *                          of the file
     */
    Page deleteTuple(TransactionId tid, Tuple t) throws StorageException, TransactionAbortedException;

    /**
     * Returns an iterator over all the tuples stored in this DbFile. The
     * iterator must use {@link BufferPool#getPage}, rather than
     * {@link #readPage} to iterate through the pages.
     *
     * @return an iterator over all the tuples stored in this DbFile.
     */
    DbFileIterator iterator(TransactionId tid);

    /**
     * Returns a unique ID used to identify this DbFile in the Catalog. This id
     * can be used to look up the table via {@link Catalog#getDbFile} and
     * {@link Catalog#getTupleDesc}.
     * <p>
     * Implementation note:  you will need to generate this tableid somewhere,
     * ensure that each HeapFile has a "unique id," and that you always
     * return the same value for a particular HeapFile. A simple implementation
     * is to use the hash code of the absolute path of the file underlying
     * the HeapFile, i.e. <code>f.getAbsoluteFile().hashCode()</code>.
     *
     * @return an ID uniquely identifying this HeapFile.
     */
    int getId();
}
