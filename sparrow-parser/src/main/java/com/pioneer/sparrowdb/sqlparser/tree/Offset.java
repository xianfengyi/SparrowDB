package com.pioneer.sparrowdb.sqlparser.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class Offset extends Node{
    private final String rowCount;

    public Offset(String rowCount) {
        this.rowCount = rowCount;
    }

    public String getRowCount() {
        return rowCount;
    }

    @Override
    public List<? extends Node> getChildren() {
        return ImmutableList.of();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Offset o = (Offset) obj;
        return Objects.equals(rowCount, o.rowCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowCount);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("rowCount", rowCount)
                .toString();
    }
}
