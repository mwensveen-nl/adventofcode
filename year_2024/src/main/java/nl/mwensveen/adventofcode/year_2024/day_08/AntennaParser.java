package nl.mwensveen.adventofcode.year_2024.day_08;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Streams;
import java.util.List;
import java.util.stream.IntStream;
import org.javatuples.Pair;

public class AntennaParser {

    private Multimap<String, Position> grid = HashMultimap.create();

    public Multimap<String, Position> parse(List<String> input) {
        Streams.mapWithIndex(input.stream(), (line, index) -> new Pair<>(index, line)).forEach(this::parseLine);
        return grid;
    }

    private void parseLine(Pair<Long, String> p) {
        Long row = p.getValue0();
        String line = p.getValue1();
        IntStream.range(0, line.length())
                .filter(col -> !".".equals(line.substring(col, col + 1)))
                .forEach(col -> grid.put(line.substring(col, col + 1), new Position(row.intValue(), col)));
    }
}
