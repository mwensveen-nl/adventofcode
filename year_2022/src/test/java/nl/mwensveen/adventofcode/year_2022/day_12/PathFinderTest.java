package nl.mwensveen.adventofcode.year_2022.day_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathFinderTest {
    private String input = """
            Sabqponm
            abcryxxl
            accszExk
            acctuvwj
            abdefghi
                    """;

    @Test
    public void testFindShortestPath() {
        HeightmapParser parser = new HeightmapParser();
        Heightmap heightmap = parser.parse(input.lines().toList());
        PathFinder pathFinder = new PathFinder();
        Coordinate coordinate = pathFinder.findShortestPath(heightmap);
        assertEquals(31, coordinate.getSteps());
        System.out.println(coordinate);
        System.out.println(coordinate.getShortestPath());
    }

}
