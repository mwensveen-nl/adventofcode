package nl.mwensveen.adventofcode.year_2024.day_06;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuardMoverTest {
    private String input = """
            ....#.....
            .........#
            ..........
            ..#.......
            .......#..
            ..........
            .#..^.....
            ........#.
            #.........
            ......#...
                    """;

    @Test
    public void testMoveGuard() {
        LabMapParser lmp = new LabMapParser();
        Table<Integer, Integer, Cell> lm = lmp.parse(input.lines().toList());
        Guard guard = lmp.findGuard(lm);

        GuardMover guardMover = new GuardMover();
        int result = guardMover.moveGuard(lm, guard);

        assertEquals(41, result);
    }

}
