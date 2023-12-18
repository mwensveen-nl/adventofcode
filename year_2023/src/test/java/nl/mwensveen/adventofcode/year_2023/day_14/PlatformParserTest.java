package nl.mwensveen.adventofcode.year_2023.day_14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

class PlatformParserTest {

	private String input = """
			O....#....
			O.OO#....#
			.....##...
			OO.#O....O
			.O.....O#.
			O.#..O.#.#
			..O..#O..O
			.......O..
			#....###..
			#OO..#....
						""";

	@Test
	public void testParse() {
		PlatformParser parser = new PlatformParser();
		Table<Integer, Integer, Rock> platform = parser.parse(input.lines().toList());
		assertEquals(Rock.ROUND, platform.get(0, 0));
		assertFalse(platform.contains(0, 1));
		assertEquals(Rock.CUBE, platform.get(9, 5));
	}

}
