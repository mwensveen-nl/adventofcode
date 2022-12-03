package nl.mwensveen.adventofcode.year_2022.day_03;

import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class RucksackReorganizationSolution extends AbstractTimedSolution {

    private RucksackInspector rucksackInspector = new RucksackInspector();
    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day03.txt");
    }

    @Override
    protected void part1() {
        int priorities = rucksackInspector.inspectRucksacks(input);
        System.out.println("The sum of the priorities of item types that appears in both compartments of each rucksack: " + priorities);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new RucksackReorganizationSolution().run();
    }

}
