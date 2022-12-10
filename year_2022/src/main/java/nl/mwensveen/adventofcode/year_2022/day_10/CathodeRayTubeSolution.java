package nl.mwensveen.adventofcode.year_2022.day_10;

import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class CathodeRayTubeSolution extends AbstractTimedSolution {

    private ProgramExecution programExecution = new ProgramExecution();
    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day10.txt");
    }

    @Override
    protected void part1() {
        int sum = programExecution.executeSummingProgram(input);
        System.out.println("The sum of the six signal strengths: " + sum);
    }

    @Override
    protected void part2() {
        CRTscreen screen = programExecution.executeDrawingProgram(input);
        System.out.println("Eight capital letters appear on the CRT");
        screen.toScreen();
    }

    public static void main(String[] args) {
        new CathodeRayTubeSolution().run();
    }

}
