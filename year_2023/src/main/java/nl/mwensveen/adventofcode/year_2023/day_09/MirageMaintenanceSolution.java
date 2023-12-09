package nl.mwensveen.adventofcode.year_2023.day_09;

import java.util.List;
import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class MirageMaintenanceSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_09.txt");
    }

    @Override
    protected void part1() {
        long result = new OasisReportHandler().handleReport(input, false);
        System.out.println("The sum of the next value for each history: " + result);
    }

    @Override
    protected void part2() {
        long result = new OasisReportHandler().handleReport(input, true);
        System.out.println("The sum of the previous value for each history: " + result);

    }

    public static void main(String[] args) {
        new MirageMaintenanceSolution().run();
    }

}
