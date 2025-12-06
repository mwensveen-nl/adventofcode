package nl.mwensveen.adventofcode.year_2025.day_03;

import java.math.BigInteger;
import java.util.List;
import nl.mwensveen.adventofcode.year_2025.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2025.FileReadHelper;

public class LobbySolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_03.txt");
    }

    @Override
    protected void part1() {
        BigInteger detected = new MaxJoltageDetector().detect(input);
        System.out.println("The total output joltage is: " + detected);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new LobbySolution().run();
    }

}
