package nl.mwensveen.adventofcode.year_2023.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

class GalaxiesParserTest {

	private String input = """
			...#......
			.......#..
			#.........
			..........
			......#...
			.#........
			.........#
			..........
			.......#..
			#...#.....
						""";

	@Test
	public void testParseGalaxies() {
		Table<Integer, Integer, String> galaxies = new GalaxiesParser().parseGalaxies(input.lines().toList());
		assertEquals("#", galaxies.get(0, 3));
		assertEquals("#", galaxies.get(1, 7));
		assertEquals("#", galaxies.get(9, 0));
		assertEquals("#", galaxies.get(9, 4));

		assertFalse(galaxies.contains(0, 0));
	}

}
