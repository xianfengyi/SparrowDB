package com.pioneer.sparrowdb.storage.file.heap;

import com.pioneer.sparrowdb.storage.*;
import com.pioneer.sparrowdb.storage.buffer.BufferPool;
import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.transaction.TransactionID;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Each instance of HeapPage stores data for one page of HeapFiles and implements the Page interface that is used by
 * BufferPool.
 *
 * @see HeapFile
 * @see BufferPool
 */
public class HeapPage implements Page {

    private HeapPageId heapPageId;

    private TupleDesc tupleDesc;

    private Tuple tuples[];

    private boolean[] slotUsageBitMap;

    private int maxNumSlots;

    byte[] oldData;

    /**
     * Create a HeapPage from a set of bytes of data read from disk. The format of a HeapPage is a set of header
     * bytes indicating the slots of the page that are in use, some number of tuple slots.
     * <p>
     * Specifically, the number of tuples is equal to:
     * <pre>
     * floor((BufferPool.PAGE_SIZE*8) / (tuple size * 8 + 1))
     * </pre>
     * <p>
     * where tuple size is the size of tuples in this database table, which can be determined via
     * {@link Catalog#getTupleDesc}.
     * The number of 8-bit header words is equal to:
     * <p>
     * ceiling(no. tuple slots / 8)
     * <p>
     *
     * @see DataBase#getCatalog
     * @see Catalog#getTupleDesc
     * @see BufferPool#PAGE_SIZE
     */
    public HeapPage(HeapPageId heapPageId, byte[] pageData) {
        this.heapPageId = heapPageId;
        this.tupleDesc = DataBase.getCatalog().getTupleDesc(heapPageId.getTableId());
        this.maxNumSlots = getMaxSlotNum();
        this.slotUsageBitMap = new boolean[this.maxNumSlots];
        this.tuples = new Tuple[maxNumSlots];

        deserialize(pageData);
        saveBeforePage();
    }

    @Override
    public PageID getId() {
        return heapPageId;
    }

    @Override
    public byte[] serialize() throws StorageException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(BufferPool.PAGE_SIZE);
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            // 1.序列化 slot 使用状态位图
            serializeSlotStatus(dos);

            // 2.序列化行数据
            serializeTuples(dos);

            // 3.slot状态位图和行数据之外的位置填充 0
            paddingZero(dos);

            dos.flush();
        } catch (IOException e) {
            throw new StorageException(e);
        }
        return baos.toByteArray();
    }

    private void serializeSlotStatus(DataOutputStream dos) throws IOException {
        for (boolean status : slotUsageBitMap) {
            dos.writeBoolean(status);
        }
    }

    private void serializeTuples(DataOutputStream dos) throws IOException {
        for (int i = 0; i < tuples.length; i++) {
            if (isSlotUsed(i)) {
                for (Field field : tuples[i].getFields()) {
                    field.serialize(dos);
                }
            } else { // 空slot的位置填充
                fillBytes(dos, BufferPool.PAGE_SIZE);
            }
        }
    }

    private void paddingZero(DataOutputStream dos) throws IOException {
        int zeroSize = BufferPool.PAGE_SIZE - slotUsageBitMap.length - tupleDesc.getSize() * tuples.length;
        fillBytes(dos, zeroSize);
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
        }else if(bytesNum<=0){
            return;
        }
        byte[] emptyBytes = new byte[bytesNum];
        dos.write(emptyBytes, 0, bytesNum);
    }

    @Override
    public void deserialize(byte[] pageData) throws StorageException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(pageData));
        try {
            // slot状态位反序列化
            for (int i = 0; i < slotUsageBitMap.length; i++) {
                slotUsageBitMap[i] = dis.readBoolean();
            }
            // 行数据Row反序列化
            tuples = new Tuple[maxNumSlots];
            // allocate and read the actual records of this page
            for (int i = 0; i < tuples.length; i++) {
                if(!isSlotUsed(i)){
                    tuples[i]=null;
                    continue;
                }
                tuples[i] = readTuple(dis, i);
            }
            dis.close();
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    private Tuple readTuple(DataInputStream dataInputStream, int slotId) throws ParseException {
        Tuple tuple = new Tuple(tupleDesc);
        tuple.setRecordId(new RecordId(heapPageId, slotId));

        for (int index = 0; index < tupleDesc.numFields(); index++) {
            Field field = tupleDesc.getFieldType(index).parse(dataInputStream);
            tuple.setField(index, field);
        }
        return tuple;
    }

    @Override
    public void insertTuple(Tuple tuple) throws StorageException {
        if (!tupleDesc.equals(tuple.getTupleDesc())) {
            throw new StorageException("tupleDesc is mismatch");
        }
        for (int i = 0; i < getMaxSlotNum(); i++) {
            if (!isSlotUsed(i)) {
                tuples[i] = tuple;
                tuple.setRecordId(new RecordId(heapPageId, i));
                slotUsageBitMap[i] = true;
                return;
            }
        }
        throw new StorageException("the page is full (no empty slots)");
    }

    @Override
    public void deleteTuple(Tuple tuple) throws StorageException {
        if (tuple == null) {
            return;
        }
        int tupleNum = tuple.getRecordId().tupleno();
        if (!isSlotUsed(tupleNum)) {
            throw new StorageException("this tuple is not on this page, or tuple slot is already empty");
        }
        tuples[tupleNum] = null;
        slotUsageBitMap[tupleNum] = false;
    }

    @Override
    public int getMaxSlotNum() {
        if (maxNumSlots != 0) {
            return maxNumSlots;
        }
        int numTuples = (BufferPool.PAGE_SIZE) / (tupleDesc.getSize() + 1);
        return numTuples;
    }

    @Override
    public boolean isSlotUsed(int index) {
        return slotUsageBitMap[index];
    }

    @Override
    public boolean hasEmptySlot() {
        for (boolean item : slotUsageBitMap) {
            if (item) {
                return true;
            }
        }
        return false;
    }

    @Override
    public TransactionID isDirty() {
        return null;
    }

    @Override
    public void markDirty(boolean dirty, TransactionID tid) {

    }

    @Override
    public void saveBeforePage() {
        this.oldData = serialize().clone();
    }

    @Override
    public Page getBeforeImage() {
        return new HeapPage(heapPageId, oldData);
    }

    @Override
    public Iterator<Tuple> tupleIterator() {
        return new HeapTupleIterator();
    }

    /**
     * Static method to generate a byte array corresponding to an empty
     * HeapPage.
     * Used to add new, empty pages to the file. Passing the results of
     * this method to the HeapPage constructor will create a HeapPage with
     * no valid tuples in it.
     *
     * @return The returned ByteArray.
     */
    public static byte[] createEmptyPageData() {
        int len = BufferPool.PAGE_SIZE;
        return new byte[len];
    }

    private class HeapTupleIterator implements Iterator<Tuple> {

        private Iterator<Tuple> tupleIterator;

        public HeapTupleIterator() {
            ArrayList<Tuple> rowList = new ArrayList<>();
            for (int i = 0; i < slotUsageBitMap.length; i++) {
                if (isSlotUsed(i)) {
                    rowList.add(tuples[i]);
                }
            }
            tupleIterator = rowList.iterator();
        }

        @Override
        public boolean hasNext() {
            return tupleIterator.hasNext();
        }

        @Override
        public Tuple next() {
            return tupleIterator.next();
        }
    }
}

