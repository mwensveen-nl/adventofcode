package nl.mwensveen.adventofcode.year_2022.day_08;

import com.google.common.collect.Table;
import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class TreetopTreeHouseSolution extends AbstractTimedSolution {

    private List<String> input;
    private Table<Integer, Integer, Tree> forest;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day08.txt");
        ForestParser forestParser = new ForestParser();
        forest = forestParser.parse(input);
    }

    @Override
    protected void part1() {
        VisibilityChecker visibilityChecker = new VisibilityChecker();
        int visibility = visibilityChecker.checkVisibility(forest);
        System.out.println("Number of trees that are visible from outside the grid: " + visibility);

    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new TreetopTreeHouseSolution().run();
    }

}
