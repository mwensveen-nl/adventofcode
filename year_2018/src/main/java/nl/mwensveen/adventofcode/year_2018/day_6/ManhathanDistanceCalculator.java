package nl.mwensveen.adventofcode.year_2018.day_6;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ManhathanDistanceCalculator {

    private List<Coordinate> coordinates;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;

    public ManhathanDistanceCalculator(List<String> input) {
        AtomicInteger id = new AtomicInteger(0);
        coordinates = input.stream().map(s -> createCoordinate(id.getAndIncrement(), s)).collect(Collectors.toList());
        maxX = coordinates.stream().mapToInt(Coordinate::getX).max().getAsInt();
        maxY = coordinates.stream().mapToInt(Coordinate::getY).max().getAsInt();
        minX = coordinates.stream().mapToInt(Coordinate::getX).min().getAsInt();
        minY = coordinates.stream().mapToInt(Coordinate::getY).min().getAsInt();
    }

    public int calculateLargestArea() {
        Table<Integer, Integer, Distance> grid = HashBasedTable.create();

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Distance distance = new Distance(Integer.MAX_VALUE);
                for (Coordinate c : coordinates) {
                    updateDistance(x, y, distance, c);
                }
                grid.put(x, y, distance);
            }
        }

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Distance distance = grid.get(x, y);
                if (distance != null && distance.getCoordinate() != null) {
                    distance.getCoordinate().addArea();
                }
            }
        }

        Set<Coordinate> infinitCoordinates = determineInfinitCoordinates(maxX, maxY, minX, minY, grid);
        return coordinates.stream().filter(c -> !infinitCoordinates.contains(c)).mapToInt(Coordinate::getArea).max().getAsInt();

    }

    public int calculateRegion(int maxDistance) {
        Table<Integer, Integer, Distance> grid = HashBasedTable.create();

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Distance distance = new Distance(0);
                for (Coordinate c : coordinates) {
                    distance.addToDistance(distanceTo(c, x, y));
                }
                grid.put(x, y, distance);
            }
        }
        int count = 0;
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (grid.get(x, y).getDistance() < maxDistance) {
                    count++;
                }

            }
        }
        return count;
    }

    private Set<Coordinate> determineInfinitCoordinates(int maxX, int maxY, int minX, int minY, Table<Integer, Integer, Distance> grid) {
        Set<Coordinate> infinite = new HashSet<>();
        for (int x = minX; x <= maxX; x++) {
            Distance distance = grid.get(x, minY);
            if (distance.getCoordinate() != null) {
                infinite.add(distance.getCoordinate());
            }
            distance = grid.get(x, maxY);
            if (distance.getCoordinate() != null) {
                infinite.add(distance.getCoordinate());
            }
        }
        for (int y = minY; y <= maxY; y++) {
            Distance distance = grid.get(minX, y);
            if (distance.getCoordinate() != null) {
                infinite.add(distance.getCoordinate());
            }
            distance = grid.get(maxX, y);
            if (distance.getCoordinate() != null) {
                infinite.add(distance.getCoordinate());
            }
        }
        return infinite;
    }

    private void updateDistance(int x, int y, Distance distance, Coordinate c) {
        int distanceTo = distanceTo(c, x, y);
        if (distanceTo < distance.getDistance()) {
            distance.setCoordinate(c);
            distance.setDistance(distanceTo);
        } else if (distanceTo == distance.getDistance()) {
            distance.setCoordinate(null);
        }
    }

    private int distanceTo(Coordinate c, int x, int y) {
        return Math.abs(c.getX() - x) + Math.abs(c.getY() - y);
    }

    private Coordinate createCoordinate(int i, String s) {
        int index = s.indexOf(",");
        return new Coordinate(i, Integer.valueOf(s.substring(0, index)).intValue(), Integer.valueOf(s.substring(index + 2)).intValue());
    }
}
