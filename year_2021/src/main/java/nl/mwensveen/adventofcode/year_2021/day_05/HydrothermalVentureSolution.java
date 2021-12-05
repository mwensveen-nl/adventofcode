package nl.mwensveen.adventofcode.year_2021.day_05;

import com.google.common.collect.Table;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class HydrothermalVentureSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_05.txt");
    }

    @Override
    protected void part1() {
        List<Line> lines = new LinesParser().parsLines(input);
        Table<Integer, Integer, AtomicInteger> diagram = new DiagramCreator().createDiagramHorizontalVerticalLines(lines);
        long result = new DiagramCounter().countPointsWithOverlap(diagram);
        System.out.println("Number of points that at least have two lines overlap with only horizontal and vertical lines: " + result);
    }

    @Override
    protected void part2() {
        List<Line> lines = new LinesParser().parsLines(input);
        Table<Integer, Integer, AtomicInteger> diagram = new DiagramCreator().createDiagramAllLines(lines);
        long result = new DiagramCounter().countPointsWithOverlap(diagram);
        System.out.println("Number of points that at least have two lines overlap with all lines: " + result);

    }

    public static void main(String[] args) {
        new HydrothermalVentureSolution().run();
    }
}
