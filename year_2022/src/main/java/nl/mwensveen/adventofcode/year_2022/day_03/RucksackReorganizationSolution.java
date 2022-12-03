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
        int priorities = rucksackInspector.inspectSingleRucksacks(input);
        System.out.println("The sum of the priorities of item types that appears in both compartments of each rucksack: " + priorities);
    }

    @Override
    protected void part2() {
        int priorities = rucksackInspector.inspectTripleRucksacks(input);
        System.out.println("The sum of the priorities of the item type that corresponds to the badges of each three-Elf group: " + priorities);
    }

    public static void main(String[] args) {
        new RucksackReorganizationSolution().run();
    }

}
