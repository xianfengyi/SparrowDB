package com.pioneer.sparrowdb.storage.file.btree;

import com.pioneer.sparrowdb.storage.DBFile;

public class BTreeFile implements DBFile {

    @Override
    public DBFileType getDBFileType() {
        return DBFileType.BTREE_TUPLE_FILE;
    }

    @Override
    public int getPageSize() {
        return 0;
    }
}
