package nl.mwensveen.adventofcode.year_2023.day_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class HandBidTest {

	@Test
	public void testParse() {
		HandBid handBid = HandBid.parse("32T3K 765");
		assertEquals(Arrays.asList("3", "2", "T", "3", "K"), handBid.hand().cards());
		assertEquals(Type.OnePair, handBid.hand().type());
		assertEquals(765, handBid.bid());
	}

	@Test
	public void testParseWithJokers() {
		HandBid handBid = HandBid.parseWithJokers("QAQJA 765");
		assertEquals(Arrays.asList("Q", "A", "Q", "0", "A"), handBid.hand().cards());
		assertEquals(Type.FullHouse, handBid.hand().type());
		assertEquals(765, handBid.bid());
	}

}
