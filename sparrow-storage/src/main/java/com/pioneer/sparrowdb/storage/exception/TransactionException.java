package com.pioneer.sparrowdb.storage.exception;

/**
 * Exception that is thrown when a transaction fail.
 */
public class TransactionException extends StorageException {

    /**
     * Construct a transaction exception with no message.
     */
    public TransactionException() {
        super();
    }

    /**
     * Construct a transaction exception with the specified message.
     */
    public TransactionException(String msg) {
        super(msg);
    }

    /**
     * Construct a transaction exception with the specified cause and no message.
     */
    public TransactionException(Throwable cause) {
        super(cause);
    }

    /**
     * Construct a transaction exception with the specified message and cause.
     */
    public TransactionException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
