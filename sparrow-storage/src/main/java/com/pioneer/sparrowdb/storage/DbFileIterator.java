package com.pioneer.sparrowdb.storage;

import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.transaction.TransactionAbortedException;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * DbFileIterator is the iterator interface that all SimpleDB Dbfile should
 * implement.
 */
public interface DbFileIterator extends Serializable {
    /**
     * Opens the iterator
     *
     * @throws StorageException when there are problems opening/accessing the database.
     */
    void open() throws StorageException, TransactionAbortedException;

    /**
     * @return true if there are more tuples available.
     */
    boolean hasNext() throws StorageException, TransactionAbortedException;

    /**
     * Gets the next tuple from the operator (typically implementing by reading
     * from a child operator or an access method).
     *
     * @return The next tuple in the iterator.
     * @throws NoSuchElementException if there are no more tuples
     */
    Tuple next() throws StorageException, TransactionAbortedException, NoSuchElementException;

    /**
     * Resets the iterator to the start.
     *
     * @throws StorageException When rewind is unsupported.
     */
    void rewind() throws StorageException, TransactionAbortedException;

    /**
     * Closes the iterator.
     */
    void close();
}
