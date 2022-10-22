package com.pioneer.sparrowdb.sqlparser.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.MoreObjects.toStringHelper;

public class Query extends Statement {
    private final QueryBody queryBody;
    private final Optional<OrderBy> orderBy;
    private final Optional<String> limit;
    private final Optional<Offset> offset;

    public Query(QueryBody queryBody, Optional<OrderBy> orderBy, Optional<String> limit, Optional<Offset> offset) {
        this.queryBody = queryBody;
        this.orderBy = orderBy;
        this.limit = limit;
        this.offset = offset;
    }

    public QueryBody getQueryBody() {
        return queryBody;
    }

    public Optional<OrderBy> getOrderBy() {
        return orderBy;
    }

    public Optional<String> getLimit() {
        return limit;
    }

    public Optional<Offset> getOffset() {
        return offset;
    }

    @Override
    public List<? extends Node> getChildren() {
        ImmutableList.Builder<Node> nodes = ImmutableList.builder();
        nodes.add(queryBody);
        orderBy.ifPresent(nodes::add);
        offset.ifPresent(nodes::add);
        return nodes.build();
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryBody, orderBy, offset, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Query o = (Query) obj;
        return Objects.equals(queryBody, o.queryBody) &&
                Objects.equals(orderBy, o.orderBy) &&
                Objects.equals(offset, o.offset) &&
                Objects.equals(limit, o.limit);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("queryBody", queryBody)
                .add("orderBy", orderBy)
                .add("offset", offset.orElse(null))
                .add("limit", limit.orElse(null))
                .omitNullValues()
                .toString();
    }
}
