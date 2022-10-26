package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.Tuple;

public class LimitNode extends PlanNode {

    // 源节点
    private PlanNode source;

    private int limit;

    private int count;

    public LimitNode(PlanNode source, int limit) {
        this.source = source;
        this.limit = limit;
        this.count = 0;
    }

    @Override
    public void prepare() {

    }

    @Override
    public Tuple getNextTuple() throws IllegalStateException {
        if (count++ >= limit) {
            return null;
        }
        return source.getNextTuple();
    }
}
