package nl.mwensveen.adventofcode.year_2023.day_10;

import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TilesParserTest {

    private String input = """
            .....
            .S-7.
            .|.|.
            .L-J.
            .....
                        """;

    @Test
    public void testParse() {
        Map<Coordinate, Pipes> grid = new TilesParser().parse(input.lines().toList());
        assertEquals(Pipes.START, grid.get(new Coordinate(1, 1)));
        assertEquals(Pipes.NW, grid.get(new Coordinate(3, 3)));
        assertFalse(grid.containsKey(new Coordinate(0, 0)));
    }

}
