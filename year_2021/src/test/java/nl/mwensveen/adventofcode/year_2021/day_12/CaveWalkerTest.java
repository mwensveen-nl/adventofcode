package nl.mwensveen.adventofcode.year_2021.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CaveWalkerTest {

	@Test
	public void testFindAllPaths1() {
		List<String> input = Arrays.asList("start-A",
				"start-b",
				"A-c",
				"A-b",
				"b-d",
				"A-end",
				"b-end");
		CaveParser caveParser = new CaveParser();
		Map<String, List<String>> caves = caveParser.parseCaves(input);

		CaveWalker caveWalker = new CaveWalker();
		Integer result = caveWalker.findAllPaths(caves, false);
		assertEquals(10, result);
	}

	@Test
	public void testFindAllPaths1Double() {
		List<String> input = Arrays.asList("start-A",
				"start-b",
				"A-c",
				"A-b",
				"b-d",
				"A-end",
				"b-end");
		CaveParser caveParser = new CaveParser();
		Map<String, List<String>> caves = caveParser.parseCaves(input);

		CaveWalker caveWalker = new CaveWalker();
		Integer result = caveWalker.findAllPaths(caves, true);
		assertEquals(36, result);
	}

	@Test
	public void testFindAllPaths3() {
		List<String> input = Arrays.asList(
				"fs-end",
				"he-DX",
				"fs-he",
				"start-DX",
				"pj-DX",
				"end-zg",
				"zg-sl",
				"zg-pj",
				"pj-he",
				"RW-he",
				"fs-DX",
				"pj-RW",
				"zg-RW",
				"start-pj",
				"he-WI",
				"zg-he",
				"pj-fs",
				"start-RW");
		CaveParser caveParser = new CaveParser();
		Map<String, List<String>> caves = caveParser.parseCaves(input);

		CaveWalker caveWalker = new CaveWalker();
		Integer result = caveWalker.findAllPaths(caves, false);
		assertEquals(226, result);
	}

	@Test
	public void testFindAllPaths3Double() {
		List<String> input = Arrays.asList(
				"fs-end",
				"he-DX",
				"fs-he",
				"start-DX",
				"pj-DX",
				"end-zg",
				"zg-sl",
				"zg-pj",
				"pj-he",
				"RW-he",
				"fs-DX",
				"pj-RW",
				"zg-RW",
				"start-pj",
				"he-WI",
				"zg-he",
				"pj-fs",
				"start-RW");
		CaveParser caveParser = new CaveParser();
		Map<String, List<String>> caves = caveParser.parseCaves(input);

		CaveWalker caveWalker = new CaveWalker();
		Integer result = caveWalker.findAllPaths(caves, true);
		assertEquals(3509, result);
	}

	@Test
	public void testFindAllPaths2() {
		List<String> input = Arrays.asList(
				"dc-end",
				"HN-start",
				"start-kj",
				"dc-start",
				"dc-HN",
				"LN-dc",
				"HN-end",
				"kj-sa",
				"kj-HN",
				"kj-dc");
		CaveParser caveParser = new CaveParser();
		Map<String, List<String>> caves = caveParser.parseCaves(input);

		CaveWalker caveWalker = new CaveWalker();
		Integer result = caveWalker.findAllPaths(caves, false);
		assertEquals(19, result);
	}

	@Test
	public void testFindAllPaths2Double() {
		List<String> input = Arrays.asList(
				"dc-end",
				"HN-start",
				"start-kj",
				"dc-start",
				"dc-HN",
				"LN-dc",
				"HN-end",
				"kj-sa",
				"kj-HN",
				"kj-dc");
		CaveParser caveParser = new CaveParser();
		Map<String, List<String>> caves = caveParser.parseCaves(input);

		CaveWalker caveWalker = new CaveWalker();
		Integer result = caveWalker.findAllPaths(caves, true);
		assertEquals(103, result);
	}

}
