package nl.mwensveen.adventofcode.year_2025.day_09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TileTest {

    @Test
    public void test() {
        var t = new Tile(7, 1);
        assertEquals(7, t.x());
        assertEquals(1, t.y());
    }
}
