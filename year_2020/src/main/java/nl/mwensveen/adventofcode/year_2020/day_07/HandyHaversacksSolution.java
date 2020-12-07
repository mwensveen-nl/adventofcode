package nl.mwensveen.adventofcode.year_2020.day_07;

import java.util.List;
import java.util.Map;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class HandyHaversacksSolution extends AbstractTimedSolution {
    private List<String> input;
    private Map<String, BagRule> bagRules;
    private BagEncloserFinder bagEncloserFinder;

    public static void main(String[] args) {
        new HandyHaversacksSolution().run();
    }

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_07.txt");
        BagRuleParser bagRuleParser = new BagRuleParser();
        bagRules = bagRuleParser.parseBagRules(input);
        bagEncloserFinder = new BagEncloserFinder();
    }

    @Override
    protected void part1() {
        long result = bagEncloserFinder.findNumberOfEncloserBags(bagRules.values());
        System.out.println("Number of bag colors that can eventually contain at least one shiny gold bag: " + result);
    }

    @Override
    protected void part2() {
        long result = bagEncloserFinder.findNumberOfBagsInside(bagRules);
        System.out.println("Individual number of bags that are required inside a single shiny gold bag: " + result);
    }

}
