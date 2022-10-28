package com.pioneer.sparrowdb.storage;

import java.io.Serializable;

/**
 * A RecordId is a reference to a specific tuple on a specific page of a
 * specific table.
 */
public class RecordId implements Serializable {

    private static final long serialVersionUID = 1L;

    private PageID pageId;

    private int tupleNum;

    /**
     * Creates a new RecordId referring to the specified PageId and tuple
     * number.
     *
     * @param pid     the pageid of the page on which the tuple resides
     * @param tupleno the tuple number within the page.
     */
    public RecordId(PageID pid, int tupleno) {
        pageId = pid;
        tupleNum = tupleno;
    }

    /**
     * @return the tuple number this RecordId references.
     */
    public int tupleno() {
        return tupleNum;
    }

    /**
     * @return the page id this RecordId references.
     */
    public PageID getPageId() {
        return pageId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof RecordId) {
            RecordId another = (RecordId) o;
            return pageId.equals(another.getPageId())
                    && another.tupleno() == tupleNum;
        } else return false;
    }

    @Override
    public int hashCode() {
        int result = 31 * pageId.hashCode() + tupleNum;
        return result;
    }
}
