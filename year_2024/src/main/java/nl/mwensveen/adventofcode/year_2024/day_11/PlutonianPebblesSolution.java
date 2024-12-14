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
        int result = new Blinking().blink(stones);
        System.out.println("Number of stones that you have after blinking 25 times: " + result);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new PlutonianPebblesSolution().run();
    }

}
