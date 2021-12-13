package nl.mwensveen.adventofcode.year_2021.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CaveParserTest {

	@Test
	public void testParseCaves() {
		List<String> input = Arrays.asList("start-A",
				"start-b",
				"A-c",
				"A-b",
				"b-d",
				"A-end",
				"b-end");
		CaveParser caveParser = new CaveParser();
		Map<String, List<String>> caves = caveParser.parseCaves(input);
		assertEquals(6, caves.keySet().size());

		assertEquals(2, caves.get("start").size());
		assertTrue(caves.get("start").contains("A"));
		assertTrue(caves.get("start").contains("b"));

		assertEquals(1, caves.get("c").size());
		assertTrue(caves.get("c").contains("A"));

		assertEquals(4, caves.get("A").size());
		assertTrue(caves.get("A").contains("c"));
		assertTrue(caves.get("A").contains("start"));
		assertTrue(caves.get("A").contains("b"));
		assertTrue(caves.get("A").contains("end"));
	}

}
