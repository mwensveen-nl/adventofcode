package nl.mwensveen.adventofcode.year_2021.day_08;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class SevenSegmentSearchSolution2 extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_08.txt");
    }

    @Override
    protected void part1() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void part2() {
        SignalToDigitConverter signalToDigitConverter = new SignalToDigitConverter();
        long result = signalToDigitConverter.convert(input);
        System.out.println("Result of all added output values: " + result);
    }

    public static void main(String[] args) {
        new SevenSegmentSearchSolution2().run();
    }

}
