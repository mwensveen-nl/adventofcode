package nl.mwensveen.adventofcode.year_2023.day_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

public class GearDiscovererTest {
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
	public void testDiscoverGears() {
		EngineSchematicParser parser = new EngineSchematicParser();
		Table<Integer, Integer, String> table = parser.parse(input.lines().toList());
		GearDiscoverer gearDiscoverer = new GearDiscoverer();
		Long gearRatios = gearDiscoverer.discoverGears(table);
		assertEquals(467835L, gearRatios);
	}

}
