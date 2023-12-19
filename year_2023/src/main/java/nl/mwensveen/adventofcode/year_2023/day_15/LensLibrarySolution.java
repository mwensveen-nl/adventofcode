package nl.mwensveen.adventofcode.year_2023.day_15;

import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class LensLibrarySolution extends AbstractTimedSolution {

    private String input;

    @Override
    protected void init() {
        input = FileReadHelper.readLineAsString("Day_15.txt");
    }

    @Override
    protected void part1() {
        long result = new InitializationSequenceProcessor().process(input);
        System.out.println("The sum of the hashes in the initialization sequence: " + result);

    }

    @Override
    protected void part2() {
        long result = new BoxProcessor().process(input);
        System.out.println("The focusing power of the resulting lens configuration: " + result);
    }

    public static void main(String[] args) {
        new LensLibrarySolution().run();
    }

}
