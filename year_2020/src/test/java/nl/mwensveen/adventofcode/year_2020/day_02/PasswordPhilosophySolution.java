package nl.mwensveen.adventofcode.year_2020.day_02;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class PasswordPhilosophySolution extends AbstractTimedSolution {
    private List<String> input;
    private PasswordListChecker passwordListChecker;

    public static void main(String[] args) {
        PasswordPhilosophySolution solution = new PasswordPhilosophySolution();
        solution.run();
    }

    public PasswordPhilosophySolution() {
        input = FileReadHelper.readLinesAsStrings("Day_02.txt");
        passwordListChecker = new PasswordListChecker(input);
    }

    @Override
    protected void part1() {
        long count = passwordListChecker.checkListSledRentalPlaceStyle();
        System.out.println("Number of valid passwords (Sled Rental Play style): " + count);
    }

    @Override
    protected void part2() {
        long count = passwordListChecker.checkListTobogganRentalShopStyle();
        System.out.println("Number of valid passwords (Toboggan Rental Shop style): " + count);
    }

}
