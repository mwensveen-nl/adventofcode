package nl.mwensveen.adventofcode.year_2020.day_09;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class EncodingErrorSolution extends AbstractTimedSolution {

    private List<Long> input;
    private Long resultPart1;

    public static void main(String[] args) {
        new EncodingErrorSolution().run();
    }

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsLongss("Day_09.txt");
    }

    @Override
    protected void part1() {
        NumberChecker numberChecker = new NumberChecker();
        resultPart1 = numberChecker.checkValidNumbers(input, 25);
        System.out.println("First number that is not the sum of two of the 25 numbers before it: " + resultPart1);
    }

    @Override
    protected void part2() {
        NumberChecker numberChecker = new NumberChecker();
        Long result = numberChecker.findContiguousSet(input, resultPart1);
        System.out.println("The encryption weakness: " + result);
    }

}
