package nl.mwensveen.adventofcode.year_2020.day_05;

import java.util.concurrent.atomic.AtomicInteger;

public class RowCalculator {

    private static final int MIN_ROW = 0;
    private static final int MAX_ROW = 127;
    private static final char FRONT = 'F';
    private static final char BACK = 'B';

    public int determineRow(String code) {
        AtomicInteger minRow = new AtomicInteger(MIN_ROW);
        AtomicInteger maxRow = new AtomicInteger(MAX_ROW);
        code.chars().forEach(i -> calcRow(i, minRow, maxRow));
        return minRow.get();
    }

    private void calcRow(int i, AtomicInteger minRow, AtomicInteger maxRow) {
        int half = (maxRow.get() - minRow.get() - 1) / 2;
        if ((char) i == FRONT) {
            maxRow.set(minRow.get() + half);
        } else {
            minRow.set(maxRow.get() - half);
        }
    }
}
