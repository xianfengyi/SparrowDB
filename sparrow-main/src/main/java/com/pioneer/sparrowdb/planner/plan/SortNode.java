package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.storage.IntField;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.TupleDesc;

import java.util.ArrayList;
import java.util.Collections;

public class SortNode extends PlanNode {

    // 源节点
    private PlanNode source;

    // 当前仅支持一个排序字段，默认先升序
    private String orderBy;

    /**
     * The index of the current tuple in the sorted results.
     */
    private int currentTupleIndex;

    /**
     * This array receives all tuples from the child plan node, and then they
     * are sorted and passed along to the parent from this array.
     */
    private ArrayList<Tuple> sortedTuples;

    // is sorted or not
    private boolean isSorted;

    public SortNode() {
        this.sortedTuples = new ArrayList<>();
    }

    @Override
    public void prepare() {

    }

    @Override
    public Tuple getNextTuple() throws IllegalStateException {
        if (!isSorted) {
            sortTuples();
            isSorted = true;
        }
        if (currentTupleIndex >= sortedTuples.size()) {
            return null;
        }
        return sortedTuples.get(currentTupleIndex++);
    }

    private void sortTuples() {
        while (true) {
            Tuple tuple = source.getNextTuple();
            if (tuple == null) {
                break;
            }
            sortedTuples.add(tuple);
        }
        Collections.sort(sortedTuples, (o1, o2) -> {
            TupleDesc tupleDesc = o1.getTupleDesc();
            int index = tupleDesc.fieldNameToIndex(orderBy);
            IntField filed1 = (IntField) o1.getField(index);
            IntField filed2 = (IntField) o2.getField(index);
            return filed1.getValue() - filed2.getValue();
        });
    }
}
