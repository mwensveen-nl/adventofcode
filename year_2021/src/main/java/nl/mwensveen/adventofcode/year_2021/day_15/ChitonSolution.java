package nl.mwensveen.adventofcode.year_2021.day_15;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class ChitonSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_15.txt");
    }

    @Override
    protected void part1() {
        RiskPathFinder riskPathFinder = new RiskPathFinder();
        long result = riskPathFinder.findShortestPath(input);
        System.out.println("Lowest total risk of any path from the top left to the bottom right: " + result);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new ChitonSolution().run();
    }

}
