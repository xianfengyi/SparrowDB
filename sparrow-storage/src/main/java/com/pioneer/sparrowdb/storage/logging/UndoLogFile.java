package com.pioneer.sparrowdb.storage.logging;

import com.pioneer.sparrowdb.storage.DataBase;
import com.pioneer.sparrowdb.storage.Page;
import com.pioneer.sparrowdb.storage.TableFile;
import com.pioneer.sparrowdb.storage.exception.StorageException;
import com.pioneer.sparrowdb.storage.transaction.TransactionID;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;

/**
 * Undo 日志，用于回滚
 */
public class UndoLogFile {
    /**
     * 文件
     */
    private final File file;

    /**
     * 随机存储文件
     */
    private final RandomAccessFile raf;

    /**
     * 当前写到的位置
     */
    private long offset = -1;

    /**
     * 存储偏移地址占用的字节数，以long存储，占用8字节
     */
    private int offsetAddrInByte = 8;

    /**
     * 事务开始时的偏移地址
     */
    HashMap<Long, Long> txId2StartOffset = new HashMap<>();

    public UndoLogFile(File file) {
        this.file = file;
        try {
            raf = new RandomAccessFile(file, "rw");
        } catch (FileNotFoundException e) {
            throw new StorageException("load undo log file error ", e);
        }
    }

    /**
     * 记录事务开始
     */
    public synchronized void recordTxStart(TransactionID transactionID) {
        // 如果文件没有记录过信息，从头开始
        if (offset == -1) {
            offset = 0;
        }
        txId2StartOffset.put(transactionID.getId(), offset);
    }

    /**
     * 记录原始页
     * 计入事务ID+页原始数据
     *
     * @param transactionID 事务ID
     * @param beforePage    原始页
     */
    public synchronized void recordBeforePageWhenFlushDisk(TransactionID transactionID, Page beforePage) {
        try {
            // 事务ID
            raf.writeLong(transactionID.getId());

            // 序列化
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(baos);
            outputStream.writeObject(beforePage);
            byte[] bytes = baos.toByteArray();
            // 写入page占用字节数和page数据
            raf.writeInt(bytes.length);
            raf.write(bytes);

            // 本次写入的起始位置
            raf.writeLong(offset);

            // 更新offset
            offset = raf.getFilePointer();

            raf.getChannel().force(true);
            System.out.println("写入undo log ,offset=" + offset);
        } catch (IOException e) {
            throw new StorageException("write undo file failed", e);
        }
    }

    /**
     * 将事务修改过的页面，在磁盘刷回原始版本，缓存中丢弃
     *
     * @param transactionID 回滚的事务
     */
    public synchronized void rollback(TransactionID transactionID) {
        try {
            // 事务开始位置
            Long txStartOffset = txId2StartOffset.get(transactionID.getId());

            // 待读取的偏移位置
            raf.seek(raf.length() - offsetAddrInByte);
            long offsetToRead = raf.readLong();

            while (txStartOffset <= offsetToRead) {
                raf.seek(offsetToRead);
                long txId = raf.readLong();
                if (transactionID.getId() == txId) {
                    int pageSize = raf.readInt();
                    byte[] bytes = new byte[pageSize];
                    raf.read(bytes);

                    ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                    ObjectInputStream inputStream = new ObjectInputStream(bais);
                    Page beforePage = (Page) inputStream.readObject();

                    TableFile tableFile = DataBase.getCatalog().getDbFile(beforePage.getId().getTableId());
                    tableFile.writePage(beforePage);
                    DataBase.getBufferPool().discardPages(Collections.singletonList(beforePage.getId()));
                }
                // 已经到开始位置，结束循环
                if (txStartOffset == offsetToRead) {
                    break;
                }
                raf.seek(offsetToRead - offsetAddrInByte);
                offsetToRead = raf.readLong();
            }
            // 复位
            raf.seek(offset);

            txId2StartOffset.remove(transactionID.getId());
        } catch (IOException | ClassNotFoundException e) {
            throw new StorageException("undo file rollback failed", e);
        }
    }
}
