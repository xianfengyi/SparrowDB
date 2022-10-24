package com.pioneer.sparrowdb.storage.file.btree;

import com.pioneer.sparrowdb.storage.Page;
import com.pioneer.sparrowdb.storage.PageID;
import com.pioneer.sparrowdb.storage.exception.StorageException;

public class BTreePage implements Page {
    @Override
    public PageID getPageID() {
        return null;
    }

    @Override
    public byte[] serialize() throws StorageException {
        return new byte[0];
    }

    @Override
    public void deserialize(byte[] pageData) throws StorageException {

    }

    @Override
    public byte[] getPageData() {
        return new byte[0];
    }

    @Override
    public boolean isDirty() {
        return false;
    }
}
