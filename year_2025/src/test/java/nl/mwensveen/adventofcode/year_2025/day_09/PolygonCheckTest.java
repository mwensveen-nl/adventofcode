package nl.mwensveen.adventofcode.year_2025.day_09;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PolygonCheckTest {
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
    public void isPointInPolygon() {
        var tiles = input.lines().map(Tile::new).toList();
        PolygonCheck polygonCheck = new PolygonCheck(tiles);
        assertFalse(polygonCheck.isPointInPolygon(0, 0));
        assertFalse(polygonCheck.isPointInPolygon(12, 1));
        assertFalse(polygonCheck.isPointInPolygon(9, 8));
        assertTrue(polygonCheck.isPointInPolygon(7, 1));
        assertTrue(polygonCheck.isPointInPolygon(11, 1));
        assertTrue(polygonCheck.isPointInPolygon(11, 2));
        assertTrue(polygonCheck.isPointInPolygon(11, 7));
        assertTrue(polygonCheck.isPointInPolygon(9, 7));
    }

    @Test
    public void isRectangleInPolygon() {
        var tiles = input.lines().map(Tile::new).toList();
        PolygonCheck polygonCheck = new PolygonCheck(tiles);
        Rectangle r = new Rectangle(new Tile(7, 2), new Tile(11, 1));
        assertTrue(polygonCheck.isRectangleInPolygon(r));
    }

}
