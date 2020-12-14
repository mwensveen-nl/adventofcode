package nl.mwensveen.adventofcode.year_2020.day_14;

import java.math.BigInteger;
import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class DockingDataSolution extends AbstractTimedSolution {

    private List<String> input;

    public static void main(String[] args) {
        new DockingDataSolution().run();
    }

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_14.txt");
    }

    @Override
    protected void part1() {
        ProgramRunner programRunner = new ProgramRunner();
        BigInteger result = programRunner.runProgramVersionOne(input);
        System.out.println("The sum of all values left in memory after running version one = " + result);
    }

    @Override
    protected void part2() {
        ProgramRunner programRunner = new ProgramRunner();
        BigInteger result = programRunner.runProgramVersionTwo(input);
        System.out.println("The sum of all values left in memory after running version two = " + result);
    }

}
