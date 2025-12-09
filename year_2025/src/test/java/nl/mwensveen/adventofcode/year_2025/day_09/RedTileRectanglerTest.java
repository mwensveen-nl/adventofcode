package nl.mwensveen.adventofcode.year_2025.day_09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RedTileRectanglerTest {
    private String input = """
            7,1
            11,1
            11,7
            9,7
            9,5
            2,5
            2,3
            7,3
                    """;

    @Test
    public void find() {
        var tiles = input.lines().map(Tile::new).toList();
        long size = new RedTileRectangler().find(tiles);
        assertEquals(50, size);
    }

}
