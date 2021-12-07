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
        long average = (long) (summaryStatistics.getAverage() + 0.25);
        long fuel = input.stream().map(i -> calcFuel(average, i)).mapToLong(Long::longValue).sum();
        return fuel;
    }

    private long calcFuel(long average, Integer i) {
        double steps = Math.abs(average - i);
        double rfuel = (steps * (steps + 1.0) / 2.0);
        return (long) rfuel;
    }
}
