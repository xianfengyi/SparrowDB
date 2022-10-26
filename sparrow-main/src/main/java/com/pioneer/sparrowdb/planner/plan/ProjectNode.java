package com.pioneer.sparrowdb.planner.plan;

import com.pioneer.sparrowdb.sqlparser.tree.SelectItem;
import com.pioneer.sparrowdb.sqlparser.tree.SingleColumn;
import com.pioneer.sparrowdb.storage.Tuple;
import com.pioneer.sparrowdb.storage.TupleDesc;
import com.pioneer.sparrowdb.storage.Type;

import java.util.List;

public class ProjectNode extends PlanNode {
    // 源节点
    private PlanNode source;

    List<SelectItem> selectItems;

    public ProjectNode(PlanNode source, List<SelectItem> selectItems) {
        this.source = source;
        this.selectItems = selectItems;
    }

    @Override
    public void prepare() {

    }

    @Override
    public Tuple getNextTuple() throws IllegalStateException {
        Tuple tuple = source.getNextTuple();
        if (tuple != null) {
            return projectTuple(tuple);
        }
        return null;
    }

    private Tuple projectTuple(Tuple tuple) {
        // 首先 project 描述
        TupleDesc tupleDesc = tuple.getTupleDesc();
        Type[] subTypes = new Type[selectItems.size()];
        String[] subFields = new String[selectItems.size()];
        int subIndex = 0;
        for (SelectItem item : selectItems) {
            SingleColumn singleColumn = (SingleColumn) item;
            String name = singleColumn.getExpression().toString();
            int index = tupleDesc.fieldNameToIndex(name);
            subTypes[subIndex] = tupleDesc.getFieldType(index);
            subFields[subIndex] = tupleDesc.getFieldName(index);
            subIndex++;
        }
        Tuple newTuple = new Tuple(new TupleDesc(subTypes, subFields));
        // 然后 project 字段值
        subIndex = 0;
        for (SelectItem item : selectItems) {
            SingleColumn singleColumn = (SingleColumn) item;
            String name = singleColumn.getExpression().toString();
            int index = tupleDesc.fieldNameToIndex(name);
            newTuple.setField(subIndex++, tuple.getField(index));
        }
        return newTuple;
    }
}
