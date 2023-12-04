package nl.mwensveen.adventofcode.year_2023.day_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Table;

public class EngineSchematicParserTest {
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
	public void testParse() {
		EngineSchematicParser parser = new EngineSchematicParser();
		Table<Integer, Integer, String> table = parser.parse(input.lines().toList());
		assertEquals(10, table.rowMap().size());
		assertEquals("4", table.get(0, 0));
		assertEquals(".", table.get(9, 9));
		assertEquals("3", table.get(2, 8));
	}

}
