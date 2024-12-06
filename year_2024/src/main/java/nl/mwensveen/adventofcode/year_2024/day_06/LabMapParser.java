package nl.mwensveen.adventofcode.year_2024.day_06;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;
import java.util.stream.IntStream;

public class LabMapParser {

    public Table<Integer, Integer, Cell> parse(List<String> input) {
        Table<Integer, Integer, Cell> lm = HashBasedTable.create();
        IntStream.range(0, input.size()).forEach(r -> parseRow(lm, r, input.get(r)));
        return lm;
    }

    private void parseRow(Table<Integer, Integer, Cell> lm, int r, String row) {
        IntStream.range(0, row.length()).forEach(c -> lm.put(r, c, Cell.find(row.substring(c, c + 1))));
    }

    public Guard findGuard(Table<Integer, Integer, Cell> lm) {
        for (int r = 0; r < lm.rowKeySet().size(); r++) {
            for (int c = 0; c < lm.columnKeySet().size(); c++) {
                if (lm.get(r, c).equals(Cell.GUARD)) {
                    return new Guard(r, c);
                }
            }
        }
        return null;
    }
}
