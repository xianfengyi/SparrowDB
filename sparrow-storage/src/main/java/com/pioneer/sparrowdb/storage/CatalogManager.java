package com.pioneer.sparrowdb.storage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.UUID;

public class CatalogManager {

    //建立tableid到DbFiles的映射
    private HashMap<String, DBFile> id2file;

    //建立tableid到表的主键的映射
    private HashMap<String, String> id2pkey;

    //建立tableid到表的名称的映射
    private HashMap<String, String> id2name;

    //建立表的名称到tableid的映射
    private HashMap<String, String> name2id;

    public CatalogManager() {
        // some code goes here
        id2file = new HashMap<>();
        id2pkey = new HashMap<>();
        id2name = new HashMap<>();
        name2id = new HashMap<>();
    }


    /**
     * Add a new table to the catalog.
     * This table's contents are stored in the specified DbFile.
     *
     * @param file      the contents of the table to add;  file.getId() is the identfier of
     *                  this file/tupledesc param for the calls getTupleDesc and getFile
     * @param name      the name of the table -- may be an empty string.  May not be null.  If a name
     *                  conflict exists, use the last table to be added as the table for a given name.
     * @param pkeyField the name of the primary key field
     */
    public void addTable(DBFile file, String name, String pkeyField) {
        // some code goes here
        if (name == null || pkeyField == null) {
            throw new IllegalArgumentException();
        }
        String tableid = file.getFileID();
        if (name2id.containsKey(name)) {
            //当表名冲突时，删除之前的插入的表
            String id = name2id.get(name);
            id2file.remove(id);
            id2name.remove(id);
            id2pkey.remove(id);
            name2id.remove(name);
        }
        id2file.put(tableid, file);
        id2name.put(tableid, name);
        id2pkey.put(tableid, pkeyField);
        name2id.put(name, tableid);
    }

    public void addTable(DBFile file, String name) {
        addTable(file, name, "");
    }

    /**
     * Add a new table to the catalog.
     * This table has tuples formatted using the specified TupleDesc and its
     * contents are stored in the specified DbFile.
     *
     * @param file the contents of the table to add;  file.getId() is the identfier of
     *             this file/tupledesc param for the calls getTupleDesc and getFile
     */
    public void addTable(DBFile file) {
        addTable(file, (UUID.randomUUID()).toString());
    }

    /**
     * Return the id of the table with a specified name,
     *
     * @throws NoSuchElementException if the table doesn't exist
     */
    public String getTableId(String name) throws NoSuchElementException {
        // some code goes here
        if (name == null || !name2id.containsKey(name)) {
            throw new NoSuchElementException();
        }
        return name2id.get(name);
    }

    /**
     * Returns the tuple descriptor (schema) of the specified table
     *
     * @param tableid The id of the table, as specified by the DbFile.getId()
     *                function passed to addTable
     * @throws NoSuchElementException if the table doesn't exist
     */
    public TupleDesc getTupleDesc(String tableid) throws NoSuchElementException {
        // some code goes here
        if (!isIdValid(tableid, id2file)) {
            throw new NoSuchElementException();
        }
        return id2file.get(tableid).getTupleDesc();
    }

    /**
     * Returns the DbFile that can be used to read the contents of the
     * specified table.
     *
     * @param tableid The id of the table, as specified by the DbFile.getId()
     *                function passed to addTable
     */
    public DBFile getDbFile(String tableid) throws NoSuchElementException {
        // some code goes here
        if (!isIdValid(tableid, id2file)) {
            throw new NoSuchElementException();
        }
        return id2file.get(tableid);
    }

    public String getPrimaryKey(String tableid) {
        // some code goes here
        if (!isIdValid(tableid, id2pkey)) {
            throw new NoSuchElementException();
        }
        return id2pkey.get(tableid);
    }

    public Iterator<String> tableIdIterator() {
        // some code goes here
        return id2name.keySet().iterator();
    }

    public String getTableName(String id) {
        // some code goes here
        if (!isIdValid(id, id2name)) {
            throw new NoSuchElementException();
        }
        return id2name.get(id);
    }

    private boolean isIdValid(String id, HashMap<?, ?> map) {
        return map.containsKey(id);
    }

    /**
     * Delete all tables from the catalog
     */
    public void clear() {
        // some code goes here
        id2name.clear();
        id2pkey.clear();
        id2file.clear();
        name2id.clear();
    }
}
