package nl.mwensveen.adventofcode.year_2021.day_09;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class SmokeBasinSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_09.txt");
    }

    @Override
    protected void part1() {
        LowestPointsLocator lowestPointsLocator = new LowestPointsLocator();
        Integer result = lowestPointsLocator.locateLowestPoints(input);
        System.out.println("Sum of the risk levels of all low points on the heightmap: " + result);

    }

    @Override
    protected void part2() {
        LowestPointsLocator lowestPointsLocator = new LowestPointsLocator();
        Integer result = lowestPointsLocator.calculateBasins(input);
        System.out.println("The sizes of the three largest basins multiplied together : " + result);
    }

    public static void main(String[] args) {
        new SmokeBasinSolution().run();
    }

}
