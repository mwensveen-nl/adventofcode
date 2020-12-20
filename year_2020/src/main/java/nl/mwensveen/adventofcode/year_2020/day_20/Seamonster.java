package nl.mwensveen.adventofcode.year_2020.day_20;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;

public class Seamonster {

    private static final List<String> seamonster = Arrays.asList("                  # ", "#    ##    ##    ###", " #  #  #  #  #  #   ");
    private final Table<Integer, Integer, String> table = HashBasedTable.create();

    private int rows;
    private int columns;

    public Table<Integer, Integer, String> getTable() {
        return table;
    }

    public Seamonster() {
        for (int i = 0; i < seamonster.size(); i++) {
            String row = seamonster.get(i);
            for (int j = 0; j < row.length(); j++) {
                if ("#".equals(row.substring(j, j + 1))) {
                    table.put(i, j, "#");
                }
            }
            columns = Math.max(columns, row.length());
        }
        rows = seamonster.size();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
