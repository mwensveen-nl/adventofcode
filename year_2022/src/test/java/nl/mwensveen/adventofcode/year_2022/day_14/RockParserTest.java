package nl.mwensveen.adventofcode.year_2022.day_14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockParserTest {
    private String input = """
            498,4 -> 498,6 -> 496,6
            503,4 -> 502,4 -> 502,9 -> 494,9
                    """;

    @Test
    public void testParse() {
        RockParser parser = new RockParser();
        Cave cave = parser.parse(input.lines().toList());

        assertEquals(494, cave.getxMin());
        assertEquals(503, cave.getxMax());
        assertEquals(4, cave.getyMin());
        assertEquals(9, cave.getyMax());

        assertEquals("#", cave.getMap().get(498, 4));
        assertEquals("#", cave.getMap().get(503, 4));
        assertEquals("#", cave.getMap().get(502, 4));
        assertEquals("#", cave.getMap().get(502, 5));
        assertEquals("#", cave.getMap().get(502, 6));
        assertEquals("#", cave.getMap().get(502, 7));
        assertEquals("#", cave.getMap().get(502, 8));
        assertEquals("#", cave.getMap().get(502, 9));
        assertEquals("#", cave.getMap().get(501, 9));
        assertEquals("#", cave.getMap().get(500, 9));
        assertEquals("#", cave.getMap().get(499, 9));
        assertEquals("#", cave.getMap().get(498, 9));
        assertEquals("#", cave.getMap().get(497, 9));
        assertEquals("#", cave.getMap().get(496, 9));
        assertEquals("#", cave.getMap().get(495, 9));
        assertEquals("#", cave.getMap().get(494, 9));
    }

}
