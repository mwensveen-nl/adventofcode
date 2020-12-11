package nl.mwensveen.adventofcode.year_2020.day_11;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class SeatingSystemSolution extends AbstractTimedSolution {
    private Table<Long, Long, PositionState> input;

    public static void main(String[] args) {
        new SeatingSystemSolution().run();
    }

    @Override
    protected void init() {
        List<String> inputStrings = FileReadHelper.readLinesAsStrings("Day_11.txt");
        FloorPlanParser floorPlanParser = new FloorPlanParser();
        input = floorPlanParser.parse(inputStrings);
    }

    @Override
    protected void part1() {
        StabilityFinder stabilityFinder = new StabilityFinder();
        int result = stabilityFinder.findOccupiedSeatsInStability(input, true);
        System.out.println("Number of seats that end up occupied when looking only at one adjacent seats = " + result);
    }

    @Override
    protected void part2() {
        StabilityFinder stabilityFinder = new StabilityFinder();
        int result = stabilityFinder.findOccupiedSeatsInStability(input, false);
        System.out.println("Number of seats that end up occupied when looking in all directections= " + result);
    }

}
