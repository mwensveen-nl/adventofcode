package nl.mwensveen.adventofcode.year_2019.day_17;

import com.google.common.collect.Table;
import java.util.Comparator;

public class ScaffoldProcessor {

    public int sumAlignmentParameters(Table<Integer, Integer, OutputView> table) {
        int minX = table.rowKeySet().stream().min(Comparator.comparingInt(Integer::intValue)).get().intValue();
        int maxX = table.rowKeySet().stream().max(Comparator.comparingInt(Integer::intValue)).get().intValue();
        int minY = table.columnKeySet().stream().min(Comparator.comparingInt(Integer::intValue)).get().intValue();
        int maxY = table.columnKeySet().stream().max(Comparator.comparingInt(Integer::intValue)).get().intValue();

        int sum = 0;
        for (int y = minY + 1; y < maxY; y++) {
            for (int x = minX + 1; x < maxX; x++) {
                if (isScaffold(x, y, table) && isScaffold(x - 1, y, table) && isScaffold(x + 1, y, table) && isScaffold(x, y - 1, table)
                        && isScaffold(x, y + 1, table)) {
                    sum += x * y;
                }

            }
        }
        return sum;
    }

    private boolean isScaffold(int x, int y, Table<Integer, Integer, OutputView> table) {
        return table.get(x, y).equals(OutputView.SCAFFOLD);
    }

}
