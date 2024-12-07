package nl.mwensveen.adventofcode.year_2024.day_07;

import java.util.List;
import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class BridgeRepairsolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_07.txt");
    }

    @Override
    protected void part1() {
        CalibrationCalculator calculator = new CalibrationCalculator();
        long result = calculator.findCalibrations(input);
        System.out.println("The total calibration result: " + result);
    }

    @Override
    protected void part2() {
        CalibrationCalculator calculator = new CalibrationCalculator();
        long result = calculator.findCalibrationsWithConcat(input);
        System.out.println("The total calibration using concat result: " + result);
    }

    public static void main(String[] args) {
        new BridgeRepairsolution().run();
    }

}
