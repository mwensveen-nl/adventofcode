package nl.mwensveen.adventofcode.year_2020.day_01;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class ReportRepairSolution extends AbstractTimedSolution {

    public static void main(String[] args) {
        ReportRepairSolution solution = new ReportRepairSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        List<Integer> integers = FileReadHelper.readLinesAsIntegers("Day_01.txt");

        ReportRepairCalculator calculator = new ReportRepairCalculator();
        Integer result = calculator.findEntriesInExpenceReportTwo(integers);
        System.out.println("Multiplying entries together produces " + result);
    }

    @Override
    protected void part2() {
        List<Integer> integers = FileReadHelper.readLinesAsIntegers("Day_01.txt");

        ReportRepairCalculator calculator = new ReportRepairCalculator();
        Integer result = calculator.findEntriesInExpenceReportThree(integers);
        System.out.println("Multiplying THREE entries together produces " + result);
    }

}
