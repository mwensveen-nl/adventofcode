package nl.mwensveen.adventofcode.year_2024.day_04;

import com.google.common.collect.Table;

public class XmasSearcher {

    private static String WORD = "XMAS";
    private static int WORDSIZE = WORD.length();
    private static int UP = -1;
    private static int DOWN = 1;
    private static int LEFT = -1;
    private static int SAME = 0;
    private static int RIGHT = 1;

    private int rows;
    private int columns;

    public int searchXmas(Table<Integer, Integer, Character> table) {
        rows = table.rowKeySet().size();
        columns = table.columnKeySet().size();
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
        if (searchXmas(r, c, table, 0, DOWN, SAME)) {
            count++;
        }

        // up
        if (searchXmas(r, c, table, 0, UP, SAME)) {
            count++;
        }

        // left
        if (searchXmas(r, c, table, 0, SAME, LEFT)) {
            count++;
        }

        // right
        if (searchXmas(r, c, table, 0, SAME, RIGHT)) {
            count++;
        }

        // down-left
        if (searchXmas(r, c, table, 0, DOWN, LEFT)) {
            count++;
        }

        // down-right
        if (searchXmas(r, c, table, 0, DOWN, RIGHT)) {
            count++;
        }

        // up-left
        if (searchXmas(r, c, table, 0, UP, LEFT)) {
            count++;
        }

        // up-right
        if (searchXmas(r, c, table, 0, UP, RIGHT)) {
            count++;
        }

        return count;
    }

    private boolean searchXmas(int r, int c, Table<Integer, Integer, Character> table, int wordIndex, int rowModifier, int colModifier) {
        if (r >= 0 && r < rows && c >= 0 && c < columns) {
            if (table.get(r, c) == WORD.charAt(wordIndex)) {
                if (wordIndex == WORDSIZE - 1) {
                    return true;
                }
                return searchXmas(r + rowModifier, c + colModifier, table, wordIndex + 1, rowModifier, colModifier);
            }
        }
        return false;
    }

    public int searchCrossMas(Table<Integer, Integer, Character> table) {
        rows = table.rowKeySet().size();
        columns = table.columnKeySet().size();
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                count += checkCrossMas(r, c, table) ? 1 : 0;
            }
        }
        return count;
    }

    private boolean checkCrossMas(int r, int c, Table<Integer, Integer, Character> table) {
        if (r == 0 || r == rows - 1 || c == 0 || c == columns - 1) {
            return false;
        }
        if (check(r, c, SAME, SAME, table, 'A')) {
            if (check(r, c, UP, LEFT, table, 'M') && check(r, c, DOWN, RIGHT, table, 'S') ||
                    check(r, c, UP, LEFT, table, 'S') && check(r, c, DOWN, RIGHT, table, 'M')) {
                if (check(r, c, UP, RIGHT, table, 'M') && check(r, c, DOWN, LEFT, table, 'S') ||
                        check(r, c, UP, RIGHT, table, 'S') && check(r, c, DOWN, LEFT, table, 'M')) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int r, int c, int rModifier, int cModifier, Table<Integer, Integer, Character> table, char letter) {
        return table.get(r + rModifier, c + cModifier) == letter;
    }
}
