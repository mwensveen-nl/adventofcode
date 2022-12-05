package nl.mwensveen.adventofcode.year_2022.day_05;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class SupplyStacksSolution extends AbstractTimedSolution {

	private List<String> inputStacks;
	private List<String> inputMoves;

	@Override
	protected void init() {
		inputStacks = FileReadHelper.readLinesAsStrings("day05_a.txt");
		inputMoves = FileReadHelper.readLinesAsStrings("day05_b.txt");

	}

	@Override
	protected void part1() {
		StacksCreator stacksCreator = new StacksCreator();
		Map<Integer, Stack<String>> stacks = stacksCreator.createStacks(inputStacks);
		MoveCratesProcessor moveCratesProcessor = new MoveCratesProcessor();
		moveCratesProcessor.processInstructions(inputMoves, stacks);
		StacksInspector stacksInspector = new StacksInspector();
		String topCratesOfStacks = stacksInspector.inpectTopCratesOfStacks(stacks);

		System.out.println("After the rearrangement procedure completes, the crate that ends up on top of each stack: " + topCratesOfStacks);
	}

	@Override
	protected void part2() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new SupplyStacksSolution().run();
	}

}
