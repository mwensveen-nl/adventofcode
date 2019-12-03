package nl.mwensveen.adventofcode.year_2019.day_03;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;
import java.util.OptionalInt;

public class CrossWiredCalculator {

    public int calculateManhattenDistanceOfNearestIntersection(List<String> lines) {
        Table<Integer, Integer, Integer> wireOne = procesWire(lines.get(0));
        Table<Integer, Integer, Integer> wireTwo = procesWire(lines.get(1));
        OptionalInt min = wireOne.cellSet().stream().filter(cell -> wireTwo.contains(cell.getRowKey(), cell.getColumnKey()))
                .mapToInt(cell -> Math.abs(cell.getRowKey()) + Math.abs(cell.getColumnKey())).min();
        return min.getAsInt();
    }

    public int calculateMinStepsToIntersection(List<String> lines) {
        Table<Integer, Integer, Integer> wireOne = procesWire(lines.get(0));
        Table<Integer, Integer, Integer> wireTwo = procesWire(lines.get(1));

        OptionalInt min = wireOne.cellSet().stream().filter(cell -> wireTwo.contains(cell.getRowKey(), cell.getColumnKey()))
                .mapToInt(cell -> (cell.getValue().intValue() + wireTwo.get(cell.getRowKey(), cell.getColumnKey()).intValue())).min();
        return min.getAsInt();
    }

    private Table<Integer, Integer, Integer> procesWire(String input) {
        Table<Integer, Integer, Integer> grid = HashBasedTable.create();
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
        return grid;
    }

    private void setStepInGrid(Table<Integer, Integer, Integer> grid, Coordinate coordinate, int counter) {
        if (grid.get(coordinate.getX(), coordinate.getY()) == null) {
            grid.put(coordinate.getX(), coordinate.getY(), counter);
        }
    }

}
