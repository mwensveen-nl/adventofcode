package nl.mwensveen.adventofcode.year_2019.day_06;

import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class OrbitCountChecksumSolution extends AbstractTimedSolution {
    public static void main(String[] args) {
        OrbitCountChecksumSolution solution = new OrbitCountChecksumSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        OrbitCountChecksumCalculator calculator = new OrbitCountChecksumCalculator();
        int count = calculator.calculateCheckSum(FileReadHelper.readLines("Day06.txt"));
        System.out.println("Checksum for part one: " + count);
    }

    @Override
    protected void part2() {
        OrbitCountChecksumCalculator calculator = new OrbitCountChecksumCalculator();
        int count = calculator.calculateMinimalTransfers(FileReadHelper.readLines("Day06.txt"));
        System.out.println("Transfers for part two: " + count);
    }

}
