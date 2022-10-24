package com.pioneer.sparrowdb.storage;

public interface DBFile {
    /**
     * The minimum page size is 512 bytes.
     */
    int MIN_PAGESIZE = 512;

    /**
     * The maximum page size is 64K bytes.
     */
    int MAX_PAGESIZE = 65536;

    /**
     * The default page size is 8K bytes.
     */
    int DEFAULT_PAGESIZE = 8192;

    String getFileID();

    /**
     * Get DB file type.
     *
     * @return DBFileType
     */
    DBFileType getDBFileType();

    /**
     * This is the size of pages that are read and written to the data file.
     * This value will be a power of two, between the minimum and maximum
     * page sizes.
     */
    int getPageSize();

    Page readPage(PageID pageId);

    void writePage(Page page);

    void insertTuple(Tuple tuple);

    void deleteTuple(Tuple tuple);

    TupleDesc getTupleDesc();

    DBFileIterator getIterator();

    enum DBFileType {

        /**
         * Represents a heap tuple file, which supports variable-size tuples and
         * stores them in no particular order.
         */
        HEAP_TUPLE_FILE(1),

        /**
         * Represents a B<sup>+</sup> tree tuple file that keeps tuples in a
         * particular sequential order.
         */
        BTREE_TUPLE_FILE(10),

        /**
         * Represents a transaction-state file used for write-ahead logging and
         * recovery.
         */
        TXNSTATE_FILE(50),

        /**
         * Represents a write-ahead log file used for transaction processing and
         * recovery.
         */
        WRITE_AHEAD_LOG_FILE(51),

        /**
         * Represents a file used during testing.
         */
        TEST_FILE(100);

        /**
         * A numeric ID that uniquely identifies this database file type.
         */
        private int id;

        /**
         * Initialize a {@code DBFileType} enum with the specified ID value.
         */
        DBFileType(int id) {
            this.id = id;
        }

        /**
         * Returns the numeric ID of this {@code DBFileType} enum.
         */
        public int getID() {
            return id;
        }

        /**
         * Given a numeric type ID, returns the corresponding type value for the ID,
         * or <tt>null</tt> if no type corresponds to the ID.
         *
         * @param id the numeric ID of the type to retrieve
         * @return the type-value with that ID, or <tt>null</tt> if not found
         */
        public static DBFileType valueOf(int id) {
            for (DBFileType type : values()) {
                if (type.id == id) return type;
            }
            return null;
        }
    }
}
