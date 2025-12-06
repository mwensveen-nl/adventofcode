package nl.mwensveen.adventofcode.year_2025.day_04;

import com.google.common.collect.Table;
import java.util.stream.IntStream;

public class ForkliftsAccessFinder {

    private int maxRow;
    private int maxCol;

    public int findAccessable(Table<Integer, Integer, Character> diagram) {

        maxRow = diagram.rowKeySet().size() - 1;
        maxCol = diagram.columnKeySet().size() - 1;

        return IntStream.rangeClosed(0, maxRow).map(r -> processRow(r, diagram)).sum();

    }

    public int findAccessableWithRemove(Table<Integer, Integer, Character> diagram) {
        int count = 0;
        int newCount = findAccessable(diagram);
        count += newCount;
        while (newCount > 0) {
            removeRolls(diagram);
            newCount = findAccessable(diagram);
            count += newCount;
        }
        return count;
    }

    private void removeRolls(Table<Integer, Integer, Character> diagram) {
        for (int r = 0; r <= maxRow; r++) {
            for (int c = 0; c <= maxCol; c++) {
                if ('#' == diagram.get(r, c)) {
                    diagram.put(r, c, '.');
                }
            }
        }

    }

    private int processRow(int r, Table<Integer, Integer, Character> diagram) {
        return IntStream.rangeClosed(0, maxCol).map(c -> processCol(r, c, diagram)).sum();
    }

    private int processCol(int r, int c, Table<Integer, Integer, Character> diagram) {
        if ('@' == diagram.get(r, c)) {
            int count = 0;
            for (int row = r - 1; row <= r + 1; row++) {
                for (int col = c - 1; col <= c + 1; col++) {
                    if (row >= 0 && row <= maxRow && col >= 0 && col <= maxCol) {
                        if ('@' == diagram.get(row, col) || '#' == diagram.get(row, col)) {
                            count++;
                        }
                    }
                }
            }
            count--;
            if (count < 4) {
                diagram.put(r, c, '#');
                return 1;
            }
        }
        return 0;
    }

}
