package nl.mwensveen.adventofcode.year_2019.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class VelocityApplierTest {

    @Test
    public void testApplyVelocity() throws Exception {
        List<Moon> moons = Arrays.asList(new Moon(-1, 0, 2), new Moon(2, -10, -7), new Moon(4, -8, 8), new Moon(3, 5, -1));
        GravityApplier applier = new GravityApplier();
        applier.apply(moons);
        VelocityApplier velocityApplier = new VelocityApplier();
        velocityApplier.applyVelocity(moons);

        assertEquals(2, moons.get(0).getPositionX());
        assertEquals(-1, moons.get(0).getPositionY());
        assertEquals(1, moons.get(0).getPositionZ());

        assertEquals(3, moons.get(1).getPositionX());
        assertEquals(-7, moons.get(1).getPositionY());
        assertEquals(-4, moons.get(1).getPositionZ());

        assertEquals(1, moons.get(2).getPositionX());
        assertEquals(-7, moons.get(2).getPositionY());
        assertEquals(5, moons.get(2).getPositionZ());

        assertEquals(2, moons.get(3).getPositionX());
        assertEquals(2, moons.get(3).getPositionY());
        assertEquals(0, moons.get(3).getPositionZ());
    }

}
