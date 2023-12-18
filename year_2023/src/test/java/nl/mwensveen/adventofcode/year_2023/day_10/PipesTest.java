package nl.mwensveen.adventofcode.year_2023.day_10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PipesTest {

    @Test
    public void testCanStepToThis() {
        Direction to = Direction.NORD;
        assertTrue(Pipes.NS.canStepToThis(Pipes.NW, to));
        assertFalse(Pipes.EW.canStepToThis(Pipes.SW, to));
        assertFalse(Pipes.NE.canStepToThis(Pipes.SW, to));
        assertFalse(Pipes.NW.canStepToThis(Pipes.SW, to));
        assertTrue(Pipes.SW.canStepToThis(Pipes.NE, to));
        assertTrue(Pipes.SE.canStepToThis(Pipes.NW, to));
    }

    @Test
    public void testCanStepToThisEast() {
        Direction to = Direction.EAST;
        assertFalse(Pipes.NS.canStepToThis(Pipes.SW, to));
        assertTrue(Pipes.EW.canStepToThis(Pipes.SE, to));
        assertFalse(Pipes.NE.canStepToThis(Pipes.SW, to));
        assertTrue(Pipes.NW.canStepToThis(Pipes.SE, to));
        assertTrue(Pipes.SW.canStepToThis(Pipes.SE, to));
        assertFalse(Pipes.SE.canStepToThis(Pipes.SW, to));
    }

    @Test
    public void testStep() {
        Direction to = Direction.NORD;
        assertEquals(Direction.NORD, Pipes.NS.step(to));
        assertEquals(Direction.WEST, Pipes.SW.step(to));
        assertEquals(Direction.EAST, Pipes.SE.step(to));
    }

}
