package nl.mwensveen.adventofcode.year_2024.day_12;

import com.google.common.collect.Table;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class FenceCalculator {
    public long calculate(Table<Long, Long, String> garden) {
        long rows = garden.rowKeySet().size();
        long cols = garden.columnKeySet().size();
        long price = 0;
        for (long r = 0; r < rows; r++) {
            for (long c = 0; c < cols; c++) {
                String plot = garden.get(r, c);
                if (!plot.equals(".")) {
                    Set<Coordinate> plots = new HashSet<>();
                    findPlods(r, c, plot, garden, plots);
                    int plotCount = plots.size();
                    int fenceCount = countFences(garden, plots);
                    markCounted(garden, plots);
                    price += plotCount * fenceCount;
                }
            }

        }
        return price;
    }

    private void markCounted(Table<Long, Long, String> garden, Set<Coordinate> plots) {
        plots.forEach(c -> garden.put(c.row(), c.col(), "."));

    }

    private int countFences(Table<Long, Long, String> garden, Set<Coordinate> plots) {
        return plots.stream().mapToInt(c -> countFences(garden, c)).sum();
    }

    private int countFences(Table<Long, Long, String> garden, Coordinate c) {
        String plot = garden.get(c.row(), c.col());
        int count = 0;
        count += !plot.equals(garden.get(c.row() - 1, c.col())) ? 1 : 0;
        count += !plot.equals(garden.get(c.row(), c.col() + 1)) ? 1 : 0;
        count += !plot.equals(garden.get(c.row() + 1, c.col())) ? 1 : 0;
        count += !plot.equals(garden.get(c.row(), c.col() - 1)) ? 1 : 0;
        return count;
    }

    private void findPlods(long r, long c, String plot, Table<Long, Long, String> garden, Set<Coordinate> plots) {
        if (plot.equals(garden.get(r, c))) {
            plots.add(new Coordinate(r, c));
            garden.put(r, c, plot.toLowerCase(Locale.getDefault()));
            findPlods(r - 1, c, plot, garden, plots);
            findPlods(r, c + 1, plot, garden, plots);
            findPlods(r + 1, c, plot, garden, plots);
            findPlods(r, c - 1, plot, garden, plots);
        }
    }
}
