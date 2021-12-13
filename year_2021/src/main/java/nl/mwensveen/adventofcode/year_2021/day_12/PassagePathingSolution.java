package nl.mwensveen.adventofcode.year_2021.day_12;

import java.util.List;
import java.util.Map;

import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class PassagePathingSolution extends AbstractTimedSolution {

	private List<String> input;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("day_12.txt");
	}

	@Override
	protected void part1() {
		CaveParser caveParser = new CaveParser();
		Map<String, List<String>> caves = caveParser.parseCaves(input);

		CaveWalker caveWalker = new CaveWalker();
		Integer result = caveWalker.findAllPaths(caves, false);

		System.out.println("Number of paths through this cave system are there that visit small caves at most once: " + result);

	}

	@Override
	protected void part2() {
		CaveParser caveParser = new CaveParser();
		Map<String, List<String>> caves = caveParser.parseCaves(input);

		CaveWalker caveWalker = new CaveWalker();
		Integer result = caveWalker.findAllPaths(caves, true);

		System.out.println("Number of paths through this cave system are there that visit small caves at most once exept for 1 cave: " + result);

	}

	public static void main(String[] args) {
		new PassagePathingSolution().run();
	}

}
