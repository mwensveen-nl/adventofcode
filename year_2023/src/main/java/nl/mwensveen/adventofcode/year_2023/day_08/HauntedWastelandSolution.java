package nl.mwensveen.adventofcode.year_2023.day_08;

import java.util.List;

import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class HauntedWastelandSolution extends AbstractTimedSolution {

	private List<String> input;
	private Instructions instructions;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("Day_07.txt");
		instructions = new InstructionsParser().parse(input);
	}

	@Override
	protected void part1() {
		long count = new NetworkNavigator().navigate(instructions);
		System.out.println("Number of steps that are required to reach ZZZ: " + count);
	}

	@Override
	protected void part2() {
		long count = new NetworkNavigator().navigateMultipleNodes(instructions);
		System.out.println("Number of steps that are required to reach all nodes ending with Z: " + count);
	}

	public static void main(String[] args) {
		new HauntedWastelandSolution().run();
	}

}
