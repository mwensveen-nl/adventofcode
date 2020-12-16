package nl.mwensveen.adventofcode.year_2020.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    public void testParse() throws Exception {
        List<String> inputString = Arrays.asList("class: 1-3 or 5-7", "row: 6-11 or 33-44", "seat: 13-40 or 45-50", "", "your ticket:", "7,1,14", "",
                "nearby tickets:", "7,3,47", "40,4,50", "55,2,20", "38,6,12");
        InputParser inputParser = new InputParser();
        Input input = inputParser.parse(inputString);

        assertEquals(3, input.getFields().size());
        assertEquals("class", input.getFields().get(0).getName());
        assertEquals("row", input.getFields().get(1).getName());
        assertEquals("seat", input.getFields().get(2).getName());

        assertEquals(3, input.getMyTicket().size());
        assertEquals(7, input.getMyTicket().get(0));
        assertEquals(1, input.getMyTicket().get(1));
        assertEquals(14, input.getMyTicket().get(2));

        assertEquals(4, input.getNearbyTickets().size());
        assertEquals(7, input.getNearbyTickets().get(0).get(0));
        assertEquals(3, input.getNearbyTickets().get(0).get(1));
        assertEquals(47, input.getNearbyTickets().get(0).get(2));
        assertEquals(40, input.getNearbyTickets().get(1).get(0));
        assertEquals(55, input.getNearbyTickets().get(2).get(0));
        assertEquals(38, input.getNearbyTickets().get(3).get(0));
    }

}
