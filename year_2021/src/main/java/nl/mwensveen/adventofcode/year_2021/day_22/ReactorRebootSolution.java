package nl.mwensveen.adventofcode.year_2021.day_22;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class ReactorRebootSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_22.txt");
    }

    @Override
    protected void part1() {
        RebootStepParser parser = new RebootStepParser();
        List<Step> list = parser.parse(input);

        InitProcessor processor = new InitProcessor();
        Long result = processor.processInitialization(list);

        System.out.println("Number of cubes that are on: " + result);
    }

    @Override
    protected void part2() {
        RebootStepParser parser = new RebootStepParser();
        List<Step> list = parser.parse(input);

        RebootProcessor processor = new RebootProcessor();
        Long result = processor.processReboot(list);

        System.out.println("Number of cubes that are on: " + result);

    }

    public static void main(String[] args) {
        new ReactorRebootSolution().run();
    }

}
