package nl.mwensveen.adventofcode.year_2024.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class LocationListParserTest {

	private String input = """
			         3   4
			4   3
			2   5
			1   3
			3   9
			3   3
						""";

	@Test
	public void testReadLists() {
		LocationListParser locationListParser = new LocationListParser();
		List<List<Integer>> lists = locationListParser.readLists(input.lines().toList());
		assertEquals(2, lists.size());
		assertEquals(6, lists.get(0).size());
		assertEquals(3, lists.get(0).getFirst());
		assertEquals(3, lists.get(0).getLast());
		assertEquals(6, lists.get(1).size());
		assertEquals(4, lists.get(1).getFirst());
		assertEquals(3, lists.get(1).getLast());
	}

}
