package nl.mwensveen.adventofcode.year_2022.day_15;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import org.javatuples.Pair;

public record Sensor(int x, int y, int beaconX, int beaconY) {

    public int ManhattanDistance() {
        return Math.max(x, beaconX) - Math.min(x, beaconX) + Math.max(y, beaconY) - Math.min(y, beaconY);
    }

    public int ManhattanDistance(int otherX, int otherY) {
        return Math.max(x, otherX) - Math.min(x, otherX) + Math.max(y, otherY) - Math.min(y, otherY);
    }

    public Set<Pair<Integer, Integer>> getOuterPairs() {
        Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        int manDist = ManhattanDistance() + 1;
        IntStream.rangeClosed(0, manDist).forEach(i -> {
            int x1 = x - manDist + i;
            int x2 = x + manDist - i;
            int y1 = y - i;
            int y2 = y + i;
            pairs.add(new Pair(x1, y1));
            pairs.add(new Pair(x1, y2));
            pairs.add(new Pair(x2, y1));
            pairs.add(new Pair(x2, y2));
        });
        return pairs;
    }
}