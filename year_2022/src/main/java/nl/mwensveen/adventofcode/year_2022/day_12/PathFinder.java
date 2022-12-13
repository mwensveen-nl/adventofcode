package nl.mwensveen.adventofcode.year_2022.day_12;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class PathFinder {

    private Set<Coordinate> processed;
    private Set<Coordinate> unprocessed;
    private int numberOfRows;
    private int numberOfColumns;

    public Coordinate findShortestPathFromStart(Heightmap heightmap) {
        init(heightmap);

        BiFunction<Coordinate, Coordinate, Boolean> bi = (current, neighbour) -> neighbour.getElevation() <= current.getElevation() + 1;

        Coordinate startCoordinate = heightmap.getCoordinates().get(heightmap.getStartRow(), heightmap.getStartCol());
        startCoordinate.setSteps(0);

        Coordinate endCoordinate = heightmap.getCoordinates().get(heightmap.getEndRow(), heightmap.getEndCol());

        Coordinate coordinate = startCoordinate;
        while (!coordinate.equals(endCoordinate)) {
            calculateNextSteps(heightmap, coordinate, bi);
            coordinate = unprocessed.stream().min(Comparator.comparing(c -> c.getSteps())).orElse(null);
        }
        return endCoordinate;
    }

    public Coordinate findShortestPathFromAnyA(Heightmap heightmap) {
        init(heightmap);

        BiFunction<Coordinate, Coordinate, Boolean> bi = (current, neighbour) -> neighbour.getElevation() >= current.getElevation() - 1;

        Coordinate endCoordinate = heightmap.getCoordinates().get(heightmap.getEndRow(), heightmap.getEndCol());
        endCoordinate.setSteps(0);
        Coordinate coordinate = endCoordinate;
        while (coordinate.getElevation() != 'a') {
            calculateNextSteps(heightmap, coordinate, bi);
            coordinate = unprocessed.stream().min(Comparator.comparing(c -> c.getSteps())).orElse(null);
        }
        return coordinate;
    }

    private void init(Heightmap heightmap) {
        processed = new HashSet<>();
        unprocessed = new HashSet<>();

        numberOfRows = heightmap.getCoordinates().rowKeySet().size();
        numberOfColumns = heightmap.getCoordinates().columnKeySet().size();
    }

    private void calculateNextSteps(Heightmap heightmap, Coordinate coordinate, BiFunction<Coordinate, Coordinate, Boolean> bi) {
        int row = coordinate.getRow();
        int col = coordinate.getCol();
        IntStream.rangeClosed(row - 1, row + 1).filter(r -> r >= 0 && r < numberOfRows).forEach(r -> {
            IntStream.rangeClosed(col - 1, col + 1)
                    .filter(c -> c >= 0 && c < numberOfColumns)
                    .filter(c -> r - row == 0 || c - col == 0)
                    .filter(c -> r - row != 0 || c - col != 0)
                    .mapToObj(c -> heightmap.getCoordinates().get(r, c))
                    .filter(neighbour -> bi.apply(coordinate, neighbour))
                    .filter(neighbour -> !processed.contains(neighbour))
                    .forEach(neighbour -> processNeighbour(coordinate, neighbour));
        });
        processed.add(coordinate);
        unprocessed.remove(coordinate);
    }

    private void processNeighbour(Coordinate coordinate, Coordinate neighbour) {
        int neighbourSteps = coordinate.getSteps() + 1;
        if (neighbour.getSteps() > neighbourSteps) {
            neighbour.setSteps(neighbourSteps);
            // neighbour.setShortestPath(coordinate.getShortestPath());
            // neighbour.addToShortestPath(coordinate);
            unprocessed.add(neighbour);
        }
    }
}
