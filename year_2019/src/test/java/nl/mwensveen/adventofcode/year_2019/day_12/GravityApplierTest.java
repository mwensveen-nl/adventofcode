package nl.mwensveen.adventofcode.year_2019.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GravityApplierTest {

    @Test
    public void testApply() throws Exception {
        List<Moon> moons = Arrays.asList(new Moon(-1, 0, 2), new Moon(2, -10, -7), new Moon(4, -8, 8), new Moon(3, 5, -1));
        GravityApplier applier = new GravityApplier();
        applier.apply(moons);

        assertEquals(3, moons.get(0).getVelocityX());
        assertEquals(-1, moons.get(0).getVelocityY());
        assertEquals(-1, moons.get(0).getVelocityZ());

        assertEquals(1, moons.get(1).getVelocityX());
        assertEquals(3, moons.get(1).getVelocityY());
        assertEquals(3, moons.get(1).getVelocityZ());

        assertEquals(-3, moons.get(2).getVelocityX());
        assertEquals(1, moons.get(2).getVelocityY());
        assertEquals(-3, moons.get(2).getVelocityZ());

        assertEquals(-1, moons.get(3).getVelocityX());
        assertEquals(-3, moons.get(3).getVelocityY());
        assertEquals(1, moons.get(3).getVelocityZ());
    }

}
