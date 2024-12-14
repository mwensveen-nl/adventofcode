package nl.mwensveen.adventofcode.year_2024.day_10;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Streams;
import com.google.common.collect.Table;
import java.util.List;
import org.javatuples.Pair;

public class MapParser {

    public Table<Long, Long, Integer> map(List<String> input) {
        Table<Long, Long, Integer> map = HashBasedTable.create();
        Streams.mapWithIndex(input.stream(), (line, row) -> new Pair<Long, String>(row, line))
                .forEach(p -> mapRows(p.getValue0(), p.getValue1(), map));
        return map;
    }

    private void mapRows(Long row, String line, Table<Long, Long, Integer> map) {
        Streams.mapWithIndex(line.chars().mapToObj(c -> Integer.valueOf(Character.toString(c))), (i, col) -> new Pair<Long, Integer>(col, i))
                .forEach(p -> mapCol(row, p.getValue0(), p.getValue1(), map));
        ;
    }

    private void mapCol(Long row, Long col, Integer number, Table<Long, Long, Integer> map) {
        map.put(row, col, number);
    }

}
