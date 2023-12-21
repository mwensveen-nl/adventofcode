package nl.mwensveen.adventofcode.year_2023.day_16;

import com.google.common.collect.Table;
import java.util.Set;
import java.util.stream.LongStream;

public class EnergyMaximizer {

    public long maximize(Table<Integer, Integer, Cell> contraption) {
        ContraptionBeamer contraptionBeamer = new ContraptionBeamer();
        int rowKey = 0;
        long result0 = maximizeRow(contraption, contraptionBeamer, rowKey, Direction.DOWN);

        rowKey = contraption.column(0).size() - 1;
        long result1 = maximizeRow(contraption, contraptionBeamer, rowKey, Direction.UP);

        int colKey = 0;
        long result2 = maximizeCol(contraption, contraptionBeamer, colKey, Direction.RIGHT);

        colKey = contraption.row(0).size() - 1;
        long result3 = maximizeCol(contraption, contraptionBeamer, colKey, Direction.LEFT);

        return LongStream.of(result0, result1, result2, result3).max().getAsLong();

    }

    private long maximizeCol(Table<Integer, Integer, Cell> contraption, ContraptionBeamer contraptionBeamer, int colKey, Direction direction) {
        Set<Integer> col = contraption.column(0).keySet();
        return col.stream().map(row -> new Beam(row, colKey, direction)).mapToLong(beam -> contraptionBeamer.beam(beam, contraption)).max().getAsLong();
    }

    private long maximizeRow(Table<Integer, Integer, Cell> contraption, ContraptionBeamer contraptionBeamer, int rowKey, Direction direction) {
        Set<Integer> row = contraption.row(rowKey).keySet();
        return row.stream().map(col -> new Beam(rowKey, col, direction)).mapToLong(beam -> contraptionBeamer.beam(beam, contraption)).max().getAsLong();
    }
}
