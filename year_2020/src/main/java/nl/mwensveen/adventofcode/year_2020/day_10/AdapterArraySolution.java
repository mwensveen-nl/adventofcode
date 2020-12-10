package nl.mwensveen.adventofcode.year_2020.day_10;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class AdapterArraySolution extends AbstractTimedSolution {
    private List<Long> input;

    public static void main(String[] args) {
        new AdapterArraySolution().run();
    }

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsLongs("Day_10.txt");
    }

    @Override
    protected void part1() {
        AdaptorSequencer adaptorSequencer = new AdaptorSequencer();
        long result = adaptorSequencer.determineSequenceJoltageRatings(input);
        System.out.println("The number of 1-jolt differences multiplied by the number of 3-jolt differences = " + result);
    }

    @Override
    protected void part2() {
        AdaptorSequencer adaptorSequencer = new AdaptorSequencer();
        long result = adaptorSequencer.determineDistinctWays(input);
        System.out.println("The number of 1-jolt differences multiplied by the number of 3-jolt differences = " + result);
    }

}
