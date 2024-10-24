package org.algorithms.io.amazon2k24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Table {
    private final Map<Integer, List<String>> rows;
    private int rowIndex;
    private final int columnLimit;
    public Table(int columnLimit) {
        this.rows = new HashMap<>();
        this.rowIndex = 1;
        this.columnLimit = columnLimit;
    }

    public void insertRow(List<String> row) {
        if(row.size() > columnLimit) return;

        this.rows.put(this.rowIndex++, row);
    }

    public void deleteRow(int rowId) {
        this.rows.remove(rowId);
    }

    public String selectCell(int rowId, int colId) {
        return rows.get(rowId).get(colId - 1);
    }
 }

public class SQL {

    private final Map<String, Table> db;
    public SQL(List<String> names, List<Integer> columns) {
        this.db = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            this.db.put(names.get(i), new Table(columns.get(i)));
        }
    }

    public void insertRow(String name, List<String> row) {
        db.get(name).insertRow(row);
    }

    public void deleteRow(String name, int rowId) {
        this.db.get(name).deleteRow(rowId);
    }

    public String selectCell(String name, int rowId, int columnId) {
        return this.db.get(name).selectCell(rowId, columnId);
    }
}
