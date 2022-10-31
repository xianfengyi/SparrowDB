package com.pioneer.sparrowdb.storage.transaction;

import com.pioneer.sparrowdb.storage.PageID;

import java.util.HashSet;
import java.util.Set;

public class Lock {
    /**
     * 锁类型枚举
     */
    public enum LockType {
        /**
         * 共享锁
         */
        SLock,

        /**
         * 独占锁
         */
        XLock
    }

    /**
     * 被锁的页
     */
    private PageID pageID;

    /**
     * 锁类型
     */
    private LockType lockType;

    /**
     * 持有该锁的事务
     */
    private Set<TransactionID> lockHolders;

    public Lock(PageID pageID, LockType lockType) {
        this.pageID = pageID;
        this.lockType = lockType;
        lockHolders = new HashSet<>();
    }

    public void setLockType(LockType lockType) {
        this.lockType = lockType;
    }

    public LockType getLockType() {
        return lockType;
    }

    /**
     * 添加持有锁的事务
     */
    public void addHolder(TransactionID transactionID) {
        lockHolders.add(transactionID);
    }

    public Set<TransactionID> getLockHolders() {
        return lockHolders;
    }
}
