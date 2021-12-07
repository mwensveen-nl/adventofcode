package nl.mwensveen.adventofcode.year_2021.day_07;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class FuelCalculator {

    public Integer calculateMinimumFuel(List<Integer> input) {
        List<Integer> sortedHorizontalPos = input.stream().sorted().toList();
        int count = sortedHorizontalPos.size();
        Integer pos = sortedHorizontalPos.get(count / 2);
        Integer fuel = input.stream().map(i -> Math.abs(i - pos)).collect(Collectors.summingInt(Integer::intValue));
        return fuel;
    }

    public long calculateMinimumFuelWithIncreasingExpense(List<Integer> input) {
        IntSummaryStatistics summaryStatistics = input.stream().mapToInt(Integer::intValue).summaryStatistics();
        // round down
        long average1 = (long) (summaryStatistics.getAverage());
        long fuel1 = input.stream().map(i -> calcFuel(average1, i)).mapToLong(Long::longValue).sum();
        // round up
        long average2 = (long) (summaryStatistics.getAverage() + 1);
        long fuel2 = input.stream().map(i -> calcFuel(average2, i)).mapToLong(Long::longValue).sum();
        return fuel1 < fuel2 ? fuel1 : fuel2;
    }

    private long calcFuel(long average, Integer i) {
        double steps = Math.abs(average - i);
        double rfuel = (steps * (steps + 1.0) / 2.0);
        return (long) rfuel;
    }
}
