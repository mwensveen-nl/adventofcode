package nl.mwensveen.adventofcode.year_2023.day_13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

class ReflectionFinderTest {
	private String input = """
			#.##..##.
			..#.##.#.
			##......#
			##......#
			..#.##.#.
			..##..##.
			#.#.##.#.

			#...##..#
			#....#..#
			..##..###
			#####.##.
			#####.##.
			..##..###
			#....#..#
			        """;
	private String input2 = """
			..##.##.#....
			.##########..
			.##########..
			..##.##.#.#..
			.######..##..
			###..#.####..
			#...#.#..##..
			.#.#...#..###
			#.##.#.####..
			..#####...###
			..#..##....##
			.#.####.##...
			#.########.##
			            """;
	private String input3 = """
			.#..###..##.#
			.#..###..##.#
			##..#.###.###
			#.##...#..##.
			..####...#..#
			##..#..#.#...
			###..#.....##
			....##.##..#.
			....##.#...#.
						""";

	private String input4 = """
			..#....##.#.##.
			...###...###..#
			#...##..####..#
			#...##..####..#
			...###...#.#..#
			..#....##.#.##.
			.#.......###..#
			##.........#..#
			..##.###...#..#
			.##...#........
			####..##.#.....
			....#.#.###....
			....#.###..####
			.##....##.##..#
			#..##.#..###..#
			.#...#######..#
			#.####.#####..#
						""";

	@Test
	public void testFind() {
		PatternParser parser = new PatternParser();
		List<Table<Integer, Integer, Symbol>> list = parser.parse(input.lines().toList());

		ReflectionFinder reflectionFinder = new ReflectionFinder();
		int i = reflectionFinder.find(list.get(0));
		assertEquals(5, i);
	}

	@Test
	public void testFind2() {
		PatternParser parser = new PatternParser();
		List<Table<Integer, Integer, Symbol>> list = parser.parse(input.lines().toList());

		ReflectionFinder reflectionFinder = new ReflectionFinder();
		int i = reflectionFinder.find(list.get(1));
		assertEquals(400, i);
	}

	@Test
	public void testFind3() {
		PatternParser parser = new PatternParser();
		List<Table<Integer, Integer, Symbol>> list = parser.parse(input2.lines().toList());

		ReflectionFinder reflectionFinder = new ReflectionFinder();
		int i = reflectionFinder.find(list.get(0));
		assertEquals(12, i);
	}

	@Test
	public void testFindWithSmudge() {
		PatternParser parser = new PatternParser();
		List<Table<Integer, Integer, Symbol>> list = parser.parse(input.lines().toList());

		ReflectionFinder reflectionFinder = new ReflectionFinder();
		int i = reflectionFinder.findWithSmudge(list.get(0));
		assertEquals(300, i);
	}

	@Test
	public void testFind2WithSmudge() {
		PatternParser parser = new PatternParser();
		List<Table<Integer, Integer, Symbol>> list = parser.parse(input.lines().toList());

		ReflectionFinder reflectionFinder = new ReflectionFinder();
		int i = reflectionFinder.findWithSmudge(list.get(1));
		assertEquals(100, i);
	}

	@Test
	public void testFind4WithSmudge() {
		PatternParser parser = new PatternParser();
		List<Table<Integer, Integer, Symbol>> list = parser.parse(input3.lines().toList());

		ReflectionFinder reflectionFinder = new ReflectionFinder();
		int i = reflectionFinder.findWithSmudge(list.get(0));
		assertEquals(800, i);
	}

	@Test
	public void testFind5WithSmudge() {
		PatternParser parser = new PatternParser();
		List<Table<Integer, Integer, Symbol>> list = parser.parse(input4.lines().toList());

		ReflectionFinder reflectionFinder = new ReflectionFinder();
		int i = reflectionFinder.findWithSmudge(list.get(0));
		assertEquals(300, i);
	}
}
