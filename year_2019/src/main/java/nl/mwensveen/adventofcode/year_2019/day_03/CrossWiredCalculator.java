package nl.mwensveen.adventofcode.year_2019.day_03;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class CrossWiredCalculator {

    public OptionalInt calculateManhattenDistanceOfNearestIntersection(List<String> lines) {
        List<Coordinate> intersections = calculateIntersections(lines);
        return intersections.stream().mapToInt(c -> calcDistence(c)).min();
    }

    public int calculateMinStepsToIntersection(List<String> lines) {
        int min = calculateMinStepsIntersections(lines);
        return min;
    }

    private int calcDistence(Coordinate c) {
        int x = Math.abs(c.getX());
        int y = Math.abs(c.getY());
        return x + y;
    }

    private List<Coordinate> calculateIntersections(List<String> lines) {
        List<Coordinate> intersections = new ArrayList<>();
        Table<Integer, Integer, Integer> grid = HashBasedTable.create();
        procesWireOne(lines.get(0), grid);
        procesWireTwo(lines.get(1), grid, intersections);
        return intersections;
    }

    private int calculateMinStepsIntersections(List<String> lines) {
        List<Coordinate> intersections = new ArrayList<>();
        Table<Integer, Integer, Integer> grid = HashBasedTable.create();
        procesWireOne(lines.get(0), grid);
        int steps = procesWireTwo(lines.get(1), grid, intersections);
        return steps;
    }

    private void procesWireOne(String input, Table<Integer, Integer, Integer> grid) {
        Coordinate coordinate = new Coordinate(0, 0);
        String[] path = input.split(",");
        int counter = 1;
        for (String step : path) {
            String direction = step.substring(0, 1);
            Integer size = Integer.valueOf(step.substring(1));
            switch (direction) {
                case "R":
                    for (int i = 0; i < size; i++) {
                        coordinate = new Coordinate(coordinate.getX() + 1, coordinate.getY());
                        setStepInGrid(grid, coordinate, counter);
                        counter++;
                    }
                    break;
                case "L":
                    for (int i = 0; i < size; i++) {
                        coordinate = new Coordinate(coordinate.getX() - 1, coordinate.getY());
                        setStepInGrid(grid, coordinate, counter);
                        counter++;
                    }
                    break;
                case "U":
                    for (int i = 0; i < size; i++) {
                        coordinate = new Coordinate(coordinate.getX(), coordinate.getY() + 1);
                        setStepInGrid(grid, coordinate, counter);
                        counter++;
                    }
                    break;
                case "D":
                    for (int i = 0; i < size; i++) {
                        coordinate = new Coordinate(coordinate.getX(), coordinate.getY() - 1);
                        setStepInGrid(grid, coordinate, counter);
                        counter++;
                    }
                    break;
                default:
                    throw new RuntimeException("invalid direction " + direction);
            }
        }
    }

    private void setStepInGrid(Table<Integer, Integer, Integer> grid, Coordinate coordinate, int counter) {
        if (grid.get(coordinate.getX(), coordinate.getY()) == null) {
            grid.put(coordinate.getX(), coordinate.getY(), counter);
        }
    }

    private int procesWireTwo(String input, Table<Integer, Integer, Integer> grid, List<Coordinate> intersections) {
        Coordinate coordinate = new Coordinate(0, 0);
        String[] path = input.split(",");
        int counter = 1;
        int minTotalIntersectingSteps = Integer.MAX_VALUE;
        for (String step : path) {
            String direction = step.substring(0, 1);
            Integer size = Integer.valueOf(step.substring(1));
            switch (direction) {
                case "R":
                    for (int i = 0; i < size; i++) {
                        coordinate = new Coordinate(coordinate.getX() + 1, coordinate.getY());
                        Integer cell = grid.get(coordinate.getX(), coordinate.getY());
                        if (cell != null) {
                            minTotalIntersectingSteps = crossing(intersections, coordinate, counter, minTotalIntersectingSteps, cell);
                        }
                        counter++;
                    }
                    break;
                case "L":
                    for (int i = 0; i < size; i++) {
                        coordinate = new Coordinate(coordinate.getX() - 1, coordinate.getY());
                        Integer cell = grid.get(coordinate.getX(), coordinate.getY());
                        if (cell != null) {
                            minTotalIntersectingSteps = crossing(intersections, coordinate, counter, minTotalIntersectingSteps, cell);
                        }
                        counter++;
                    }
                    break;
                case "U":
                    for (int i = 0; i < size; i++) {
                        coordinate = new Coordinate(coordinate.getX(), coordinate.getY() + 1);
                        Integer cell = grid.get(coordinate.getX(), coordinate.getY());
                        if (cell != null) {
                            minTotalIntersectingSteps = crossing(intersections, coordinate, counter, minTotalIntersectingSteps, cell);
                        }
                        counter++;
                    }
                    break;
                case "D":
                    for (int i = 0; i < size; i++) {
                        coordinate = new Coordinate(coordinate.getX(), coordinate.getY() - 1);
                        Integer cell = grid.get(coordinate.getX(), coordinate.getY());
                        if (cell != null) {
                            minTotalIntersectingSteps = crossing(intersections, coordinate, counter, minTotalIntersectingSteps, cell);
                        }
                        counter++;
                    }
                    break;
                default:
                    throw new RuntimeException("invalid direction " + direction);
            }
        }
        return minTotalIntersectingSteps;
    }

    private int crossing(List<Coordinate> intersections, Coordinate coordinate, int counter, int minTotalIntersectingSteps, Integer cell) {
        intersections.add(coordinate);
        int totalIntersectingSteps = cell.intValue() + counter;
        int min = Math.min(minTotalIntersectingSteps, totalIntersectingSteps);
        return min;
    }

}
