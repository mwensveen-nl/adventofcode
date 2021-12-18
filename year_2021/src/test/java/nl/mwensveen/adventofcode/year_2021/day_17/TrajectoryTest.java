package nl.mwensveen.adventofcode.year_2021.day_17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TrajectoryTest {

    @Test
    public void testFindHightsTrajectory() {
        Trajectory trajectory = new Trajectory();
        int result = trajectory.findHightsTrajectory("target area: x=20..30, y=-10..-5");
        assertEquals(45, result);
    }

    @Test
    public void testFindNumberOfVelocities() {
        Trajectory trajectory = new Trajectory();
        int result = trajectory.findNumberOfVelocities("target area: x=20..30, y=-10..-5");
        assertEquals(112, result);
    }

}
