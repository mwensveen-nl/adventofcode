package nl.mwensveen.adventofcode.year_2024.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

class XmasSearcherTest {

	private static String input = """
			MMMSXXMASM
			MSAMXMSMSA
			AMXSXMAAMM
			MSAMASMSMX
			XMASAMXAMM
			XXAMMXXAMA
			SMSMSASXSS
			SAXAMASAAA
			MAMMMXMMMM
			MXMXAXMASX
						""";

	@Test
	public void testSearch() {
		WordSearchInputParser parser = new WordSearchInputParser();
		Table<Integer, Integer, Character> table = parser.parse(input.lines().toList());

		XmasSearcher searcher = new XmasSearcher();
		int count = searcher.search(table);

		assertEquals(2, count);
	}

}
