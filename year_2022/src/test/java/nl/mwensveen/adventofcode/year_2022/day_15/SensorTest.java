package nl.mwensveen.adventofcode.year_2022.day_15;

import java.util.Set;
import org.javatuples.Pair;
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

    @Test
    public void testGetOuterPairs() {
        Sensor sensor = new Sensor(8, 7, 2, 10);
        Set<Pair<Integer, Integer>> outerPairs = sensor.getOuterPairs();
        System.out.println(outerPairs.stream().sorted((p, q) -> {
            int compareTo = p.getValue0().compareTo(q.getValue0());
            if (compareTo == 0) {
                compareTo = p.getValue1().compareTo(q.getValue1());

            }
            return compareTo;
        }).toList());
    }

}
