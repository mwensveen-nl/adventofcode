package nl.mwensveen.adventofcode.year_2025.day_09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RectangleTest {
    @Test
    public void test() {
        var t1 = new Tile(2, 5);
        var t2 = new Tile(9, 7);
        assertEquals(24, new Rectangle(t1, t2).area());
    }

    @Test
    public void test2() {
        var t1 = new Tile(7, 3);
        var t2 = new Tile(2, 3);
        assertEquals(6, new Rectangle(t1, t2).area());
    }
}
