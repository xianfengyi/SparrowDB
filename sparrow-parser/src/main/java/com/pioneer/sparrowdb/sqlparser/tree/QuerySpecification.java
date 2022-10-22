package com.pioneer.sparrowdb.sqlparser.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.google.common.base.MoreObjects.toStringHelper;

public class QuerySpecification extends QueryBody {

    private final Select select;
    private final Optional<Relation> from;
    private final Optional<Expression> where;
    private final Optional<GroupBy> groupBy;
    private final Optional<OrderBy> orderBy;
    private final Optional<Offset> offset;
    private final Optional<String> limit;

    public QuerySpecification(Select select,
                              Optional<Relation> from,
                              Optional<Expression> where,
                              Optional<GroupBy> groupBy,
                              Optional<OrderBy> orderBy,
                              Optional<Offset> offset,
                              Optional<String> limit) {
        this.select = select;
        this.from = from;
        this.where = where;
        this.groupBy = groupBy;
        this.orderBy = orderBy;
        this.offset = offset;
        this.limit = limit;
    }

    public QuerySpecification(Select select, Optional<Relation> from) {
        this(select,from,Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty());
    }

    public Select getSelect() {
        return select;
    }

    public Optional<Relation> getFrom() {
        return from;
    }

    public Optional<Expression> getWhere() {
        return where;
    }

    public Optional<GroupBy> getGroupBy() {
        return groupBy;
    }

    public Optional<OrderBy> getOrderBy() {
        return orderBy;
    }

    public Optional<Offset> getOffset() {
        return offset;
    }

    public Optional<String> getLimit() {
        return limit;
    }

    @Override
    public List<Node> getChildren()
    {
        ImmutableList.Builder<Node> nodes = ImmutableList.builder();
        nodes.add(select);
        from.ifPresent(nodes::add);
        where.ifPresent(nodes::add);
        groupBy.ifPresent(nodes::add);
        orderBy.ifPresent(nodes::add);
        offset.ifPresent(nodes::add);
        return nodes.build();
    }

    @Override
    public int hashCode() {
        return Objects.hash(select, from, where, groupBy, orderBy, offset, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        QuerySpecification o = (QuerySpecification) obj;
        return Objects.equals(select, o.select) && Objects.equals(from, o.from)
                && Objects.equals(where, o.where)
                && Objects.equals(groupBy, o.groupBy)
                && Objects.equals(orderBy, o.orderBy)
                && Objects.equals(offset, o.offset)
                && Objects.equals(limit, o.limit);

    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("select", select)
                .add("from", from)
                .add("where", where.orElse(null))
                .add("groupBy", groupBy)
                .add("orderBy", orderBy)
                .add("offset", offset.orElse(null))
                .add("limit", limit.orElse(null))
                .toString();
    }
}
