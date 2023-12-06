package nl.mwensveen.adventofcode.year_2023.day_05;

import java.util.List;
import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class FertilizerSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_05.txt");
    }

    @Override
    protected void part1() {
        AlmanacSeeds almanac = new AlmanacParser().parseInputToSeeds(input);
        long lowestLocation = new LocationLocator().findLowestLocation(almanac);
        System.out.println("The lowest location number that corresponds to any of the initial seed numbers: " + lowestLocation);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new FertilizerSolution().run();

    }

}
