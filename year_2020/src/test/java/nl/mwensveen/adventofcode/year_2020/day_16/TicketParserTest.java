package nl.mwensveen.adventofcode.year_2020.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class TicketParserTest {

    @Test
    public void testParse() throws Exception {
        TicketParser parser = new TicketParser();
        List<Integer> list = parser.parse("40,4,50");
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(40), list.get(0));
        assertEquals(Integer.valueOf(4), list.get(1));
        assertEquals(Integer.valueOf(50), list.get(2));
    }

}
