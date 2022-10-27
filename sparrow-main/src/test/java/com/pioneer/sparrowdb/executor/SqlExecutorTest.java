package com.pioneer.sparrowdb.executor;

import com.pioneer.sparrowdb.storage.BufferPool;
import com.pioneer.sparrowdb.storage.Database;
import com.pioneer.sparrowdb.storage.TupleDesc;
import com.pioneer.sparrowdb.storage.Type;
import com.pioneer.sparrowdb.storage.file.heap.HeapFile;
import com.pioneer.sparrowdb.utils.HeapFileEncoder;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SqlExecutorTest {

    @Before
    public void setUp() throws Exception {
        String filePath = SqlExecutorTest.class.getClassLoader().getResource("data/some_data_file.txt").getPath();
        int columnNum = 3;
        char fieldSeparator = ',';
        File sourceTxtFile = new File(filePath);
        File targetDatFile = new File(filePath.replaceAll(".txt", ".dat"));
        Type[] ts = new Type[columnNum];
        ts[0] = Type.INT_TYPE;
        ts[1] = Type.INT_TYPE;
        ts[2] = Type.INT_TYPE;

        try {
            HeapFileEncoder.convert(sourceTxtFile, targetDatFile, BufferPool.PAGE_SIZE, columnNum, ts, fieldSeparator);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // construct a 3-column table schema
        Type types[] = new Type[]{Type.INT_TYPE, Type.INT_TYPE, Type.INT_TYPE};
        String names[] = new String[]{"field0", "field1", "field2"};
        TupleDesc descriptor = new TupleDesc(types, names);

        // create the table, associate it with some_data_file.dat
        // and tell the catalog about the schema of this table.
        String datFilePath = SqlExecutorTest.class.getClassLoader().getResource("data/some_data_file.dat").getPath();
        HeapFile table1 = new HeapFile(new File(datFilePath), descriptor);
        Database.getCatalog().addTable(table1, "test");
    }

    @Test
    public void testSelect() {
        String sql = "select field0,field1,field2 from test";

        SqlExecutor executor = new SqlExecutor();
        executor.execute(sql);
    }

    @Test
    public void testInsert() {
        SqlExecutor executor = new SqlExecutor();

        String insertSql = "insert into test(field0,field1,field2)values(6,6,6)";
        executor.execute(insertSql);

        String selectSql = "select field0,field1,field2 from test";
        executor.execute(selectSql);
    }

}