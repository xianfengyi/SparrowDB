package com.pioneer.sparrowdb.sqlparser.tree;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class OrderBy extends Node{
    private final List<SortItem> sortItems;

    public OrderBy(List<SortItem> sortItems) {
        this.sortItems = sortItems;
    }

    @Override
    public List<? extends Node> getChildren() {
        return sortItems;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("sortItems", sortItems).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        OrderBy o = (OrderBy) obj;
        return Objects.equals(sortItems, o.sortItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortItems);
    }
}
