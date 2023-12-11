package nl.mwensveen.adventofcode.year_2023.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

class DistanceCalculatorTest {
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
	public void testCalculate() {
		Table<Integer, Integer, String> galaxies = new GalaxiesParser().parseGalaxies(input.lines().toList());
		long distances = new DistanceCalculator(2).calculate(galaxies);
		assertEquals(374, distances);
	}

	@Test
	public void testCalculate10() {
		Table<Integer, Integer, String> galaxies = new GalaxiesParser().parseGalaxies(input.lines().toList());
		long distances = new DistanceCalculator(10).calculate(galaxies);
		assertEquals(1030, distances);
	}

}
