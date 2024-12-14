package nl.mwensveen.adventofcode.year_2024.day_11;

import java.util.Arrays;
import java.util.List;
import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class PlutonianPebblesSolution extends AbstractTimedSolution {

    private String input;
    private List<Long> stones;

    @Override
    protected void init() {
        input = FileReadHelper.readLineAsString("Day_11.txt");
        stones = Arrays.asList(input.split(" ")).stream().map(Long::valueOf).toList();
    }

    @Override
    protected void part1() {
        long result = new Blinking().blink(stones, 25);
        System.out.println("Number of stones that you have after blinking 25 times: " + result);
    }

    @Override
    protected void part2() {
        long result = new Blinking().blink(stones, 75);
        System.out.println("Number of stones that you have after blinking 75 times: " + result);

    }

    public static void main(String[] args) {
        new PlutonianPebblesSolution().run();
    }

}
