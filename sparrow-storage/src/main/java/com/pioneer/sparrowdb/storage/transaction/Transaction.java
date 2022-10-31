package com.pioneer.sparrowdb.storage.transaction;

import com.pioneer.sparrowdb.storage.DataBase;
import com.pioneer.sparrowdb.storage.Page;
import com.pioneer.sparrowdb.storage.PageID;
import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.logging.RedoLogFile;

import java.io.IOException;
import java.util.List;

public class Transaction {

    /**
     * 事务ID对象
     */
    private TransactionID transactionId;

    /**
     * 事务使用的锁
     */
    private Lock.LockType lockType;

    /**
     * 构造事务,事务ID自增
     */
    public Transaction(Lock.LockType lockType) {
        this.transactionId = new TransactionID();
        this.lockType = lockType;
    }

    public TransactionID getTransactionId() {
        return transactionId;
    }

    public Lock.LockType getLockType() {
        return lockType;
    }

    public void setLockType(Lock.LockType lockType) {
        this.lockType = lockType;
    }

    public void start() {
        DataBase.getUndoLogFile().recordTxStart(transactionId);

        try {
            DataBase.getRedoLogFile().recordTxStart(transactionId);
        } catch (IOException e) {
            throw new StorageException(" redo log recordTxStart error ", e);
        }
    }

    /**
     * 提交事务
     * 根据2PL协议，提交事务时需要释放锁
     * NO-STEAL/force策略，所以事务提交时需要将脏页刷盘，事务提交前要确保脏页不被刷盘。
     * <p>
     * STEAL/No-force策略，事务提交，脏页也可不刷盘
     */
    public void commit() {
        // STEAL/No-force策略，事务提交，脏页也可不刷盘,需记录日志到redolog
        try {
            RedoLogFile redoLogFile = DataBase.getRedoLogFile();
            redoLogFile.recordTxCommit(transactionId);
            List<Page> pages = DataBase.getLockManager().getPages(transactionId);
            for (Page page : pages) {
                if (page.isDirty()!=null) {
                    redoLogFile.recordPageChange(transactionId, page.getBeforeImage(), page);
                }
            }
            redoLogFile.flush();
        } catch (IOException e) {
            throw new StorageException("redo log recordTxCommit error", e);
        }
        List<PageID> pageIDs = DataBase.getLockManager().getPageIDs(transactionId);
        // 事务提交后更新页快照
        for (PageID pageID : pageIDs) {
            Page page = DataBase.getBufferPool().getPage(transactionId,pageID);
            page.saveBeforePage();
        }

        // 释放锁
        DataBase.getLockManager().releaseLock(transactionId);
    }

    /**
     * 终止事务，并回滚事务中修改的的脏页
     * 由于NO-STEAL策略，事务提交前脏页都没有刷盘，直接丢弃缓冲池中的相关页即可
     */
    public void abort() {
        // NO-Steal/force策略
        // List<PageID> pageIDs = DataBase.getLockManager().getPageIDs(transactionId);
        // DataBase.getBufferPool().discardPages(pageIDs);

        // Steal/No-force策略
        // 将事务修改过的页面，在磁盘刷回原始版本，缓存中丢弃
        DataBase.getUndoLogFile().rollback(transactionId);

        // 释放锁
        DataBase.getLockManager().releaseLock(transactionId);
    }

    @Override
    public String toString() {
        return "[" +
                "transactionId=" + transactionId +
                ", lockType=" + lockType +
                ']';
    }

}
