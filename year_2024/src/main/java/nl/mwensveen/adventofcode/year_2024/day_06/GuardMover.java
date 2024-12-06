package nl.mwensveen.adventofcode.year_2024.day_06;

import com.google.common.collect.Table;
import java.util.List;
import java.util.stream.IntStream;

public class GuardMover {

    public int moveGuard(Table<Integer, Integer, Cell> lm, Guard guard) {
        int rows = lm.rowKeySet().size();
        int cols = lm.columnKeySet().size();

        boolean keepWalking = true;
        while (keepWalking) {
            List<Integer> pos = guard.inspect();
            if (pos.getFirst() < 0 || pos.getFirst() == rows || pos.getLast() < 0 || pos.getLast() == cols) {
                keepWalking = false;
            } else if (lm.get(pos.getFirst(), pos.getLast()).equals(Cell.OBSTRUCTION)) {
                guard.turnRight();
            } else {
                lm.put(pos.getFirst(), pos.getLast(), Cell.VISITED);
                guard.step();
            }
        }
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
}
