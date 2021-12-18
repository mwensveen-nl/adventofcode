package nl.mwensveen.adventofcode.year_2021.day_17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TargetAreaTest {

    @Test
    public void testParse() {
        TargetArea targetArea = TargetArea.parse("target area: x=20..30, y=-10..-5");
        assertEquals(20, targetArea.getxMin());
        assertEquals(30, targetArea.getxMax());
        assertEquals(-10, targetArea.getyMin());
        assertEquals(-5, targetArea.getyMax());
    }

    @Test
    public void testIsBeyond() {
        TargetArea targetArea = TargetArea.parse("target area: x=20..30, y=-10..-5");

        assertFalse(targetArea.isBeyond(0, 0));

        assertFalse(targetArea.isBeyond(20, 0));
        assertFalse(targetArea.isBeyond(30, 0));
        assertTrue(targetArea.isBeyond(31, 0));

        assertFalse(targetArea.isBeyond(0, -5));
        assertFalse(targetArea.isBeyond(0, -10));
        assertTrue(targetArea.isBeyond(0, -11));
        assertFalse(targetArea.isBeyond(0, 11));
    }

    @Test
    public void testIsInArea() {
        TargetArea targetArea = TargetArea.parse("target area: x=20..30, y=-10..-5");
        assertFalse(targetArea.isInArea(0, 0));
        assertFalse(targetArea.isInArea(25, 0));
        assertFalse(targetArea.isInArea(0, -7));
        assertTrue(targetArea.isInArea(25, -7));
        assertTrue(targetArea.isInArea(20, -7));
        assertTrue(targetArea.isInArea(30, -7));
        assertTrue(targetArea.isInArea(25, -5));
        assertTrue(targetArea.isInArea(25, -10));
    }

}
