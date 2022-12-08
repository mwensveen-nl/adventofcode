package nl.mwensveen.adventofcode.year_2022.day_08;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import java.util.List;
import java.util.stream.IntStream;

public class ForestParser {

    Table<Integer, Integer, Tree> parse(List<String> input) {
        Table<Integer, Integer, Tree> forest = TreeBasedTable.create();
        IntStream.range(0, input.size()).forEach(i -> addForestRow(i, input.get(i), forest));
        return forest;
    }

    private void addForestRow(int row, String inputRow, Table<Integer, Integer, Tree> forest) {
        IntStream.range(0, inputRow.length()).forEach(i -> addForestTree(row, i, inputRow.substring(i, i + 1), forest));
    }

    private void addForestTree(int row, int column, String tree, Table<Integer, Integer, Tree> forest) {
        forest.put(row, column, new Tree(Integer.parseInt(tree)));
    }

}
