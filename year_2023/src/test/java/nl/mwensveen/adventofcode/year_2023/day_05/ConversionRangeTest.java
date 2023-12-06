package nl.mwensveen.adventofcode.year_2023.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ConversionRangeTest {

	@Test
	public void testParse() {
		ConversionRange range = ConversionRange.parse("50 98 2");
		assertEquals(50L, range.destinationStart());
		assertEquals(98L, range.sourceStart());
		assertEquals(99L, range.sourceEnd());
		assertEquals(2L, range.range());
	}

	@Test
	public void testProcessSourceRangesBefore() {
		ConversionRange range = ConversionRange.parse("50 98 2");

		Range seed = new Range(79L, 19L);

		List<List<Range>> processedSourceRanges = range.processSourceRanges(Arrays.asList(seed));
		List<Range> newSeeds = processedSourceRanges.get(0);
		List<Range> destinations = processedSourceRanges.get(1);
		assertEquals(1, newSeeds.size());
		assertEquals(seed, newSeeds.get(0));

		assertEquals(0, destinations.size());
	}

	@Test
	public void testProcessSourceRangesAfter() {
		ConversionRange range = ConversionRange.parse("50 98 2");

		Range seed = new Range(100L, 14L);

		List<List<Range>> processedSourceRanges = range.processSourceRanges(Arrays.asList(seed));
		List<Range> newSeeds = processedSourceRanges.get(0);
		List<Range> destinations = processedSourceRanges.get(1);
		assertEquals(1, newSeeds.size());
		assertEquals(seed, newSeeds.get(0));

		assertEquals(0, destinations.size());
	}

	@Test
	public void testProcessSourceRangesPartBefore() {
		ConversionRange range = ConversionRange.parse("52 50 48");

		Range seed = new Range(40L, 20L);

		List<List<Range>> processedSourceRanges = range.processSourceRanges(Arrays.asList(seed));
		List<Range> newSeeds = processedSourceRanges.get(0);
		List<Range> destinations = processedSourceRanges.get(1);
		assertEquals(1, newSeeds.size());
		assertEquals(new Range(40L, 10L), newSeeds.get(0));

		assertEquals(1, destinations.size());
		assertEquals(new Range(52L, 10L), destinations.get(0));
	}

	@Test
	public void testProcessSourceRangesPartAfter() {
		ConversionRange range = ConversionRange.parse("52 50 48");

		Range seed = new Range(90L, 20L);

		List<List<Range>> processedSourceRanges = range.processSourceRanges(Arrays.asList(seed));
		List<Range> newSeeds = processedSourceRanges.get(0);
		List<Range> destinations = processedSourceRanges.get(1);
		assertEquals(1, newSeeds.size());
		assertEquals(new Range(98L, 12L), newSeeds.get(0));

		assertEquals(1, destinations.size());
		assertEquals(new Range(92L, 8L), destinations.get(0));
	}

	@Test
	public void testProcessSourceRangesBetween() {
		ConversionRange range = ConversionRange.parse("52 50 48");

		Range seed = new Range(60L, 18L);

		List<List<Range>> processedSourceRanges = range.processSourceRanges(Arrays.asList(seed));
		List<Range> newSeeds = processedSourceRanges.get(0);
		List<Range> destinations = processedSourceRanges.get(1);
		assertEquals(0, newSeeds.size());

		assertEquals(1, destinations.size());
		assertEquals(new Range(62L, 18L), destinations.get(0));
	}

	@Test
	public void testProcessSourceRangesBeforeAndAfter() {
		ConversionRange range = ConversionRange.parse("52 50 48");

		Range seed = new Range(40L, 70L);

		List<List<Range>> processedSourceRanges = range.processSourceRanges(Arrays.asList(seed));
		List<Range> newSeeds = processedSourceRanges.get(0);
		List<Range> destinations = processedSourceRanges.get(1);
		assertEquals(2, newSeeds.size());
		assertEquals(new Range(40L, 10L), newSeeds.get(0));
		assertEquals(new Range(98L, 12L), newSeeds.get(1));

		assertEquals(1, destinations.size());
		assertEquals(new Range(52L, 48L), destinations.get(0));
	}

	@Test
	public void testProcessSourceRangesTwo() {
		ConversionRange range = ConversionRange.parse("52 50 48");

		Range seed = new Range(40L, 70L);
		Range seed2 = new Range(90L, 20L);

		List<List<Range>> processedSourceRanges = range.processSourceRanges(Arrays.asList(seed, seed2));
		List<Range> newSeeds = processedSourceRanges.get(0);
		List<Range> destinations = processedSourceRanges.get(1);
		assertEquals(3, newSeeds.size());
		assertEquals(new Range(40L, 10L), newSeeds.get(0));
		assertEquals(new Range(98L, 12L), newSeeds.get(1));
		assertEquals(new Range(98L, 12L), newSeeds.get(2));

		assertEquals(2, destinations.size());
		assertEquals(new Range(52L, 48L), destinations.get(0));
		assertEquals(new Range(92L, 8L), destinations.get(1));
	}

}
