package nl.mwensveen.adventofcode.year_2020.day_03;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;

public class TobogganTrajectoryCalculator {

    private static final String TREE = "#";
    private Table<Long, Long, String> grid;

    public TobogganTrajectoryCalculator(List<String> input) {
        grid = HashBasedTable.create();
        StreamUtils.zipWithIndex(input.stream()).forEach(is -> addRowToGrid(is.getIndex(), is.getValue(), grid));
    }

    private void addRowToGrid(long rowNumber, String row, Table<Long, Long, String> grid) {
        StreamUtils.zipWithIndex(row.chars().mapToObj(c -> String.valueOf((char) c))).forEach(ic -> grid.put(rowNumber, ic.getIndex(), ic.getValue()));
    }

    public long countNumberOfTrees(int rightStep, int downStep) {
        long r = 0, c = 0;
        int numberOfRows = grid.rowKeySet().size();
        int numberOfColumns = grid.columnKeySet().size();
        long numberOfTrees = 0;
        while (r < numberOfRows) {
            if (c >= numberOfColumns) {
                c -= numberOfColumns;
            }
            if (grid.get(r, c).equals(TREE)) {
                numberOfTrees++;
            }
            r += downStep;
            c += rightStep;
        }
        return numberOfTrees;
    }

}
