package nl.mwensveen.adventofcode.year_2024.day_12;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Streams;
import com.google.common.collect.Table;
import java.util.List;
import org.javatuples.Pair;

public class GardenParser {

    public Table<Long, Long, String> parse(List<String> input) {
        Table<Long, Long, String> map = HashBasedTable.create();
        Streams.mapWithIndex(input.stream(), (line, row) -> new Pair<Long, String>(row, line))
                .forEach(p -> mapRows(p.getValue0(), p.getValue1(), map));
        return map;
    }

    private void mapRows(Long row, String line, Table<Long, Long, String> map) {
        Streams.mapWithIndex(line.chars(), (c, col) -> new Pair<Long, String>(col, Character.toString(c)))
                .forEach(p -> mapCol(row, p.getValue0(), p.getValue1(), map));
        ;
    }

    private void mapCol(Long row, Long col, String c, Table<Long, Long, String> map) {
        map.put(row, col, c);
    }

}
