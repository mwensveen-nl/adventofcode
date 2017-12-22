package nl.mwensveen.adventofcode.year_2017.day_22;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SporificaVirus {
    private Map<Coordinate, Infection> grid = new HashMap<>();
    private Coordinate currentCoordinate;
    private Direction direction = Direction.UP;

    public SporificaVirus(String input) {
        ArrayList<String> list = split(input, "\n");
        for (int i = 0; i < list.size(); i++) {
            String row = list.get(i);
            for (int j = 0; j < row.length(); j++) {
                Coordinate c = new Coordinate(j, i);
                grid.put(c, Infection.get(row.substring(j, j + 1)));
            }
        }
        int y = Math.floorDiv(list.size(), 2);
        int x = Math.floorDiv(list.get(y).length(), 2);
        currentCoordinate = new Coordinate(x, y);
    }

    public int calculate(int bursts) {
        return IntStream.range(0, bursts).map(i -> work()).sum();
    }

    public int calculateEvolved(int bursts) {
        return IntStream.range(0, bursts).map(i -> workEvolved()).sum();
    }

    private Integer workEvolved() {
        Infection infection = grid.get(currentCoordinate);
        if (infection == null) {
            infection = Infection.CLEAN;
        }
        switch (infection) {
            case INFECTED:
                direction = direction.turnRight();
                grid.put(currentCoordinate, Infection.FLAGGED);
                currentCoordinate = currentCoordinate.move(direction);
                return Integer.valueOf(0);
            case CLEAN:
                direction = direction.turnLeft();
                grid.put(currentCoordinate, Infection.WEAKENED);
                currentCoordinate = currentCoordinate.move(direction);
                return Integer.valueOf(0);
            case FLAGGED:
                direction = direction.reverse();
                grid.put(currentCoordinate, Infection.CLEAN);
                currentCoordinate = currentCoordinate.move(direction);
                return Integer.valueOf(0);
            case WEAKENED:
                grid.put(currentCoordinate, Infection.INFECTED);
                currentCoordinate = currentCoordinate.move(direction);
                return Integer.valueOf(1);
            default:
                throw new RuntimeException();
        }
    }

    private Integer work() {
        Infection infection = grid.get(currentCoordinate);
        if (infection == null) {
            infection = Infection.CLEAN;
        }
        switch (infection) {
            case INFECTED:
                direction = direction.turnRight();
                grid.put(currentCoordinate, Infection.CLEAN);
                currentCoordinate = currentCoordinate.move(direction);
                return Integer.valueOf(0);
            case CLEAN:
                direction = direction.turnLeft();
                grid.put(currentCoordinate, Infection.INFECTED);
                currentCoordinate = currentCoordinate.move(direction);
                return Integer.valueOf(1);
            default:
                throw new RuntimeException();
        }
    }

    private static ArrayList<String> split(String in, String splitString) {
        Iterable<String> split = Splitter.on(splitString)
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        return newArrayList;
    }
}
