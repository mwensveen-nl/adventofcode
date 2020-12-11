package nl.mwensveen.adventofcode.year_2020.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class FloorPlanParserTest {

    @Test
    public void testParse1() throws Exception {
        FloorPlanParser parser = new FloorPlanParser();
        Table<Long, Long, PositionState> plan = parser.parse(Arrays.asList("L.LL.LL.LL"));
        assertEquals(1, plan.rowKeySet().size());
        Map<Long, PositionState> row = plan.row(0L);
        assertEquals(10, row.keySet().size());
        assertEquals(PositionState.EMPTY, row.get(0L));
        assertEquals(PositionState.FLOOR, row.get(1L));
        assertEquals(PositionState.EMPTY, row.get(2L));
        assertEquals(PositionState.EMPTY, row.get(3L));
        assertEquals(PositionState.FLOOR, row.get(4L));
        assertEquals(PositionState.EMPTY, row.get(5L));
        assertEquals(PositionState.EMPTY, row.get(6L));
        assertEquals(PositionState.FLOOR, row.get(7L));
        assertEquals(PositionState.EMPTY, row.get(8L));
        assertEquals(PositionState.EMPTY, row.get(9L));
    }

    @Test
    public void testParse10() throws Exception {
        FloorPlanParser parser = new FloorPlanParser();
        Table<Long, Long, PositionState> plan = parser.parse(Arrays.asList("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL",
                "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL"));
        assertEquals(10, plan.rowKeySet().size());
        Map<Long, PositionState> row = plan.row(9L);
        assertEquals(10, row.keySet().size());
        assertEquals(PositionState.EMPTY, row.get(0L));
        assertEquals(PositionState.FLOOR, row.get(1L));
        assertEquals(PositionState.EMPTY, row.get(2L));
        assertEquals(PositionState.EMPTY, row.get(3L));
        assertEquals(PositionState.EMPTY, row.get(4L));
        assertEquals(PositionState.EMPTY, row.get(5L));
        assertEquals(PositionState.EMPTY, row.get(6L));
        assertEquals(PositionState.FLOOR, row.get(7L));
        assertEquals(PositionState.EMPTY, row.get(8L));
        assertEquals(PositionState.EMPTY, row.get(9L));
    }
}
