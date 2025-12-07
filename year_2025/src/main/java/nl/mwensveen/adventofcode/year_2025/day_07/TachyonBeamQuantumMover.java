package nl.mwensveen.adventofcode.year_2025.day_07;

import com.google.common.collect.Table;
import org.javatuples.Pair;

public class TachyonBeamQuantumMover {
    private static final Character BEAM = '|';
    private static final Character SPLITTER = '^';
    private int rows;
    private int cols;
    private int splitCount;

    public Integer moveDown(Table<Integer, Integer, Character> manifold, Pair<Integer, Integer> start) {
        rows = manifold.rowKeySet().size();
        cols = manifold.columnKeySet().size();
        var startRow = start.getValue0();
        var startCol = start.getValue1();

        cleanManifold(manifold, rows, cols);

        splitCount = 1;

        move(startRow + 1, startCol, manifold);
        return splitCount;
    }

    private int move(int r, int c, Table<Integer, Integer, Character> manifold) {
        if (r < rows & c < cols) {
            if (SPLITTER.equals(manifold.get(r, c))) {
                // left
                move(r + 1, c - 1, manifold);

                splitCount++;
                // right
                move(r + 1, c + 1, manifold);
            } else {
                move(r + 1, c, manifold);
            }
        }
        return splitCount;
    }

    private void cleanManifold(Table<Integer, Integer, Character> manifold, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (manifold.get(r, c).equals('.')) {
                    manifold.remove(r, c);
                }
            }
        }
    }

}
