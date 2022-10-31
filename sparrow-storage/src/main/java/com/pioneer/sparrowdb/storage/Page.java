package com.pioneer.sparrowdb.storage;

import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.transaction.TransactionID;

import java.util.Iterator;

/**
 * Page is the interface used to represent pages that are resident in the
 * BufferPool.  Typically, DbFiles will read and write pages from disk.
 * <p>
 * Pages may be "dirty", indicating that they have been modified since they
 * were last written out to disk.
 * <p>
 * For recovery purposes, pages MUST have a single constructor of the form:
 * Page(PageId id, byte[] data)
 */
public interface Page {

    /**
     * Return the id of this page.  The id is a unique identifier for a page
     * that can be used to look up the page on disk or determine if the page
     * is resident in the buffer pool.
     *
     * @return the id of this page
     */
    PageID getId();

    /**
     * 序列化page数据
     */
    byte[] serialize() throws StorageException;

    /**
     * 反序列化pageData
     */
    void deserialize(byte[] pageData) throws StorageException;

    /**
     * Adds the specified tuple to the page;  the tuple should be updated to reflect
     * that it is now stored on this page.
     *
     * @param tuple The tuple to add.
     * @throws StorageException if the page is full (no empty slots) or tupledesc
     *                          is mismatch.
     */
    void insertTuple(Tuple tuple)  throws StorageException;

    /**
     * Delete the specified tuple from the page;  the tuple should be updated to reflect
     * that it is no longer stored on any page.
     *
     * @param tuple The tuple to delete
     * @throws StorageException if this tuple is not on this page, or tuple slot is
     */
    void deleteTuple(Tuple tuple) throws StorageException;

    /**
     * 返回每页可存放的行数
     */
    int getMaxSlotNum();

    boolean isSlotUsed(int index);

    boolean hasEmptySlot();

    /**
     * Get the id of the transaction that last dirtied this page, or null if the page is clean..
     *
     * @return The id of the transaction that last dirtied this page, or null
     */
    TransactionID isDirty();

    /**
     * Set the dirty state of this page as dirtied by a particular transaction
     */
    void markDirty(boolean dirty, TransactionID tid);

    /**
     * 保留页原始数据
     */
    void saveBeforePage();

    /**
     * Provide a representation of this page before any modifications were made
     * to it.  Used by recovery.
     */
    Page getBeforeImage();

    Iterator<Tuple> tupleIterator();
}
