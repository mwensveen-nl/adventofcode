package nl.mwensveen.adventofcode.year_2022.day_15;

import java.util.List;
import java.util.stream.IntStream;

public class SensorReportInspector {

    public int findMinX(List<Sensor> sensors) {
        return sensors.stream().mapToInt(s -> Math.min(s.x(), s.beaconX())).min().getAsInt();
    }

    public int findMaxX(List<Sensor> sensors) {
        return sensors.stream().mapToInt(s -> Math.max(s.x(), s.beaconX())).max().getAsInt();
    }

    public long findEmptyPositions(List<Sensor> sensors, int y) {
        int minX = findMinX(sensors);
        int maxX = findMaxX(sensors);

        return IntStream.rangeClosed(minX * 2, maxX * 2).filter(x -> inspectHasBeacon(x, y, sensors))
                .filter(x -> inspectCannotHaveBeacon(sensors, x, y)).count();
    }

    private boolean inspectHasBeacon(int x, int y, List<Sensor> sensors) {
        boolean b = sensors.stream().noneMatch(sensor -> (x == sensor.beaconX()) && (y == sensor.beaconY()));
        return b;
    }

    private boolean inspectCannotHaveBeacon(List<Sensor> sensors, int x, int y) {
        return sensors.stream().filter(sensor -> sensor.ManhattanDistance(x, y) <= sensor.ManhattanDistance()).findFirst().isPresent();
    }
}
