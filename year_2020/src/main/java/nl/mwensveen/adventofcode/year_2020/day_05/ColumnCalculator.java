package nl.mwensveen.adventofcode.year_2020.day_05;

import java.util.concurrent.atomic.AtomicInteger;

public class ColumnCalculator {

    private static final int MIN_COLUMN = 0;
    private static final int MAX_COLUMN = 7;
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    public int determineColumn(String code) {
        AtomicInteger minColumn = new AtomicInteger(MIN_COLUMN);
        AtomicInteger maxColumn = new AtomicInteger(MAX_COLUMN);
        code.chars().forEach(i -> calcColumn(i, minColumn, maxColumn));
        return minColumn.get();
    }

    private void calcColumn(int i, AtomicInteger minColumn, AtomicInteger maxColumn) {
        int half = (maxColumn.get() - minColumn.get() - 1) / 2;
        if ((char) i == LEFT) {
            maxColumn.set(minColumn.get() + half);
        } else {
            minColumn.set(maxColumn.get() - half);
        }
    }
}
