package nl.mwensveen.adventofcode.year_2022.day_15;

public record Sensor(int x, int y, int beaconX, int beaconY) {

    public int ManhattanDistance() {
        return Math.max(x, beaconX) - Math.min(x, beaconX) + Math.max(y, beaconY) - Math.min(y, beaconY);
    }

    public int ManhattanDistance(int otherX, int otherY) {
        return Math.max(x, otherX) - Math.min(x, otherX) + Math.max(y, otherY) - Math.min(y, otherY);
    }
}