package nl.mwensveen.adventofcode.year_2021.day_04;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;

public class BingoBoardParser {

    Table<Long, Long, Integer> parseBoard(List<String> input) {
        Table<Long, Long, Integer> board = HashBasedTable.create(5, 5);

        StreamUtils.zipWithIndex(input.stream()).forEach(s -> parseRow(s, board));
        return board;
    }

    private void parseRow(Indexed<String> index, Table<Long, Long, Integer> board) {
        long row = index.getIndex();
        String s = index.getValue();
        String[] split = s.trim().split("\\s+");
        Arrays.stream(split);
        StreamUtils.zipWithIndex(Arrays.stream(split)).forEach(index2 -> board.put(row, index2.getIndex(), Integer.parseInt(index2.getValue())));
    }
}
