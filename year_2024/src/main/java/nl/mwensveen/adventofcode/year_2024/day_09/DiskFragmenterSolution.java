package nl.mwensveen.adventofcode.year_2024.day_09;

import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class DiskFragmenterSolution extends AbstractTimedSolution {

    private String input;

    @Override
    protected void init() {
        input = FileReadHelper.readLineAsString("Day_09.txt");
    }

    @Override
    protected void part1() {
        long result = new DiskMapBlockProcessor().parse(input);
        System.out.println("The resulting filesystem checksum: " + result);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new DiskFragmenterSolution().run();
    }

}
