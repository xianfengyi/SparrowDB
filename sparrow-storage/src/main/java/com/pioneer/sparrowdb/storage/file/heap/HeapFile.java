package com.pioneer.sparrowdb.storage.file.heap;

import com.pioneer.sparrowdb.storage.DBFile;

import java.io.File;

public class HeapFile implements DBFile {

    /** The minimum page size is 512 bytes. */
    public static final int MIN_PAGESIZE = 512;

    /** The maximum page size is 64K bytes. */
    public static final int MAX_PAGESIZE = 65536;

    /** The default page size is 8K bytes. */
    public static final int DEFAULT_PAGESIZE = 8192;

    /** The actual data file on disk. */
    private File dataFile;

    /**
     * This is the size of pages that are read and written to the data file.
     * This value will be a power of two, between the minimum and maximum
     * page sizes.
     */
    private int pageSize;

    @Override
    public DBFileType getDBFileType() {
        return DBFileType.HEAP_TUPLE_FILE;
    }

    @Override
    public int getPageSize() {
        return 0;
    }
}
