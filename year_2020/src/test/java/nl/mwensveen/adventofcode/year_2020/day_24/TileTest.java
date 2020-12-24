package nl.mwensveen.adventofcode.year_2020.day_24;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TileTest {

    @Test
    public void testFlip() throws Exception {
        Tile tile = new Tile("neeswseenwwswnwswswnw");
        assertEquals(1, tile.getSn());
        assertEquals(-3, tile.getEw());
        assertEquals(Color.WHITE, tile.getColor());
        tile.flip();
        assertEquals(Color.BLACK, tile.getColor());
        tile.flip();
        assertEquals(Color.WHITE, tile.getColor());
    }

}
