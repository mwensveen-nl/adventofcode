package nl.mwensveen.adventofcode.year_2019.day_03;

import java.util.List;
import java.util.OptionalInt;
import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class CrossedWiresSolution extends AbstractTimedSolution {

    public static void main(String[] args) {
        CrossedWiresSolution solution = new CrossedWiresSolution();
        solution.run();

    }

    @Override
    protected void part1() {
        List<String> lines = FileReadHelper.readLines("Day03.txt");
        CrossWiredCalculator crossWiredCalculator = new CrossWiredCalculator();
        OptionalInt distance = crossWiredCalculator.calculateManhattenDistanceOfNearestIntersection(lines);

        System.out.println("Manhatten distance to nearest crossing " + distance.getAsInt());
    }

    @Override
    protected void part2() {
        List<String> lines = FileReadHelper.readLines("Day03.txt");
        CrossWiredCalculator crossWiredCalculator = new CrossWiredCalculator();
        int distance = crossWiredCalculator.calculateMinStepsToIntersection(lines);

        System.out.println("Minimal steps to a crossing " + distance);
    }

}
