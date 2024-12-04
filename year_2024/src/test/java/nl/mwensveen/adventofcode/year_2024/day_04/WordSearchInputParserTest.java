package nl.mwensveen.adventofcode.year_2024.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

class WordSearchInputParserTest {

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
	public void testParse() {
		WordSearchInputParser parser = new WordSearchInputParser();
		Table<Integer, Integer, Character> table = parser.parse(input.lines().toList());
		assertEquals(10, table.rowKeySet().size());
		assertEquals(10, table.columnKeySet().size());
		assertEquals('M', table.get(0, 0));
		assertEquals('X', table.get(9, 9));
	}

}
