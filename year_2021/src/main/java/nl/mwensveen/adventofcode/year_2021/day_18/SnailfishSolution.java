package nl.mwensveen.adventofcode.year_2021.day_18;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class SnailfishSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_18.txt");
    }

    @Override
    protected void part1() {
        SnailfishCalculator calculator = new SnailfishCalculator();
        String result = calculator.calculate(input);
        System.out.println("The magnitude of the final sum: " + result);
    }

    @Override
    protected void part2() {
        SnailfishNumberCombiner combiner = new SnailfishNumberCombiner();
        String result = combiner.combine(input);
        System.out.println("The largest magnitude of any sum of two different snailfish numbers from the homework assignment: " + result);
    }

    public static void main(String[] args) {
        new SnailfishSolution().run();
    }

}
