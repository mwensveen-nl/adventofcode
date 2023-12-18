package nl.mwensveen.adventofcode.year_2023.day_13;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class PointOfIncidenceSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_13.txt");
    }

    @Override
    protected void part1() {
        PatternParser parser = new PatternParser();
        List<Table<Integer, Integer, Symbol>> list = parser.parse(input);
        PatternAnalyzer patternAnalyzer = new PatternAnalyzer();
        long result = patternAnalyzer.analyze(list);
        System.out.println("the number after summarizing all of the notes: " + result);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new PointOfIncidenceSolution().run();
    }

}
