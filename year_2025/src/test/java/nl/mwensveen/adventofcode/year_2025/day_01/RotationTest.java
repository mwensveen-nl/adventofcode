package nl.mwensveen.adventofcode.year_2025.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RotationTest {

    @Test
    void testCreation() {
        var r = new Rotation("R10");
        assertEquals(Direction.RIGHT, r.direction());
        assertEquals(10, r.count().intValue());
    }
}
