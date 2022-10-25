package com.pioneer.sparrowdb.sqlparser.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static java.util.Objects.requireNonNull;

public class RenameTable extends Statement {
    private final QualifiedName source;
    private final QualifiedName target;
    private final boolean exists;

    public RenameTable(QualifiedName source, QualifiedName target, boolean exists) {
        this.source = requireNonNull(source, "source name is null");
        this.target = requireNonNull(target, "target name is null");
        this.exists = exists;
    }

    public QualifiedName getSource() {
        return source;
    }

    public QualifiedName getTarget() {
        return target;
    }

    public boolean isExists() {
        return exists;
    }

    @Override
    public List<Node> getChildren() {
        return ImmutableList.of();
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        RenameTable o = (RenameTable) obj;
        return Objects.equals(source, o.source) && Objects.equals(target, o.target);
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("source", source).add("target", target).toString();
    }
}
