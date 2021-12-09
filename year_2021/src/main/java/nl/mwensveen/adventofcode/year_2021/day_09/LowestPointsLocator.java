package nl.mwensveen.adventofcode.year_2021.day_09;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.javatuples.Pair;

public class LowestPointsLocator {
    private static final Integer NINE = Integer.valueOf(9);

    Integer locateLowestPoints(List<String> input) {
        Table<Long, Long, Integer> table = fillTable(input);
        List<Pair<Long, Long>> lowestPoints = findLowestPoints(input, table);

        return lowestPoints.stream().map(p -> table.get(p.getValue0(), p.getValue1()).intValue() + 1).collect(Collectors.summingInt(i -> i));
    }

    int calculateBasins(List<String> input) {
        Table<Long, Long, Integer> table = fillTable(input);
        List<Pair<Long, Long>> lowestPoints = findLowestPoints(input, table);

        List<Integer> basinSizes = lowestPoints.stream().map(point -> getBasinSize(point, table)).toList();
        basinSizes = new ArrayList<>(basinSizes);
        basinSizes.sort(Comparator.reverseOrder());
        return basinSizes.get(0).intValue() * basinSizes.get(1).intValue() * basinSizes.get(2).intValue();
    }

    private Integer getBasinSize(Pair<Long, Long> point, Table<Long, Long, Integer> table) {
        List<Pair<Long, Long>> done = new ArrayList<>();
        return getBasinSize(point, table, done);
    }

    private int getBasinSize(Pair<Long, Long> coordinate, Table<Long, Long, Integer> table, List<Pair<Long, Long>> done) {
        int size = 0;
        if (done.contains(coordinate)) {
            return size;
        }
        done.add(coordinate);
        Long r = coordinate.getValue0();
        Long c = coordinate.getValue1();
        Integer val = table.get(r, c);
        if (val == null) {
            return size;
        }

        if (val.equals(NINE)) {
            return size;
        }

        size = 1;
        size += getBasinSize(Pair.with(r - 1, c), table, done);
        size += getBasinSize(Pair.with(r, c - 1), table, done);
        size += getBasinSize(Pair.with(r, c + 1), table, done);
        size += getBasinSize(Pair.with(r + 1, c), table, done);

        return size;
    }

    private List<Pair<Long, Long>> findLowestPoints(List<String> input, Table<Long, Long, Integer> table) {
        int nrRows = input.size();
        int nrCols = input.get(0).length();
        List<Pair<Long, Long>> lowestPoints = new ArrayList<>();
        LongStream.range(0, nrRows).forEach(
                r -> LongStream.range(0, nrCols).filter(c -> checkLowestPoint(r, c, table)).mapToObj(c -> Pair.with(r, c)).forEach(p -> lowestPoints.add(p)));
        return lowestPoints;
    }

    private boolean checkLowestPoint(long r, long c, Table<Long, Long, Integer> table) {
        int min = Integer.MAX_VALUE;
        min = Math.min(min, table.contains(r - 1, c) ? table.get(r - 1, c) : min);
        min = Math.min(min, table.contains(r + 1, c) ? table.get(r + 1, c) : min);
        min = Math.min(min, table.contains(r, c - 1) ? table.get(r, c - 1) : min);
        min = Math.min(min, table.contains(r, c + 1) ? table.get(r, c + 1) : min);
        int value = table.get(r, c);
        return value < min;
    }

    private Table<Long, Long, Integer> fillTable(List<String> input) {
        Table<Long, Long, Integer> grid = HashBasedTable.create();
        StreamUtils.zipWithIndex(input.stream()).forEach(e -> fillTableRow(e, grid));
        return grid;
    }

    private void fillTableRow(Indexed<String> row, Table<Long, Long, Integer> grid) {
        long rowNumber = row.getIndex();
        StreamUtils.zipWithIndex(stringAsList(row.getValue()).stream()).forEach(col -> grid.put(rowNumber, col.getIndex(), col.getValue()));
    }

    private List<Integer> stringAsList(String signal) {
        return signal.chars().mapToObj(c -> Character.getNumericValue(c)).collect(Collectors.toList());
    }
}
