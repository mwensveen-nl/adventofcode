package nl.mwensveen.adventofcode.year_2020.day_20;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;

public class Seamonster {
    public static final String FIND = "###";
    public static final int FIND_ROW = 1;
    public static final int FIND_COLUMN = 17;

    private static final List<String> seamonster = Arrays.asList("                  # ", "#    ##    ##    ###", " #  #  #  #  #  #   ");
    private final Table<Integer, Integer, String> table = HashBasedTable.create();

    private int rows;
    private int columns;

    public Table<Integer, Integer, String> getTable() {
        return table;
    }

    public Seamonster() {
        // create table with the # of the seamonster, where ### (FIND) is the 0,0 position.
        // ### is at pos 1, 18 in the given seamonster.
        for (int i = 0; i < seamonster.size(); i++) {
            String row = seamonster.get(i);
            for (int j = 0; j < row.length(); j++) {
                if ("#".equals(row.substring(j, j + 1))) {
                    table.put(i - FIND_ROW, j - FIND_COLUMN, "#");
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
