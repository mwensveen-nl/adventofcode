package nl.mwensveen.adventofcode.year_2023.day_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoopFinder {

    private List<Coordinate> finalUsed;
    private Direction[] directions = Direction.values();

    public int findLoop(Map<Coordinate, Pipes> grid) {
        Coordinate start = grid.entrySet().stream().filter(e -> e.getValue() == Pipes.START).findFirst().get().getKey();

        long count = 0;
        boolean done = false;
        List<Coordinate> used = new ArrayList<>();
        done = step(start, grid, used);
        return (finalUsed.size() + 1) / 2;
    }

    private boolean step(Coordinate coordinate, Map<Coordinate, Pipes> grid, List<Coordinate> used) {
        boolean done = false;

        Pipes currentPipe = grid.get(coordinate);
        for (int i = 0; i < directions.length; i++) {
            Direction direction = directions[i];

            Coordinate newCoordinate = new Coordinate(coordinate.x() + direction.getX(), coordinate.y() + direction.getY());
            Pipes newPipe = grid.get(newCoordinate);

            if (newPipe != null) {
                if (notBack(used, newCoordinate)) {
                    if (newPipe != Pipes.START && newPipe.canStepToThis(currentPipe, direction)) {
                        if (!used.contains(newCoordinate)) {
                            used.add(newCoordinate);
                            done = step(newCoordinate, grid, used);
                        }
                    } else if (Pipes.START == newPipe) {
                        finalUsed = used;
                        done = true;
                    }
                }
                if (done) {
                    return true;
                }
            }
        }
        used.removeLast();
        return false;

    }

    private boolean notBack(List<Coordinate> used, Coordinate coordinate) {
        return used.size() == 0 || !used.getLast().equals(coordinate);
    }
}
