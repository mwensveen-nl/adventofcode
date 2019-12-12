package nl.mwensveen.adventofcode.year_2019.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MotionSimulatorTest {

    @Test
    public void testSimulate() throws Exception {
        List<Moon> moons = Arrays.asList(new Moon(-8, -10, 0), new Moon(5, 5, 10), new Moon(2, -7, 3), new Moon(9, -8, -3));
        MotionSimulator motionSimulator = new MotionSimulator(moons);
        int result = motionSimulator.simulate(100);
        assertEquals(1940, result);
    }

}
