package nl.mwensveen.adventofcode.year_2022.day_15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SensorTest {

    @Test
    public void testManhattanDistanceIntInt() {
        Sensor sensor = new Sensor(2, 18, -2, 15);
        assertEquals(10, sensor.ManhattanDistance(5, 25));
    }

    @Test
    public void testManhattanDistance() {
        Sensor sensor = new Sensor(2, 18, -2, 15);
        assertEquals(7, sensor.ManhattanDistance());
    }

}
