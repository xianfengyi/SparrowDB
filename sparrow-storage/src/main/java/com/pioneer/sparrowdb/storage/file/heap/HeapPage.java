package com.pioneer.sparrowdb.storage.file.heap;

import com.pioneer.sparrowdb.storage.*;
import com.pioneer.sparrowdb.storage.exception.StorageException;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class HeapPage implements Page {

    private PageID pageId;

    private Tuple[] tuples;

    private TupleDesc tupleDesc;

    private int maxSlotNum;

    private boolean[] slotUsageStatusBitMap;

    private byte[] beforePageData;

    public HeapPage(PageID pageID, byte[] pageData){
        this.pageId = pageID;
        this.tupleDesc = StorageManager.getInstance().getCatalogManager().getTupleDesc(pageID.getTableID());
        this.tuples = new Tuple[this.maxSlotNum];
        this.slotUsageStatusBitMap = new boolean[this.maxSlotNum];
        deserialize(pageData);
    }

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
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(pageData));
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
