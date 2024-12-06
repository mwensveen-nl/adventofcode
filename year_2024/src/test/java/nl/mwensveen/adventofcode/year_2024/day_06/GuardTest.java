package nl.mwensveen.adventofcode.year_2024.day_06;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuardTest {

    @Test
    public void testInspect() {
        Guard g = new Guard(2, 3);
        List<Integer> pos = g.inspect();
        assertEquals(1, pos.getFirst());
        assertEquals(3, pos.getLast());

        g.turnRight();
        pos = g.inspect();
        assertEquals(2, pos.getFirst());
        assertEquals(4, pos.getLast());

        g.turnRight();
        pos = g.inspect();
        assertEquals(3, pos.getFirst());
        assertEquals(3, pos.getLast());

        g.turnRight();
        pos = g.inspect();
        assertEquals(2, pos.getFirst());
        assertEquals(2, pos.getLast());

        g.turnRight();
        pos = g.inspect();
        assertEquals(1, pos.getFirst());
        assertEquals(3, pos.getLast());
    }

    @Test
    public void testStep() {
        Guard g = new Guard(2, 3);
        List<Integer> pos = g.step();
        assertEquals(1, pos.getFirst());
        assertEquals(3, pos.getLast());

        g.turnRight();
        pos = g.step();
        assertEquals(1, pos.getFirst());
        assertEquals(4, pos.getLast());

        g.turnRight();
        pos = g.step();
        assertEquals(2, pos.getFirst());
        assertEquals(4, pos.getLast());

        g.turnRight();
        pos = g.step();
        assertEquals(2, pos.getFirst());
        assertEquals(3, pos.getLast());

        g.turnRight();
        pos = g.step();
        assertEquals(1, pos.getFirst());
        assertEquals(3, pos.getLast());
    }
}
