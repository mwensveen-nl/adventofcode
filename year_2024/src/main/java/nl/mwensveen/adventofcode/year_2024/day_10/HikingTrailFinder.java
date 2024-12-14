package nl.mwensveen.adventofcode.year_2024.day_10;

import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import java.util.HashSet;
import java.util.Set;

public class HikingTrailFinder {
    public Long minRow = 0L;
    public Long maxRow;
    public Long minCol = 0L;
    public Long maxCol;
    public Integer nine = Integer.valueOf(9);
    public Integer zero = Integer.valueOf(0);

    public int countTrails(Table<Long, Long, Integer> map) {
        maxRow = Long.valueOf(map.rowKeySet().size() - 1);
        maxCol = Long.valueOf(map.columnKeySet().size() - 1);
        return map.cellSet().stream().filter(c -> c.getValue().equals(Integer.valueOf(0))).mapToInt(c -> countForTrailHead(c, map)).sum();
    }

    private int countForTrailHead(Cell<Long, Long, Integer> c, Table<Long, Long, Integer> map) {
        Coordinate coord = new Coordinate(c.getRowKey(), c.getColumnKey());
        Set<Coordinate> visited = new HashSet<>();
        visited.add(coord);
        int count = 0;
        count += step(coord.up(), zero, visited, map);
        count += step(coord.right(), zero, visited, map);
        count += step(coord.down(), zero, visited, map);
        count += step(coord.left(), zero, visited, map);
        return count;
    }

    private int step(Coordinate coor, Integer i, Set<Coordinate> visited, Table<Long, Long, Integer> map) {
        if (coor.row() >= minRow && coor.row() <= maxRow &&
                coor.col() >= minCol && coor.col() <= maxCol &&
                !visited.contains(coor)) {
            Integer step = map.get(coor.row(), coor.col());
            if (i + 1 == step.intValue()) {
                if (nine.equals(step)) {
                    visited.add(coor);
                    return 1;
                }
                int count = 0;
                visited.add(coor);
                count += step(coor.up(), step, visited, map);
                count += step(coor.right(), step, visited, map);
                count += step(coor.down(), step, visited, map);
                count += step(coor.left(), step, visited, map);
                return count;
            }
        }
        return 0;
    }
}
