package nl.mwensveen.adventofcode.year_2019.day_09;

import java.math.BigInteger;
import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class SensorBoostSolution extends AbstractTimedSolution {
    public static void main(String[] args) {
        SensorBoostSolution solution = new SensorBoostSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        IntcodeProgram intcodeProgram = new IntcodeProgram(1);
        BigInteger result = intcodeProgram.process(FileReadHelper.readCSVBigIntegers("Day09.txt"));
        System.out.println("Sensor Boost Key part 1: " + result);
    }

    @Override
    protected void part2() {
        IntcodeProgram intcodeProgram = new IntcodeProgram(2);
        BigInteger result = intcodeProgram.process(FileReadHelper.readCSVBigIntegers("Day09.txt"));
        System.out.println("Sensor Boost Key part 2: " + result);

    }

}
