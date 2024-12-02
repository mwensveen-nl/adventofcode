package nl.mwensveen.adventofcode.year_2024.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LocationListComparatorTest {
	private String input = """
			         3   4
			4   3
			2   5
			1   3
			3   9
			3   3
						""";

	@Test
	public void testCompareLists() {
		LocationListParser locationListParser = new LocationListParser();
		List<List<Integer>> lists = locationListParser.readLists(input.lines().toList());

		LocationListComparator listComparator = new LocationListComparator();
		Integer result = listComparator.compareLists(lists.getFirst(), lists.getLast());
		assertEquals(11, result);
	}

	@Test
	public void testSimilarityScore() {
		LocationListParser locationListParser = new LocationListParser();
		List<List<Integer>> lists = locationListParser.readLists(input.lines().toList());

		LocationListComparator listComparator = new LocationListComparator();
		Integer result = listComparator.similarityScore(lists.getFirst(), lists.getLast());
		assertEquals(31, result);
	}

}
