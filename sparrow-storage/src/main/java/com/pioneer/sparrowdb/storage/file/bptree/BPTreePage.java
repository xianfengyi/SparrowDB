package com.pioneer.sparrowdb.storage.file.bptree;

import com.pioneer.sparrowdb.storage.Page;
import com.pioneer.sparrowdb.storage.PageID;
import com.pioneer.sparrowdb.storage.TupleDesc;
import com.pioneer.sparrowdb.storage.exception.StorageException;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class BPTreePage implements Page {

    /**
     * 页ID
     */
    protected BPTreePageID pageID;

    /**
     * 父节点pageNo,可能是internal节点或者是rootPtr节点
     */
    protected int parentPageNo;

    /**
     * 索引字段在表结构中的下标
     */
    protected int keyFieldIndex;

    /**
     * 表结构
     */
    protected TupleDesc tupleDesc;

    /**
     * 原始页数据
     */
    protected byte[] beforePageData;

    @Override
    public PageID getId() {
        return pageID;
    }

    @Override
    public void saveBeforePage() {
        try {
            beforePageData = this.serialize().clone();
        } catch (Exception e) {
            throw new StorageException("save before page error", e);
        }
    }

    /**
     * 向dos中填充指定数量的字节
     *
     * @param dos      DataOutputStream
     * @param bytesNum 填充的字节数量
     * @throws IOException write byte error
     */
    protected void fillBytes(DataOutputStream dos, int bytesNum) throws IOException {
        if (dos == null) {
            throw new StorageException("fill bytes error: stream is closed ");
        }
        byte[] emptyBytes = new byte[bytesNum];
        dos.write(emptyBytes, 0, bytesNum);
    }

    public void setParentPageID(BPTreePageID parentPageID) {
        if (parentPageID == null) {
            throw new StorageException("parent id must not be null");
        }
        if (parentPageID.getTableId() != pageID.getTableId()) {
            throw new StorageException("table id mismatch");
        }

        if (parentPageID.getPageType() == BPTreePageType.ROOT_PTR) {
            parentPageNo = 0;
        } else if (parentPageID.getPageType() == BPTreePageType.INTERNAL) {
            parentPageNo = parentPageID.getPageNo();
        } else {
            throw new StorageException("parent must be internal or root node");
        }
    }

    public BPTreePageID getParentPageID() {
        if (parentPageNo == 0) {
            // 没有内部节点时，父节点是RootPtr
            return new BPTreePageID(this.pageID.getTableId(), 0, BPTreePageType.ROOT_PTR);
        }
        return new BPTreePageID(this.pageID.getTableId(), parentPageNo, BPTreePageType.INTERNAL);
    }
}
