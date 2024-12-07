package nl.mwensveen.adventofcode.year_2024.day_06;

import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LabMapParserTest {
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
    public void testParseRow() {
        LabMapParser lmp = new LabMapParser();
        Table<Integer, Integer, Cell> lm = lmp.parse(input.lines().toList());
        assertEquals(10, lm.rowKeySet().size());
        assertEquals(10, lm.columnKeySet().size());
        assertEquals(Cell.EMPTY, lm.get(0, 0));
        assertEquals(Cell.OBSTRUCTION, lm.get(0, 4));
        assertEquals(Cell.GUARD, lm.get(6, 4));
    }

    @Test
    public void testFindGuard() {
        LabMapParser lmp = new LabMapParser();
        Table<Integer, Integer, Cell> lm = lmp.parse(input.lines().toList());
        Guard guard = lmp.findGuard(lm);
        Position pos = guard.inspect();
        assertEquals(5, pos.row());
        assertEquals(4, pos.col());
    }

}
