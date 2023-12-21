package nl.mwensveen.adventofcode.year_2023.day_16;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;
import java.util.stream.IntStream;

public class ContraptionParser {

    public Table<Integer, Integer, Cell> parse(List<String> input) {
        Table<Integer, Integer, Cell> contraption = HashBasedTable.create();
        IntStream.range(0, input.size()).forEach(row -> parseRow(row, input.get(row), contraption));
        return contraption;
    }

    private void parseRow(int row, String s, Table<Integer, Integer, Cell> contraption) {
        IntStream.range(0, s.length()).forEach(col -> parseCell(row, col, String.valueOf(s.charAt(col)), contraption));
    }

    private void parseCell(int row, int col, String valueOf, Table<Integer, Integer, Cell> contraption) {
        contraption.put(row, col, new Cell(valueOf));
    }
}
