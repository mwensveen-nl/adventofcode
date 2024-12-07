package nl.mwensveen.adventofcode.year_2024.day_06;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GuardMover {

    private int rows;
    private int cols;

    public int moveGuard(Table<Integer, Integer, Cell> lm, Guard guard) {
        int rows = lm.rowKeySet().size();
        int cols = lm.columnKeySet().size();

        boolean keepWalking = true;
        while (keepWalking) {
            Position pos = guard.inspect();
            if (pos.row() < 0 || pos.row() == rows || pos.col() < 0 || pos.col() == cols) {
                keepWalking = false;
            } else if (lm.get(pos.row(), pos.col()).equals(Cell.OBSTRUCTION)) {
                guard.turnRight();
            } else {
                lm.put(pos.row(), pos.col(), Cell.VISITED);
                guard.step();
            }
        }
        return count(lm, rows, cols);
    }

    private int count(Table<Integer, Integer, Cell> lm, int rows, int cols) {
        return IntStream.range(0, rows)
                .map(r -> {
                    return IntStream.range(0, cols)
                            .filter(c -> {
                                Cell cell = lm.get(r, c);
                                return cell.equals(Cell.GUARD) || cell.equals(Cell.VISITED);
                            })
                            .map(foo -> 1)
                            .sum();
                })
                .sum();
    }

    public int placeObstructionsAndMove(Table<Integer, Integer, Cell> lm, Guard guardInit) {
        rows = lm.rowKeySet().size();
        cols = lm.columnKeySet().size();

        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = lm.get(r, c);
                if (cell.equals(Cell.VISITED)) {
                    Guard guard = new Guard(guardInit.getPosition().row(), guardInit.getPosition().col());
                    lm.put(r, c, Cell.OBSTRUCTION);
                    boolean loop = moveGuardExtraObstruction(lm, guard);
                    if (loop) {
                        count++;
                    }
                    lm.put(r, c, Cell.VISITED);
                }
            }
        }
        return count;
    }

    private boolean moveGuardExtraObstruction(Table<Integer, Integer, Cell> lm, Guard guard) {
        Table<Integer, Integer, List<Direction>> steps = HashBasedTable.create();

        while (true) {
            Position pos = guard.inspect();
            if (pos.row() < 0 || pos.row() == rows || pos.col() < 0 || pos.col() == cols) {
                return false;
            }

            if (lm.get(pos.row(), pos.col()).equals(Cell.OBSTRUCTION)) {
                guard.turnRight();
            } else {
                List<Direction> directions = steps.get(pos.row(), pos.col());
                if (directions == null) {
                    directions = new ArrayList<>();
                    steps.put(pos.row(), pos.col(), directions);
                }
                if (directions.contains(guard.getDirection())) {
                    return true;
                } else {
                    directions.add(guard.getDirection());
                }
                guard.step();
            }
        }
    }
}
