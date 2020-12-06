package nl.mwensveen.adventofcode.year_2020.day_04;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class PassportProcessingSolution extends AbstractTimedSolution {

    private List<String> input;
    private PassportProcessing passportProcessing;

    public static void main(String[] args) {
        new PassportProcessingSolution().run();
    }

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_04.txt");
        passportProcessing = new PassportProcessing(input);
    }

    public PassportProcessingSolution() {
    }

    @Override
    protected void part1() {
        long result = passportProcessing.countValidPassports();
        System.out.println("Number of valid passports: " + result);

    }

    @Override
    protected void part2() {
        long result = passportProcessing.countValidPassportsWithValues();
        System.out.println("Number of valid passports with valid values: " + result);
    }

}
