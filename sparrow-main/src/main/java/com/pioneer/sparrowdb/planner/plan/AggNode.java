package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.Tuple;

import java.util.List;
import java.util.Map;

public class AggNode extends PlanNode {

    private PlanNode source;

    private List<String> groupByKeys;

    private Map<String, String> aggToFiled;

    @Override
    public void prepare() {


    }

    @Override
    public Tuple getNextTuple() throws IllegalStateException {
        return null;
    }


    public enum AggType {
        MIN, MAX, SUM, AVG, COUNT
    }
}
