package nl.mwensveen.adventofcode.year_2025.day_09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RedGreenTileRectanglerTest {
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
        RedGreenTileRectangler redGreenTileRectangler = new RedGreenTileRectangler();
        long area = redGreenTileRectangler.find(tiles);

        assertEquals(24, area);
    }

}
