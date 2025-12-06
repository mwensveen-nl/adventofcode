package nl.mwensveen.adventofcode.year_2025.day_02;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2025.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2025.FileReadHelper;

public class GiftShopSolution extends AbstractTimedSolution {

    private List<Range> ranges;

    @Override
    protected void init() {
        String input = FileReadHelper.readLineAsString("day_02.txt");
        ranges = Arrays.asList(input.split(",")).stream().map(Range::new).toList();
    }

    @Override
    protected void part1() {
        BigInteger sum = new InvalidNumberFinder().findDoubles(ranges);
        System.out.println("If you add up all of the invalid IDs, you get: " + sum);
    }

    @Override
    protected void part2() {
        BigInteger sum = new InvalidNumberFinder().findRepeats(ranges);
        System.out.println("If you add up all of the invalid IDs using the new ruless, you get: " + sum);
    }

    public static void main(String[] args) {
        new GiftShopSolution().run();
    }

}
