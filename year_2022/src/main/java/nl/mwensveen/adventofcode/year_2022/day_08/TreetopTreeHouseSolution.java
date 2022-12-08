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
        long visibility = visibilityChecker.checkVisibility(forest);
        System.out.println("Number of trees that are visible from outside the grid: " + visibility);

    }

    @Override
    protected void part2() {
        ScenicScoreFinder scenicScoreFinder = new ScenicScoreFinder();
        int scenicScore = scenicScoreFinder.findScenicScore(forest);
        System.out.println("The highest scenic score possible for any tree: " + scenicScore);
    }

    public static void main(String[] args) {
        new TreetopTreeHouseSolution().run();
    }

}
