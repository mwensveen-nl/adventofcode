package nl.mwensveen.adventofcode.year_2023.day_10;

import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoopFinderTest {
    private String input = """
            .....
            .S-7.
            .|.|.
            .L-J.
            .....
                    """;

    private String input2 = """
            ..F7.
            .FJ|.
            SJ.L7
            |F--J
            LJ...
                        """;

    private String input3 = """
            -L|F7
            7S-7|
            L|7||
            -L-J|
            L|-JF
                        """;

    @Test
    public void testFindLoop() {
        Map<Coordinate, Pipes> table = new TilesParser().parse(input.lines().toList());
        int count = new LoopFinder().findLoop(table);
        assertEquals(4, count);
    }

    @Test
    public void testFindLoop2() {
        Map<Coordinate, Pipes> table = new TilesParser().parse(input2.lines().toList());
        int count = new LoopFinder().findLoop(table);
        assertEquals(8, count);
    }

    @Test
    public void testFindLoop3() {
        Map<Coordinate, Pipes> table = new TilesParser().parse(input3.lines().toList());
        int count = new LoopFinder().findLoop(table);
        assertEquals(4, count);
    }

}
