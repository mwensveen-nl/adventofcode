package nl.mwensveen.adventofcode.year_2023.day_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

public class PartDiscovererTest {
	String input = """
			467..114..
			...*......
			..35..633.
			......#...
			617*......
			.....+.58.
			..592.....
			......755.
			...$.*....
			.664.598..
						""";

	@Test
	public void test() {
		EngineSchematicParser parser = new EngineSchematicParser();
		Table<Integer, Integer, String> table = parser.parse(input.lines().toList());

		PartDiscoverer discoverer = new PartDiscoverer();
		List<Integer> discoverParts = discoverer.discoverParts(table);

		assertEquals(4361, discoverer.sumParts(discoverParts));
	}

}
