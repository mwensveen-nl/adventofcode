package nl.mwensveen.adventofcode.year_2020.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TicketsProcessorTest {

    @Test
    public void testProcess() throws Exception {
        List<String> inputString = Arrays.asList("class: 1-3 or 5-7", "row: 6-11 or 33-44", "seat: 13-40 or 45-50", "", "your ticket:", "7,1,14", "",
                "nearby tickets:", "7,3,47", "40,4,50", "55,2,20", "38,6,12");
        InputParser inputParser = new InputParser();
        Input input = inputParser.parse(inputString);

        TicketsProcessor processor = new TicketsProcessor();
        long result = processor.process(input.getNearbyTickets(), input.getFields());
        assertEquals(71L, result);
    }

}
