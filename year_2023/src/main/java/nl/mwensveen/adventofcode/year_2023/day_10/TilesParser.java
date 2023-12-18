package nl.mwensveen.adventofcode.year_2023.day_10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TilesParser {
    public Map<Coordinate, Pipes> parse(List<String> input) {
        Map<Coordinate, Pipes> map = new HashMap<>();

        IntStream.range(0, input.size()).forEach(row -> processLine(input.get(row), row, map));
        return map;
    }

    private void processLine(String line, int row, Map<Coordinate, Pipes> map) {
        IntStream.range(0, line.length()).forEach(col -> processPipe(row, col, line.substring(col, col + 1), map));
    }

    private void processPipe(int row, int col, String pipeSymbol, Map<Coordinate, Pipes> map) {
        Pipes pipes = Pipes.find(pipeSymbol);
        if (pipes != null) {
            map.put(new Coordinate(col, row), pipes);
        }
    }
}
