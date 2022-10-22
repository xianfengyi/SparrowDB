package com.pioneer.sparrowdb.storage.file.heap;

import com.pioneer.sparrowdb.storage.DBPage;

public class HeapPage implements DBPage {
    @Override
    public int getTableId() {
        return 0;
    }

    @Override
    public int getPageNo() {
        return 0;
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
