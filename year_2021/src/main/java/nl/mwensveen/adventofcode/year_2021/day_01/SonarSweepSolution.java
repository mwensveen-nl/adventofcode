package nl.mwensveen.adventofcode.year_2021.day_01;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class SonarSweepSolution extends AbstractTimedSolution {

    private List<Integer> input;
    private DepthMeasurementCalculator calculator;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsIntegers("day_01.txt");
        calculator = new DepthMeasurementCalculator();
    }

    @Override
    protected void part1() {
        long result = calculator.calculateNumberOfIncreases(input);
        System.out.println("number of increases " + result);
    }

    @Override
    protected void part2() {
        long result = calculator.calculateNumberOfIncreasesSumMeasurements(input);
        System.out.println("number of increases with summed measurements: " + result);
    }

    public static void main(String[] args) {
        SonarSweepSolution solution = new SonarSweepSolution();
        solution.run();
    }

}
