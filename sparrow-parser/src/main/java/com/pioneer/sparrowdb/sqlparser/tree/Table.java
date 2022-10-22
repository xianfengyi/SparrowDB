package com.pioneer.sparrowdb.sqlparser.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class Table extends QueryBody {
    private final QualifiedName name;

    public Table(QualifiedName name) {
        this.name = name;
    }

    public QualifiedName getName() {
        return name;
    }

    @Override
    public List<Node> getChildren() {
        return ImmutableList.of();
    }

    @Override
    public String toString() {
        return toStringHelper(this).addValue(name).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Table table = (Table) o;
        return Objects.equals(name, table.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}