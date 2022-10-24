package com.pioneer.sparrowdb.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BufferPool {

    private ConcurrentHashMap<PageID, Page> pool;

    private int pageCapacity;

    private static final int DEFAULT_CAPACITY = 100;

    public BufferPool() {
        this(DEFAULT_CAPACITY);
    }

    public BufferPool(int pageCapacity) {
        this.pageCapacity = pageCapacity;
    }

    public Page getPage(PageID pageID) {
        Page page = pool.get(pageID);
        if (page == null) {
            if (isFull()) {
                // 驱逐页面
                this.evictPages();
            }
            pool.put(pageID, page);
        }
        return page;
    }

    private boolean isFull() {
        return pool.size() >= DEFAULT_CAPACITY;
    }

    private void evictPages() {
        for (Map.Entry<PageID, Page> entry : pool.entrySet()) {
            Page page = entry.getValue();

            flushPage(page);
            pool.remove(page.getPageID());
        }
    }

    private void flushPage(Page page) {
    }
}
