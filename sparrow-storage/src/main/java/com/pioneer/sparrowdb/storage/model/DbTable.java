package com.pioneer.sparrowdb.storage.model;

import java.util.List;

public class DbTable {

    private String name;

    private List<Column> columns;

    public DbTable(String name, List<Column> columns) {
        this.name = name;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public static class Column{
        private String columnName;

        private String columnType;

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
