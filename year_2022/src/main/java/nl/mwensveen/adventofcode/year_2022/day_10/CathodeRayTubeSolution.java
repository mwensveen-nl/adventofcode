package nl.mwensveen.adventofcode.year_2022.day_10;

import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class CathodeRayTubeSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day10.txt");
    }

    @Override
    protected void part1() {
        ProgramExecution programExecution = new ProgramExecution();
        int sum = programExecution.executeProgram(input);
        System.out.println("The sum of the six signal strengths: " + sum);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new CathodeRayTubeSolution().run();
    }

}
