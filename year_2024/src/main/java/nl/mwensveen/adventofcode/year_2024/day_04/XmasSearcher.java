package nl.mwensveen.adventofcode.year_2024.day_04;

import com.google.common.collect.Table;

public class XmasSearcher {

    private static String WORD = "XMAS";
    private static int WORDSIZE = WORD.length();

    public int searchXmas(Table<Integer, Integer, Character> table) {
        int rows = table.rowKeySet().size();
        int columns = table.columnKeySet().size();
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                count += searchXmax(r, c, table);
            }
        }
        return count;
    }

    private int searchXmax(int r, int c, Table<Integer, Integer, Character> table) {
        int count = 0;

        // down
        if (searchXmas(r, c, table, 0, 1, 0)) {
            count++;
        }

        // up
        if (searchXmas(r, c, table, 0, -1, 0)) {
            count++;
        }

        // left
        if (searchXmas(r, c, table, 0, 0, -1)) {
            count++;
        }

        // right
        if (searchXmas(r, c, table, 0, 0, 1)) {
            count++;
        }

        // down-left
        if (searchXmas(r, c, table, 0, 1, -1)) {
            count++;
        }

        // down-right
        if (searchXmas(r, c, table, 0, 1, 1)) {
            count++;
        }

        // up-left
        if (searchXmas(r, c, table, 0, -1, -1)) {
            count++;
        }

        // up-right
        if (searchXmas(r, c, table, 0, -1, 1)) {
            count++;
        }

        return count;
    }

    private boolean searchXmas(int r, int c, Table<Integer, Integer, Character> table, int wordIndex, int rowModifier, int colModifier) {
        if (r >= 0 && r < table.rowKeySet().size() && c >= 0 && c < table.columnKeySet().size()) {
            if (table.get(r, c) == WORD.charAt(wordIndex)) {
                if (wordIndex == WORDSIZE - 1) {
                    return true;
                }
                return searchXmas(r + rowModifier, c + colModifier, table, wordIndex + 1, rowModifier, colModifier);
            }
        }
        return false;
    }

}
