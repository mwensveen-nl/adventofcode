package nl.mwensveen.adventofcode.year_2021.day_02;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class DiveSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_02.txt");
    }

    @Override
    protected void part1() {
        PositionCalculator calculator = new PositionCalculator();
        int result = calculator.calculateSimplePostion(input);
        System.out.println("Calculated Simple result: " + result);
    }

    @Override
    protected void part2() {
        PositionCalculator calculator = new PositionCalculator();
        int result = calculator.calculatePostionWithAim(input);
        System.out.println("Calculated with Aim result: " + result);

    }

    public static void main(String[] args) {
        new DiveSolution().run();
    }

}
