package nl.mwensveen.adventofcode.year_2024.day_05;

import com.google.common.collect.Multimap;
import java.util.List;
import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class PrintQueueSolution extends AbstractTimedSolution {

    private List<String> input;
    private Multimap<Integer, Integer> rules;
    private List<List<Integer>> updates;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_05.txt");
        PrinterParser parser = new PrinterParser();
        rules = parser.parseRules(input);
        updates = parser.parseUpdates(input);
    }

    @Override
    protected void part1() {
        UpdatePrinter updateChecker = new UpdatePrinter();
        long result = updateChecker.checkUpdates(rules, updates);
        System.out.println("Result you get if you add up the middle page number from those correctly-ordered updates: " + result);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new PrintQueueSolution().run();
    }

}
