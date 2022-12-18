package nl.mwensveen.adventofcode.year_2022.day_15;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.javatuples.Pair;

public class SensorReportInspector {
    AtomicInteger atomicY = new AtomicInteger();

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

    public BigInteger findBeacon(List<Sensor> sensors, int max) {
        Optional<Pair<Integer, Integer>> optional = sensors.stream().flatMap(s -> s.getOuterPairs().stream())
                .filter(p -> p.getValue0() >= 0 && p.getValue0() <= max && p.getValue1() >= 0 && p.getValue1() <= max)
                .filter(p -> isBeacon(p, sensors)).findFirst();
        if (optional.isPresent()) {
            Pair<Integer, Integer> pair = optional.get();
            return BigInteger.valueOf(4000000).multiply(BigInteger.valueOf(pair.getValue0())).add(BigInteger.valueOf(pair.getValue1()));
        }
        return null;
    }

    private boolean isBeacon(Pair<Integer, Integer> p, List<Sensor> sensors) {
        return !inspectCannotHaveBeacon(sensors, p.getValue0(), p.getValue1());
    }

}
