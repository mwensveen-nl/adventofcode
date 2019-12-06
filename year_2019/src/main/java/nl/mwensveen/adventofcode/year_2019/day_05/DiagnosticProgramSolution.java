package nl.mwensveen.adventofcode.year_2019.day_05;

import java.util.List;
import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class DiagnosticProgramSolution extends AbstractTimedSolution {

    public static void main(String[] args) {
        DiagnosticProgramSolution solution = new DiagnosticProgramSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        List<Integer> integers = FileReadHelper.readCSVIntegers("Day05.txt");
        IntcodeProgram intcodeProgram = new IntcodeProgram(1);
        Integer result = intcodeProgram.process(integers);

        System.out.println("Result of Intcode program part 1: " + result);
    }

    @Override
    protected void part2() {
        List<Integer> integers = FileReadHelper.readCSVIntegers("Day05.txt");
        IntcodeProgram intcodeProgram = new IntcodeProgram(5);
        Integer result = intcodeProgram.process(integers);

        System.out.println("Result of Intcode program part 2: " + result);
    }
}
