package com.pioneer.sparrowdb.sqlparser.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;

public class Insert extends Statement {
    private final QualifiedName target;
    private final Query query;
    private final Optional<List<Identifier>> columns;

    public Insert(QualifiedName target, Optional<List<Identifier>> columns, Query query) {
        this.target = requireNonNull(target, "target is null");
        this.columns = requireNonNull(columns, "columns is null");
        this.query = requireNonNull(query, "query is null");
    }

    public QualifiedName getTarget() {
        return target;
    }

    public Optional<List<Identifier>> getColumns() {
        return columns;
    }

    public Query getQuery() {
        return query;
    }

    @Override
    public List<Node> getChildren() {
        return ImmutableList.of(query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(target, columns, query);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Insert o = (Insert) obj;
        return Objects.equals(target, o.target) && Objects.equals(columns, o.columns) && Objects.equals(query, o.query);
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("target", target).add("columns", columns).add("query", query).toString();
    }
}
