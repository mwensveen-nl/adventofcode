package nl.mwensveen.adventofcode.year_2020.day_12;

public class ManhattanDistanceCalculator {
    public long calculate(int startNorthSouth, int startWestEast, int endNorthSouth, int endWestEast) {
        return Math.abs(endNorthSouth - startNorthSouth) + Math.abs(endWestEast - startWestEast);
    }
}
