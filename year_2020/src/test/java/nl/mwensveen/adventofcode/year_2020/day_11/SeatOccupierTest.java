package nl.mwensveen.adventofcode.year_2020.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class SeatOccupierTest {

    @Test
    public void testChangeSeating() throws Exception {
        FloorPlanParser parser = new FloorPlanParser();
        Table<Long, Long, PositionState> input = parser.parse(Arrays.asList("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL",
                "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL"));
        SeatOccupier seatOccupier = new SeatOccupier();

        Table<Long, Long, PositionState> result = seatOccupier.changeSeating(input);

        Table<Long, Long, PositionState> expected = parser.parse(Arrays.asList("#.##.##.##", "#######.##", "#.#.#..#..", "####.##.##", "#.##.##.##",
                "#.#####.##", "..#.#.....", "##########", "#.######.#", "#.#####.##"));
        assertEquals(expected, result);
    }

    @Test
    public void testChangeSeating2Times() throws Exception {
        FloorPlanParser parser = new FloorPlanParser();
        Table<Long, Long, PositionState> input = parser.parse(Arrays.asList("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL",
                "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL"));
        SeatOccupier seatOccupier = new SeatOccupier();

        Table<Long, Long, PositionState> result = seatOccupier.changeSeating(input);
        Table<Long, Long, PositionState> expected = parser.parse(Arrays.asList("#.##.##.##", "#######.##", "#.#.#..#..", "####.##.##", "#.##.##.##",
                "#.#####.##", "..#.#.....", "##########", "#.######.#", "#.#####.##"));
        assertEquals(expected, result);

        result = seatOccupier.changeSeating(result);
        expected = parser.parse(Arrays.asList("#.LL.L#.##", "#LLLLLL.L#", "L.L.L..L..", "#LLL.LL.L#", "#.LL.LL.LL", "#.LLLL#.##", "..L.L.....", "#LLLLLLLL#",
                "#.LLLLLL.L", "#.#LLLL.##"));
        assertEquals(expected, result);
    }

    @Test
    public void testChangeSeatingDirections() throws Exception {
        FloorPlanParser parser = new FloorPlanParser();
        Table<Long, Long, PositionState> input = parser.parse(Arrays.asList("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL",
                "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL"));
        SeatOccupier seatOccupier = new SeatOccupier();

        Table<Long, Long, PositionState> result = seatOccupier.changeSeatingDirections(input);

        Table<Long, Long, PositionState> expected = parser.parse(Arrays.asList("#.##.##.##", "#######.##", "#.#.#..#..", "####.##.##", "#.##.##.##",
                "#.#####.##", "..#.#.....", "##########", "#.######.#", "#.#####.##"));
        assertEquals(expected, result);
    }

    @Test
    public void testChangeSeatingDirections2Times() throws Exception {
        FloorPlanParser parser = new FloorPlanParser();
        Table<Long, Long, PositionState> input = parser.parse(Arrays.asList("L.LL.LL.LL", "LLLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL",
                "..L.L.....", "LLLLLLLLLL", "L.LLLLLL.L", "L.LLLLL.LL"));
        SeatOccupier seatOccupier = new SeatOccupier();

        Table<Long, Long, PositionState> result = seatOccupier.changeSeatingDirections(input);

        Table<Long, Long, PositionState> expected = parser.parse(Arrays.asList("#.##.##.##", "#######.##", "#.#.#..#..", "####.##.##", "#.##.##.##",
                "#.#####.##", "..#.#.....", "##########", "#.######.#", "#.#####.##"));
        assertEquals(expected, result);

        result = seatOccupier.changeSeatingDirections(result);
        expected = parser.parse(Arrays.asList("#.LL.LL.L#", "#LLLLLL.LL", "L.L.L..L..", "LLLL.LL.LL", "L.LL.LL.LL", "L.LLLLL.LL", "..L.L.....", "LLLLLLLLL#",
                "#.LLLLLL.L", "#.LLLLL.L#"));
        assertEquals(expected, result);
    }

}
