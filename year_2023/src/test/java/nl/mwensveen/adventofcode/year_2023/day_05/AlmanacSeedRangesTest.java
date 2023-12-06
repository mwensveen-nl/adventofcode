package nl.mwensveen.adventofcode.year_2023.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AlmanacSeedRangesTest {

	@Test
	public void testParse() {
		AlmanacSeedRanges almanacSeedRanges = AlmanacSeedRanges.parse("seeds: 79 14 55 13");
		assertEquals(2, almanacSeedRanges.seeds().size());
		assertEquals(55L, almanacSeedRanges.seeds().get(1).start());
		assertEquals(67L, almanacSeedRanges.seeds().get(1).end());
	}

}
