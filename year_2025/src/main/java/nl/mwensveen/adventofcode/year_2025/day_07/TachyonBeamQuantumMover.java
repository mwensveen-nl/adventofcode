package nl.mwensveen.adventofcode.year_2025.day_07;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.math.BigInteger;
import org.javatuples.Pair;

public class TachyonBeamQuantumMover {
    private static final Character SPLITTER = '^';
    private static final Long LONGSPLITTER = -1L;
    private int rows;
    private int cols;

    public BigInteger moveDown(Table<Integer, Integer, Character> manifoldIn, Pair<Integer, Integer> start) {
        rows = manifoldIn.rowKeySet().size();
        cols = manifoldIn.columnKeySet().size();
        var startRow = start.getValue0();
        var startCol = start.getValue1();
        Table<Integer, Integer, Long> manifold = cleanManifold(manifoldIn);
        manifold.put(startRow + 1, startCol, 1L);

        for (int r = startRow + 2; r < rows; r = r + 2) {
            for (int c = 0; c < cols; c++) {
                if (manifold.get(r, c).equals(LONGSPLITTER)) {
                    Long valueUp = manifold.get(r - 1, c);
                    Long valueDownToLeft = manifold.get(r + 1, c - 1);
                    Long valueDownToRight = manifold.get(r + 1, c + 1);
                    manifold.put(r + 1, c - 1, valueUp + valueDownToLeft);
                    manifold.put(r + 1, c + 1, valueUp + valueDownToRight);
                } else {
                    Long valueUp = manifold.get(r - 1, c);
                    Long valueDown = manifold.get(r + 1, c);
                    manifold.put(r + 1, c, valueDown + valueUp);
                }
            }
        }
        return manifold.row(rows - 1).values().stream().map(BigInteger::valueOf).reduce(BigInteger.ZERO, BigInteger::add);
    }

    private Table<Integer, Integer, Long> cleanManifold(Table<Integer, Integer, Character> manifold) {
        Table<Integer, Integer, Long> newManifold = HashBasedTable.create();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (manifold.get(r, c).equals(SPLITTER)) {
                    newManifold.put(r, c, LONGSPLITTER);
                } else {
                    newManifold.put(r, c, 0L);
                }
            }
        }
        return newManifold;
    }

}
