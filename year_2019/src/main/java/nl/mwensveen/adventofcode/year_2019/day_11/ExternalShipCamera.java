package nl.mwensveen.adventofcode.year_2019.day_11;

import com.google.common.collect.Table;
import java.util.Set;

public class ExternalShipCamera {

    private final Table<Integer, Integer, Color> hull;

    public ExternalShipCamera(Table<Integer, Integer, Color> hull) {
        this.hull = hull;
    }

    public void showHull() {
        Set<Integer> rowKeys = hull.rowKeySet();
        Set<Integer> columnKeys = hull.columnKeySet();

        int minRowKey = rowKeys.stream().mapToInt(Integer::intValue).min().getAsInt();
        int maxRowKey = rowKeys.stream().mapToInt(Integer::intValue).max().getAsInt();
        int minColumnKey = columnKeys.stream().mapToInt(Integer::intValue).min().getAsInt();
        int maxColumnKey = columnKeys.stream().mapToInt(Integer::intValue).max().getAsInt();

        for (int i = minColumnKey; i <= maxColumnKey; i++) {
            for (int j = minRowKey; j <= maxRowKey; j++) {
                Color c = hull.contains(j, i) ? hull.get(j, i) : Color.BLACK;
                System.out.print(c == Color.BLACK ? " " : ".");
            }
            System.out.println();
        }
    }
}
