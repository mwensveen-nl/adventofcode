package nl.mwensveen.adventofcode.year_2023.day_07;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandBidTest {

    @Test
    public void testParse() {
        HandBid handBid = HandBid.parse("32T3K 765");
        assertEquals(Arrays.asList("3", "2", "T", "3", "K"), handBid.hand().cards());
        assertEquals(765, handBid.bid());
    }

}
