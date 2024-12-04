package nl.mwensveen.adventofcode.year_2024.day_04;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2024.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2024.FileReadHelper;

public class CeresSearchSolution extends AbstractTimedSolution {

    private List<String> input;
    private Table<Integer, Integer, Character> table;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_04.txt");
        WordSearchInputParser inputParser = new WordSearchInputParser();
        table = inputParser.parse(input);
    }

    @Override
    protected void part1() {
        XmasSearcher searcher = new XmasSearcher();
        int result = searcher.searchXmas(table);
        System.out.println("Number of times does XMAS appears: " + result);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new CeresSearchSolution().run();
    }

}
