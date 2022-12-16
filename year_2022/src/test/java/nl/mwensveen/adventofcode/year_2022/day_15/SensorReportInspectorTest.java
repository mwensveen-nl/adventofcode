package nl.mwensveen.adventofcode.year_2022.day_15;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SensorReportInspectorTest {
    private final String INPUT = """
            Sensor at x=2, y=18: closest beacon is at x=-2, y=15
            Sensor at x=9, y=16: closest beacon is at x=10, y=16
            Sensor at x=13, y=2: closest beacon is at x=15, y=3
            Sensor at x=12, y=14: closest beacon is at x=10, y=16
            Sensor at x=10, y=20: closest beacon is at x=10, y=16
            Sensor at x=14, y=17: closest beacon is at x=10, y=16
            Sensor at x=8, y=7: closest beacon is at x=2, y=10
            Sensor at x=2, y=0: closest beacon is at x=2, y=10
            Sensor at x=0, y=11: closest beacon is at x=2, y=10
            Sensor at x=20, y=14: closest beacon is at x=25, y=17
            Sensor at x=17, y=20: closest beacon is at x=21, y=22
            Sensor at x=16, y=7: closest beacon is at x=15, y=3
            Sensor at x=14, y=3: closest beacon is at x=15, y=3
            Sensor at x=20, y=1: closest beacon is at x=15, y=3
                    """;

    @Test
    public void testFindMinX() {
        SensorParser parser = new SensorParser();
        List<Sensor> list = parser.parse(INPUT.lines().toList());

        SensorReportInspector inspector = new SensorReportInspector();
        int x = inspector.findMinX(list);
        assertEquals(-2, x);
    }

    @Test
    public void testFindMaxX() {
        SensorParser parser = new SensorParser();
        List<Sensor> list = parser.parse(INPUT.lines().toList());

        SensorReportInspector inspector = new SensorReportInspector();
        int x = inspector.findMaxX(list);
        assertEquals(25, x);
    }

    @Test
    public void testFindEmptyPositions() {
        SensorParser parser = new SensorParser();
        List<Sensor> list = parser.parse(INPUT.lines().toList());

        SensorReportInspector inspector = new SensorReportInspector();
        long emptyPositions = inspector.findEmptyPositions(list, 10);
        assertEquals(26, emptyPositions);
    }

}
