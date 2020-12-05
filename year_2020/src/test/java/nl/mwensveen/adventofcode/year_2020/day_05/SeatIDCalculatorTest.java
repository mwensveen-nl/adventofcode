package nl.mwensveen.adventofcode.year_2020.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SeatIDCalculatorTest {

    @Test
    public void testCalcSeatId() throws Exception {
        SeatIDCalculator seatIDCalculator = new SeatIDCalculator();
        assertEquals(357, seatIDCalculator.calcSeatId("FBFBBFFRLR"));
        assertEquals(567, seatIDCalculator.calcSeatId("BFFFBBFRRR"));
        assertEquals(119, seatIDCalculator.calcSeatId("FFFBBBFRRR"));
        assertEquals(820, seatIDCalculator.calcSeatId("BBFFBBFRLL"));
    }

}
