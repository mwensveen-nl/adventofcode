package nl.mwensveen.adventofcode.year_2020.day_01;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class ReportRepairSolution extends AbstractTimedSolution {

    private List<Integer> integers;

    public static void main(String[] args) {
        new ReportRepairSolution().run();
    }

    @Override
    protected void part1() {
        ReportRepairCalculator calculator = new ReportRepairCalculator();
        Integer result = calculator.findEntriesInExpenceReportTwo(integers);
        System.out.println("Multiplying entries together produces " + result);
    }

    @Override
    protected void part2() {
        ReportRepairCalculator calculator = new ReportRepairCalculator();
        Integer result = calculator.findEntriesInExpenceReportThree(integers);
        System.out.println("Multiplying THREE entries together produces " + result);
    }

    @Override
    protected void init() {
        integers = FileReadHelper.readLinesAsIntegers("Day_01.txt");
    }

}
