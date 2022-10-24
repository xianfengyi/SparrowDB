package com.pioneer.sparrowdb.storage;

/**
 * The Storage Manager provides facilities for managing files of tuples,
 * including in-memory buffering of data pages and support for transactions.
 */
public class StorageManager {

    private static StorageManager instance = new StorageManager();

    private CatalogManager catalogManager;
    private BufferPool bufferPool;

    private StorageManager() {
        catalogManager = new CatalogManager();
        bufferPool = new BufferPool();
    }

    public static StorageManager getInstance() {
        return instance;
    }

    public CatalogManager getCatalogManager() {
        return instance.catalogManager;
    }

    public BufferPool getBufferPool() {
        return instance.bufferPool;
    }
}
