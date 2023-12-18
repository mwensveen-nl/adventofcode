package nl.mwensveen.adventofcode.year_2023.day_10;

import java.util.List;
import java.util.Map;
import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class PipeMazeSolution extends AbstractTimedSolution {

    private List<String> input;
    private Map<Coordinate, Pipes> grid;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_10.txt");
        grid = new TilesParser().parse(input);
    }

    @Override
    protected void part1() {
        int count = new LoopFinder().findLoop(grid);
        System.out.println(count);
    }

    @Override
    protected void part2() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new PipeMazeSolution().run();

    }

}
