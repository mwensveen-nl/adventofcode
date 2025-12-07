package nl.mwensveen.adventofcode.year_2025.day_07;

import com.google.common.collect.Table;
import org.javatuples.Pair;

public class TachyonBeamMover {
    private static final Character BEAM = '|';
    private static final Character SPLITTER = '^';

    public Integer moveDown(Table<Integer, Integer, Character> manifold, Pair<Integer, Integer> start) {
        var rows = manifold.rowKeySet().size();
        var cols = manifold.columnKeySet().size();
        var startRow = start.getValue0();
        var startCol = start.getValue1();

        var r = startRow + 1;
        var splitCount = 0;
        manifold.put(r, startCol, BEAM);
        r++;
        for (; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (manifold.get(r - 1, c).equals(BEAM)) {
                    if (manifold.get(r, c).equals(SPLITTER)) {
                        manifold.put(r, c - 1, BEAM);
                        manifold.put(r, c + 1, BEAM);
                        splitCount++;
                    } else {
                        manifold.put(r, c, BEAM);
                    }
                }
            }
        }
        return splitCount;
    }
}
