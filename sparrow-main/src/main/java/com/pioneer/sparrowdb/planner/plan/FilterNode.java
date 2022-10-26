package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.IntField;
import com.pioneer.sparrowdb.storage.Tuple;

import java.util.ArrayList;

public class FilterNode extends PlanNode {

    // 源节点
    private PlanNode source;

    // 过滤条件，字段名
    private String filterFieldName;

    // 过滤条件，字段值
    private int filterFieldValue;

    // 过滤后的 Tuples
    private ArrayList<Tuple> filteredTuples;

    // index
    private int currentTupleIndex;

    private boolean isFiltered;

    public FilterNode() {
        filteredTuples = new ArrayList<>();
    }

    public FilterNode(PlanNode source, String filterFieldName, int filterFieldValue) {
        this.source = source;
        this.filterFieldName = filterFieldName;
        this.filterFieldValue = filterFieldValue;
        filteredTuples = new ArrayList<>();
    }

    @Override
    public void prepare() {

    }

    @Override
    public Tuple getNextTuple() throws IllegalStateException {
        if (!isFiltered) {
            filterTuples();
            isFiltered = true;
        }
        if (currentTupleIndex >= filteredTuples.size()) {
            return null;
        }
        return filteredTuples.get(currentTupleIndex++);
    }

    private void filterTuples() {
        while (true) {
            Tuple tuple = source.getNextTuple();
            if (tuple == null) {
                break;
            }
            int index = tuple.getTupleDesc().fieldNameToIndex(filterFieldName);
            IntField filed = (IntField) tuple.getField(index);
            if (filed.getValue() == filterFieldValue) {
                filteredTuples.add(tuple);
            }
        }
    }
}
