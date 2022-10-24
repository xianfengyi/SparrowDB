package com.pioneer.sparrowdb.storage;

import java.io.Serializable;
import java.util.List;

public class TupleDesc implements Serializable {

    private List<Column> columns;

    public TupleDesc(List<Column> columns) {
        this.columns = columns;
    }

    public class Column {

        private final String columnName;

        private final String columnType;

        public Column(String columnName, String columnType) {
            this.columnName = columnName;
            this.columnType = columnType;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getColumnType() {
            return columnType;
        }
    }
}
