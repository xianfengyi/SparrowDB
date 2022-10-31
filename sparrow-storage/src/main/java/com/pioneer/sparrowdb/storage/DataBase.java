package com.pioneer.sparrowdb.storage;

import com.pioneer.sparrowdb.storage.logging.RedoLogFile;
import com.pioneer.sparrowdb.storage.logging.UndoLogFile;
import com.pioneer.sparrowdb.storage.transaction.LockManager;

import java.io.File;

/**
 * Database is a class that initializes several static
 * variables used by the database system (the catalog, the buffer pool,
 * and the log files, in particular.)
 * <p>
 * Provides a set of methods that can be used to access these variables
 * from anywhere.
 */

public class DataBase {

    private static DataBase _instance = new DataBase();

    /**
     * 数据目录
     */
    private final Catalog catalog;

    /**
     * 缓冲池
     */
    private BufferPool bufferPool;

    /**
     * 锁管理器
     */
    private final LockManager lockManager;

    /**
     * undo 日志
     */
    private final UndoLogFile undoLogFile;

    /**
     * redo 日志
     */
    private final RedoLogFile redoLogFile;

    private DataBase() {
        this.catalog = new Catalog();
        this.bufferPool = new BufferPool(BufferPool.DEFAULT_PAGES);
        this.lockManager = new LockManager();
        this.undoLogFile = new UndoLogFile(new File("undo"));
        this.redoLogFile = new RedoLogFile(new File("redo"));
    }

    /**
     * reset the database, used for unit tests only.
     */
    public static void reset() {
        _instance = new DataBase();
    }

    public static Catalog getCatalog() {
        return _instance.catalog;
    }

    public static BufferPool getBufferPool() {
        return _instance.bufferPool;
    }

    public static LockManager getLockManager() {
        return _instance.lockManager;
    }

    public static UndoLogFile getUndoLogFile() {
        return _instance.undoLogFile;
    }

    public static RedoLogFile getRedoLogFile() {
        return _instance.redoLogFile;
    }

}
