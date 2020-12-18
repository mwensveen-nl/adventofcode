package nl.mwensveen.adventofcode.year_2020.day_18;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class OperationOrderSolution extends AbstractTimedSolution {
    private List<String> input;

    public static void main(String[] args) {
        new OperationOrderSolution().run();
    }

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_18.txt");
    }

    @Override
    protected void part1() {
        HomeWorkProcessor homeWorkProcessor = new HomeWorkProcessor();
        long result = homeWorkProcessor.processHomework(input);
        System.out.println("the sum of the evaluated expressions = " + result);
    }

    @Override
    protected void part2() {
        HomeWorkProcessor homeWorkProcessor = new HomeWorkProcessor();
        long result = homeWorkProcessor.processHomeworkAdvanced(input);
        System.out.println("the sum of the evaluated expressions using Advanced Math = " + result);
    }

}
