package nl.mwensveen.adventofcode.year_2021.day_11;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;
import java.util.stream.Collectors;

public class OctopusGridParser {

    Table<Integer, Integer, Octopus> parseGrid(List<String> input) {
        Table<Integer, Integer, Octopus> grid = HashBasedTable.create();

        StreamUtils.zipWithIndex(input.stream()).forEach(ir -> parseRow(ir, grid));
        return grid;
    }

    private void parseRow(Indexed<String> ir, Table<Integer, Integer, Octopus> grid) {
        long rowNr = ir.getIndex();
        StreamUtils.zipWithIndex(stringAsList(ir.getValue()).stream()).forEach(ic -> parseCell(rowNr, ic, grid));
    }

    private void parseCell(long rowNr, Indexed<Integer> ic, Table<Integer, Integer, Octopus> grid) {
        grid.put(Integer.valueOf((int) rowNr), Integer.valueOf((int) ic.getIndex()), new Octopus(ic.getValue()));
    }

    private List<Integer> stringAsList(String signal) {
        return signal.chars().mapToObj(c -> Character.getNumericValue(c)).collect(Collectors.toList());
    }
}
