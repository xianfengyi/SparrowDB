package com.pioneer.sparrowdb.storage;

public class PageID {

    private String tableID;

    private int pageNumber;

    public PageID(String tableID, int pageNumber) {
        this.tableID = tableID;
        this.pageNumber = pageNumber;
    }

    public String getTableID() {
        return tableID;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
