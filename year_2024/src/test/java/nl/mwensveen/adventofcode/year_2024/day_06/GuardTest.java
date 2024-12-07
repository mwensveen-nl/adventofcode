package nl.mwensveen.adventofcode.year_2024.day_06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuardTest {

    @Test
    public void testInspect() {
        Guard g = new Guard(2, 3);
        Position pos = g.inspect();
        assertEquals(1, pos.row());
        assertEquals(3, pos.col());

        g.turnRight();
        pos = g.inspect();
        assertEquals(2, pos.row());
        assertEquals(4, pos.col());

        g.turnRight();
        pos = g.inspect();
        assertEquals(3, pos.row());
        assertEquals(3, pos.col());

        g.turnRight();
        pos = g.inspect();
        assertEquals(2, pos.row());
        assertEquals(2, pos.col());

        g.turnRight();
        pos = g.inspect();
        assertEquals(1, pos.row());
        assertEquals(3, pos.col());
    }

    @Test
    public void testStep() {
        Guard g = new Guard(2, 3);
        Position pos = g.step();
        assertEquals(1, pos.row());
        assertEquals(3, pos.col());

        g.turnRight();
        pos = g.step();
        assertEquals(1, pos.row());
        assertEquals(4, pos.col());

        g.turnRight();
        pos = g.step();
        assertEquals(2, pos.row());
        assertEquals(4, pos.col());

        g.turnRight();
        pos = g.step();
        assertEquals(2, pos.row());
        assertEquals(3, pos.col());

        g.turnRight();
        pos = g.step();
        assertEquals(1, pos.row());
        assertEquals(3, pos.col());
    }
}
