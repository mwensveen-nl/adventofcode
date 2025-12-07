package nl.mwensveen.adventofcode.year_2025.day_06;

import com.google.common.collect.Table;
import java.math.BigInteger;
import java.util.List;
import nl.mwensveen.adventofcode.year_2025.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2025.FileReadHelper;

public class TrashCompactorSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_06.txt");
    }

    @Override
    protected void part1() {
        Table<Integer, Integer, String> worksheet = new HomeWorksheetParser().parse(input);
        BigInteger result = new HomeWorkCalculator().calculate(worksheet);
        System.out.println("The grand total found by adding together all of the answers to the individual problems: " + result.longValue());
    }

    @Override
    protected void part2() {
        List<List<String>> worksheet = new HomeWorksheetParser().parseCephalopod(input);
        BigInteger result = new HomeWorkCalculatorCephalopod().calculate(worksheet);
        System.out.println(
                "The grand total found by adding together all of the answers to the individual problems, using the Cephalopod notation: " + result.longValue());
    }

    public static void main(String[] args) {
        new TrashCompactorSolution().run();
    }

}
