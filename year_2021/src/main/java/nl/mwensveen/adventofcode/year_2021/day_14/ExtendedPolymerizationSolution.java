package nl.mwensveen.adventofcode.year_2021.day_14;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;
import org.javatuples.Pair;

public class ExtendedPolymerizationSolution extends AbstractTimedSolution {

    private Pair<String, List<InsertionRule>> parseInput;

    @Override
    protected void init() {
        List<String> input = FileReadHelper.readLinesAsStrings("day_14.txt");
        InputParser inputParser = new InputParser();
        parseInput = inputParser.parseInput(input);
    }

    @Override
    protected void part1() {
        PolymerRulesProcessor polymerRulesProcessor = new PolymerRulesProcessor();
        long result = polymerRulesProcessor.process(parseInput, 10);

        System.out.println(
                "Result if you take the quantity of the most common element and subtract the quantity of the least common element after 10 steps: " + result);
    }

    @Override
    protected void part2() {
        PolymerRulesProcessor polymerRulesProcessor = new PolymerRulesProcessor();
        long result = polymerRulesProcessor.process(parseInput, 40);

        System.out.println(
                "Result if you take the quantity of the most common element and subtract the quantity of the least common element after 40 steps: " + result);

    }

    public static void main(String[] args) {
        new ExtendedPolymerizationSolution().run();
    }

}
