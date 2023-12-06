package nl.mwensveen.adventofcode.year_2023.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RangeTest {

	@Test
	public void testRange() {
		Range range = new Range(79L, 14L);
		assertEquals(79L, range.start());
		assertEquals(92L, range.end());
		assertEquals(14L, range.range());
	}

}
