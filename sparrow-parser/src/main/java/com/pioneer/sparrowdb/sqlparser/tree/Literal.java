package com.pioneer.sparrowdb.sqlparser.tree;

import com.google.common.collect.ImmutableList;

import java.util.List;

public abstract class Literal extends Expression{
    @Override
    public List<Node> getChildren() {
        return ImmutableList.of();
    }
}
