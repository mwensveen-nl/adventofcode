package nl.mwensveen.adventofcode.year_2023.day_14;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

class PlatformTilterTest {
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
	public void testTiltNorth() {
		PlatformParser parser = new PlatformParser();
		Table<Integer, Integer, Rock> platform = parser.parse(input.lines().toList());

		PlatformTilter platformTilter = new PlatformTilter();
		long load = platformTilter.tiltNorth(platform);
		System.out.println(load);
	}

}
