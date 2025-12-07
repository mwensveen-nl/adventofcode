package nl.mwensveen.adventofcode.year_2025.day_07;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;
import java.util.stream.IntStream;
import org.javatuples.Pair;

public class TachyonManifoldParser {

    public Table<Integer, Integer, Character> parse(List<String> input) {
        Table<Integer, Integer, Character> table = HashBasedTable.create();

        IntStream.range(0, input.size()).forEach(i -> parseLine(i, input.get(i), table));
        return table;
    }

    private void parseLine(int i, String line, Table<Integer, Integer, Character> table) {
        IntStream.range(0, line.length()).forEach(j -> table.put(i, j, line.charAt(j)));
    }

    public Pair<Integer, Integer> findStart(Table<Integer, Integer, Character> manifold) {
        var rows = manifold.rowKeySet().size();
        var cols = manifold.columnKeySet().size();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (manifold.get(r, c).equals('S')) {
                    return new Pair(r, c);
                }
            }
        }
        return null;
    }
}
