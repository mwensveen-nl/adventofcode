package nl.mwensveen.adventofcode.year_2021.day_15;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;
import java.util.stream.Collectors;

public class RiskLevelParser {

    Table<Integer, Integer, RiskLevel> parseInput(List<String> input) {
        Table<Integer, Integer, RiskLevel> caveGrid = HashBasedTable.create();
        StreamUtils.zipWithIndex(input.stream()).forEach(entry -> parseRow(entry.getIndex(), entry.getValue(), caveGrid));

        caveGrid.values().forEach(rl -> setAdjent(rl, caveGrid));
        caveGrid.get(0, 0).setDistance(0L);
        return caveGrid;
    }

    private void setAdjent(RiskLevel rl, Table<Integer, Integer, RiskLevel> caveGrid) {
        if (caveGrid.contains(rl.getRow() - 1, rl.getColumn())) {
            rl.setUp(caveGrid.get(rl.getRow() - 1, rl.getColumn()));
        }
        if (caveGrid.contains(rl.getRow() + 1, rl.getColumn())) {
            rl.setDown(caveGrid.get(rl.getRow() + 1, rl.getColumn()));
        }
        if (caveGrid.contains(rl.getRow(), rl.getColumn() - 1)) {
            rl.setLeft(caveGrid.get(rl.getRow(), rl.getColumn() - 1));
        }
        if (caveGrid.contains(rl.getRow(), rl.getColumn() + 1)) {
            rl.setRight(caveGrid.get(rl.getRow(), rl.getColumn() + 1));
        }
    }

    private void parseRow(long rowNr, String row, Table<Integer, Integer, RiskLevel> caveGrid) {
        List<Integer> columns = stringAsList(row);
        StreamUtils.zipWithIndex(columns.stream()).map(entry -> new RiskLevel((int) rowNr, (int) entry.getIndex(), entry.getValue()))
                .forEach(rl -> caveGrid.put(rl.getRow(), rl.getColumn(), rl));
    }

    private List<Integer> stringAsList(String signal) {
        return signal.chars().mapToObj(c -> Character.getNumericValue(c)).collect(Collectors.toList());
    }
}
