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
        return caveGrid;
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
