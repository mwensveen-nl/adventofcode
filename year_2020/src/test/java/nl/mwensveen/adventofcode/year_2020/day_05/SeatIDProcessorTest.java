package nl.mwensveen.adventofcode.year_2020.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SeatIDProcessorTest {

    @Test
    public void testFindHighestSeatId() throws Exception {
        List<String> input = Arrays.asList("FBFBBFFRLR", "BFFFBBFRRR", "BBFFBBFRLL", "FFFBBBFRRR");
        SeatIDProcessor seatIDProcessor = new SeatIDProcessor();
        assertEquals(820, seatIDProcessor.findHighestSeatId(input));
    }

}
