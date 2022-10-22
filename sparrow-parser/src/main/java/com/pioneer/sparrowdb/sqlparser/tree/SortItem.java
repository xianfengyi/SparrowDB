package com.pioneer.sparrowdb.sqlparser.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class SortItem extends Node{
    public enum Ordering {
        ASCENDING, DESCENDING
    }

    public enum NullOrdering {
        FIRST, LAST, UNDEFINED
    }

    private final Expression sortKey;
    private final Ordering ordering;

    public SortItem(Expression sortKey, Ordering ordering) {
        this.sortKey = sortKey;
        this.ordering = ordering;
    }

    public Expression getSortKey() {
        return sortKey;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    @Override
    public List<Node> getChildren() {
        return ImmutableList.of(sortKey);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("sortKey", sortKey)
                .add("ordering", ordering)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SortItem sortItem = (SortItem) o;
        return Objects.equals(sortKey, sortItem.sortKey) &&
                (ordering == sortItem.ordering);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortKey, ordering);
    }
}
