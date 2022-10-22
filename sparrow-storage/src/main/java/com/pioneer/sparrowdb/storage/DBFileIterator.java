package com.pioneer.sparrowdb.storage;

import com.pioneer.sparrowdb.storage.exception.StorageException;

public interface DBFileIterator {

    /**
     * Opens the iterator
     *
     * @throws StorageException when there are problems opening/accessing the database.
     */
    void open() throws StorageException;

    /**
     * @return true if there are more tuples available.
     */
    boolean hasNext() throws StorageException;

    /**
     * Gets the next tuple from the operator (typically implementing by reading
     * from a child operator or an access method).
     */
    Tuple next() throws StorageException;

    /**
     * Resets the iterator to the start.
     *
     * @throws StorageException When rewind is unsupported.
     */
    void rewind() throws StorageException;

    /**
     * Closes the iterator.
     */
    void close();
}
