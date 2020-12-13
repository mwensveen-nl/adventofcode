package nl.mwensveen.adventofcode.year_2020.day_13;

import com.codepoetics.protonpack.StreamUtils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class ShuttleSearchCalculator extends AbstractTimedSolution {

    private int now;
    private List<Integer> busses;
    private List<BusInterval> busIntervals;

    public static void main(String[] args) {
        new ShuttleSearchCalculator().run();
    }

    @Override
    protected void init() {
        List<String> strings = FileReadHelper.readLinesAsStrings("Day_13.txt");
        now = Integer.parseInt(strings.get(0));
        busses = Arrays.stream(strings.get(1).split(",")).filter(s -> !s.trim().equals("x")).map(Integer::parseInt).collect(Collectors.toList());
        busIntervals = StreamUtils.zipWithIndex(Arrays.stream(strings.get(1).split(",")))
                .map(i -> BusInterval.builder().withBusNr(i.getValue()).withInterval(i.getIndex()).build())
                .filter(bi -> Long.MIN_VALUE != bi.getBusNr())
                .collect(Collectors.toList());
    }

    @Override
    protected void part1() {
        BusLeaveCalculator busLeaveCalculator = new BusLeaveCalculator();
        Integer result = busLeaveCalculator.calculate(now, busses);
        System.out
                .println("ID of the earliest bus you can take to the airport multiplied by the number of minutes you'll need to wait for that bus = " + result);
    }

    @Override
    protected void part2() {

        BusLeaveCalculator busLeaveCalculator = new BusLeaveCalculator();
        long result = busLeaveCalculator.findSchedule(busIntervals);
        System.out.println("The earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list = " + result);
    }

}
