package nl.mwensveen.adventofcode.year_2020.day_11;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FloorPlanParser {

    public Table<Long, Long, PositionState> parse(List<String> input) {
        Table<Long, Long, PositionState> plan = HashBasedTable.create();
        StreamUtils.zipWithIndex(input.stream()).forEach(index -> parseRow(index.getIndex(), index.getValue(), plan));
        return plan;
    }

    private void parseRow(long index, String row, Table<Long, Long, PositionState> plan) {
        Stream<String> cols = Arrays.stream(row.split(""));
        StreamUtils.zipWithIndex(cols).forEach(col -> plan.put(index, col.getIndex(), PositionState.find(col.getValue())));
    }
}
