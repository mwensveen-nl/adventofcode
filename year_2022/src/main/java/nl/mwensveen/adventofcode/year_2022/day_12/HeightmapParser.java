package nl.mwensveen.adventofcode.year_2022.day_12;

import java.util.List;
import java.util.stream.IntStream;

public class HeightmapParser {

    public Heightmap parse(List<String> input) {
        Heightmap heightmap = new Heightmap();
        IntStream.range(0, input.size()).forEach(row -> parse(row, input.get(row), heightmap));
        return heightmap;
    }

    private void parse(int row, String line, Heightmap heightmap) {
        IntStream.range(0, line.length()).forEach(col -> parse(row, col, line.charAt(col), heightmap));
    }

    private void parse(int row, int col, char elevation, Heightmap heightmap) {
        if ('S' == elevation) {
            heightmap.setStartRow(row);
            heightmap.setStartCol(col);
            Coordinate c = new Coordinate('a', row, col);
            heightmap.getCoordinates().put(row, col, c);
        } else if ('E' == elevation) {
            heightmap.setEndRow(row);
            heightmap.setEndCol(col);
            Coordinate c = new Coordinate('z', row, col);
            heightmap.getCoordinates().put(row, col, c);
        } else {
            Coordinate c = new Coordinate(elevation, row, col);
            heightmap.getCoordinates().put(row, col, c);
        }
    }
}
