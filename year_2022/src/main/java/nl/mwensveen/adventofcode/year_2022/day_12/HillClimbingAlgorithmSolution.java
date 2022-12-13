package nl.mwensveen.adventofcode.year_2022.day_12;

import java.util.List;
import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class HillClimbingAlgorithmSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day12.txt");
    }

    @Override
    protected void part1() {
        HeightmapParser heightmapParser = new HeightmapParser();
        Heightmap heightmap = heightmapParser.parse(input);
        PathFinder pathFinder = new PathFinder();
        Coordinate coordinate = pathFinder.findShortestPathFromStart(heightmap);
        System.out.println("The fewest steps required to move from the current position to the location that should get the best signal: " + coordinate.getSteps());

    }

    @Override
    protected void part2() {
        HeightmapParser heightmapParser = new HeightmapParser();
        Heightmap heightmap = heightmapParser.parse(input);
        PathFinder pathFinder = new PathFinder();
        Coordinate coordinate = pathFinder.findShortestPathFromAnyA(heightmap);
        System.out.println("The fewest steps required to move starting from any square with elevation a to the location that should get the best signal: " + coordinate.getSteps());
    }

    public static void main(String[] args) {
        new HillClimbingAlgorithmSolution().run();
    }

}
