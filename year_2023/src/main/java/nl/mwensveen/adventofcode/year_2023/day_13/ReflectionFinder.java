package nl.mwensveen.adventofcode.year_2023.day_13;

import com.google.common.collect.Table;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ReflectionFinder {

    public int find(Table<Integer, Integer, Symbol> pattern) {
        OptionalInt foundCol = IntStream.range(1, pattern.columnKeySet().size()).filter(i -> isReflectionCol(pattern, i)).findFirst();
        if (foundCol.isPresent()) {
            return foundCol.getAsInt();
        }
        System.out.println();
        OptionalInt foundRow = IntStream.range(1, pattern.rowKeySet().size()).filter(i -> isReflectionRow(pattern, i)).findFirst();
        return foundRow.getAsInt() * 100;
    }

    private boolean isReflectionCol(Table<Integer, Integer, Symbol> pattern, int i) {
        int c1Start = i;
        int c2Start = i + 1;
        int c2End = pattern.columnKeySet().size();
        for (int c1 = c1Start, c2 = c2Start; c1 >= 1 && c2 <= c2End; c1--, c2++) {
            System.out.println(i + " " + c1 + " " + c2);
            if (!pattern.column(c1).equals(pattern.column(c2))) {
                return false;
            }
        }
        return true;
    }

    private boolean isReflectionRow(Table<Integer, Integer, Symbol> pattern, int i) {
        int c1Start = i;
        int c2Start = i + 1;
        int c2End = pattern.rowKeySet().size();
        for (int c1 = c1Start, c2 = c2Start; c1 >= 1 && c2 <= c2End; c1--, c2++) {
            System.out.println(i + " " + c1 + " " + c2);
            if (!pattern.row(c1).equals(pattern.row(c2))) {
                return false;
            }
        }
        return true;
    }
}
