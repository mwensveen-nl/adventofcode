package nl.mwensveen.adventofcode.year_2022.day_04;

import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class CampCleanupSolution extends AbstractTimedSolution {

    private List<String> input;
    private AssignmentInspector assignmentInspector = new AssignmentInspector();

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day04.txt");
    }

    @Override
    protected void part1() {
        long count = assignmentInspector.countContainingOther(input);
        System.out.println("Number of assignment pairs where one range fully contain the other: " + count);
    }

    @Override
    protected void part2() {
        long count = assignmentInspector.countOverlapOther(input);
        System.out.println("Number of assignment pairs that do overlap?: " + count);
    }

    public static void main(String[] args) {
        new CampCleanupSolution().run();
    }

}
