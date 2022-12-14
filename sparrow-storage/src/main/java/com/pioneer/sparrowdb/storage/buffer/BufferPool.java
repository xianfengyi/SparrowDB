package com.pioneer.sparrowdb.storage.buffer;

import com.pioneer.sparrowdb.storage.DataBase;
import com.pioneer.sparrowdb.storage.Page;
import com.pioneer.sparrowdb.storage.PageID;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.file.heap.HeapFile;
import com.pioneer.sparrowdb.storage.file.heap.HeapPage;
import com.pioneer.sparrowdb.storage.exception.TransactionException;
import com.pioneer.sparrowdb.storage.transaction.TransactionID;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * BufferPool manages the reading and writing of pages into memory from
 * disk. Access methods call into it to retrieve pages, and it fetches
 * pages from the appropriate location.
 * <p>
 * The BufferPool is also responsible for locking;  when a transaction fetches
 * a page, BufferPool checks that the transaction has the appropriate
 * locks to read/write the page.
 */
public class BufferPool {

    /**
     * Bytes per page, including header.
     */
    public static final int PAGE_SIZE = 4096;

    /**
     * Default number of pages passed to the constructor. This is used by
     * other classes. BufferPool should use the numPages argument to the
     * constructor instead.
     */
    public static final int DEFAULT_PAGES = 50;

    //页的最大数量
    public final int PAGES_NUM;

    //当前的缓存页
    private PageLruCache lruPagesPool;

    //当前的缓存页
    private HashMap<PageID, Page> pid2pages;

    /**
     * Creates a BufferPool that caches up to numPages pages.
     *
     * @param numPages maximum number of pages in this buffer pool.
     */
    public BufferPool(int numPages) {
        PAGES_NUM = numPages;
        lruPagesPool = new PageLruCache(PAGES_NUM);
        pid2pages = new HashMap<>(PAGES_NUM);
    }

    /**
     * Retrieve the specified page with the associated permissions.
     * Will acquire a lock and may block if that lock is held by another
     * transaction.
     * <p>
     * The retrieved page should be looked up in the buffer pool.  If it
     * is present, it should be returned.  If it is not present, it should
     * be added to the buffer pool and returned.  If there is insufficient
     * space in the buffer pool, an page should be evicted and the new page
     * should be added in its place.
     *
     * @param tid the ID of the transaction requesting the page
     * @param pid the ID of the requested page
     */
    public Page getPage(TransactionID tid, PageID pid) throws StorageException {
        HeapPage page = (HeapPage) lruPagesPool.get(pid);
        if (page != null) {//直接命中
            return page;
        }
        //未命中，访问磁盘并将其缓存
        HeapFile table = (HeapFile) DataBase.getCatalog().getDbFile(pid.getTableId());
        HeapPage newPage = (HeapPage) table.readPage(pid);
        Page removedPage = lruPagesPool.put(pid, newPage);
        if (removedPage != null) {
            try {
                flushPage(removedPage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return newPage;
    }

    /**
     * Releases the lock on a page.
     * Calling this is very risky, and may result in wrong behavior. Think hard
     * about who needs to call this and why, and why they can run the risk of
     * calling it.
     *
     * @param tid the ID of the transaction requesting the unlock
     * @param pid the ID of the page to unlock
     */
    public void releasePage(TransactionID tid, PageID pid) {
        // some code goes here
        // not necessary for proj1
    }

    /**
     * Release all locks associated with a given transaction.
     *
     * @param tid the ID of the transaction requesting the unlock
     */
    public void transactionComplete(TransactionID tid) throws IOException {
        // some code goes here
        // not necessary for proj1
    }

    /**
     * Return true if the specified transaction has a lock on the specified page
     */
    public boolean holdsLock(TransactionID tid, PageID p) {
        // some code goes here
        // not necessary for proj1
        return false;
    }

    /**
     * Commit or abort a given transaction; release all locks associated to
     * the transaction.
     *
     * @param tid    the ID of the transaction requesting the unlock
     * @param commit a flag indicating whether we should commit or abort
     */
    public void transactionComplete(TransactionID tid, boolean commit) throws IOException {
        // some code goes here
        // not necessary for proj1
    }

    /**
     * Add a tuple to the specified table behalf of transaction tid.  Will
     * acquire a write lock on the page the tuple is added to(Lock
     * acquisition is not needed for lab2). May block if the lock cannot
     * be acquired.
     * <p>
     * Marks any pages that were dirtied by the operation as dirty by calling
     * their markDirty bit, and updates cached versions of any pages that have
     * been dirtied so that future requests see up-to-date pages.
     *
     * @param tid     the transaction adding the tuple
     * @param tableId the table to add the tuple to
     * @param t       the tuple to add
     */
    public void insertTuple(TransactionID tid, int tableId, Tuple t) throws StorageException, IOException, TransactionException {
        HeapFile table = (HeapFile) DataBase.getCatalog().getDbFile(tableId);
        Page page = table.insertTuple(tid, t);
        page.markDirty(true, tid);
    }

    /**
     * Remove the specified tuple from the buffer pool.
     * Will acquire a write lock on the page the tuple is removed from. May block if
     * the lock cannot be acquired.
     * <p>
     * Marks any pages that were dirtied by the operation as dirty by calling
     * their markDirty bit.  Does not need to update cached versions of any pages that have
     * been dirtied, as it is not possible that a new page was created during the deletion
     * (note difference from addTuple).
     *
     * @param tid the transaction adding the tuple.
     * @param t   the tuple to add
     */
    public void deleteTuple(TransactionID tid, Tuple t) throws StorageException, TransactionException {
        int tableId = t.getRecordId().getPageId().getTableId();
        HeapFile table = (HeapFile) DataBase.getCatalog().getDbFile(tableId);
        Page affectedPage = table.deleteTuple(tid, t);
        affectedPage.markDirty(true, tid);
    }

    /**
     * Flush all dirty pages to disk.
     * NB: Be careful using this routine -- it writes dirty data to disk so will
     * break simpledb if running in NO STEAL mode.
     */
    public synchronized void flushAllPages() throws IOException {
        Iterator<Page> it = lruPagesPool.iterator();
        while (it.hasNext()) {
            Page p = it.next();
            if (p.isDirty() != null) {
                flushPage(p);
            }
        }
    }

    /**
     * Remove the specific page id from the buffer pool.
     * Needed by the recovery manager to ensure that the
     * buffer pool doesn't keep a rolled back page in its
     * cache.
     */
    public synchronized void discardPage(PageID pid) {
        lruPagesPool.removePage(pid);
    }

    /**
     * Flushes a certain page to disk
     *
     * @param page an ID indicating the page to flush
     */
    private synchronized void flushPage(Page page) throws IOException {
        HeapPage dirty_page = (HeapPage) page;
        HeapFile table = (HeapFile) DataBase.getCatalog().getDbFile(page.getId().getTableId());
        table.writePage(dirty_page);
        dirty_page.markDirty(false, null);
    }

    /**
     * Write all pages of the specified transaction to disk.
     */
    public synchronized void flushPages(TransactionID tid) throws IOException {
        Iterator<Page> it = lruPagesPool.iterator();
        while (it.hasNext()) {
            Page p = it.next();
            if (p.isDirty() != null && p.isDirty().equals(tid)) {
                flushPage(p);
                if (p.isDirty() == null) {
                    p.saveBeforePage();
                }
            }
        }
    }

    /**
     * 丢弃脏页
     */
    public void discardPages(List<PageID> pageIDs) {
        if (Objects.isNull(pageIDs) || pageIDs.isEmpty()) {
            System.out.println("discardPages : pageIDs is null or empty ");
            return;
        }
        for (PageID pageID : pageIDs) {
            lruPagesPool.removePage(pageID);
        }
    }
}
