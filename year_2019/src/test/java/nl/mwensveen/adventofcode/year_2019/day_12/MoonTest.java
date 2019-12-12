package nl.mwensveen.adventofcode.year_2019.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MoonTest {

    @Test
    public void testMoon() throws Exception {
        Moon m = new Moon(1, 2, 3);
        assertEquals(1, m.getPositionX());
        assertEquals(2, m.getPositionY());
        assertEquals(3, m.getPositionZ());

    }

    @Test
    public void testUpdatePosition() throws Exception {
        Moon m = new Moon(1, 2, 3);
        m.UpdatePosition(4, 5, 6);
        assertEquals(4, m.getPositionX());
        assertEquals(5, m.getPositionY());
        assertEquals(6, m.getPositionZ());
    }

    @Test
    public void testUpdateVelocity() throws Exception {
        Moon m = new Moon(1, 2, 3);
        m.UpdateVelocity(4, 5, 6);
        assertEquals(4, m.getVelocityX());
        assertEquals(5, m.getVelocityY());
        assertEquals(6, m.getVelocityZ());
    }

    @Test
    public void testIncreaseVelocity() throws Exception {
        Moon m = new Moon(1, 2, 3);
        m.UpdateVelocity(4, 5, 6);
        m.increaseVelocityX(3);
        m.increaseVelocityY(4);
        m.increaseVelocityZ(5);
        assertEquals(7, m.getVelocityX());
        assertEquals(9, m.getVelocityY());
        assertEquals(11, m.getVelocityZ());
    }

}
