package nl.mwensveen.adventofcode.year_2022.day_09;

import java.util.List;

import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class RopeBridgeSolution extends AbstractTimedSolution {

	private List<String> input;
	private RopeMover ropeMover = new RopeMover();

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("day09.txt");
	}

	@Override
	protected void part1() {
		Rope rope = new Rope(2);
		Rope result = ropeMover.multipleMoveRope(rope, input);
		System.out.println("Number of positions the tail of the rope with 2 knots visited at least once: " + result.sizeTPositions());
	}

	@Override
	protected void part2() {
		Rope rope = new Rope(10);
		Rope result = ropeMover.multipleMoveRope(rope, input);
		System.out.println("Number of positions the tail of the rope with 10 knots visited at least once: " + result.sizeTPositions());
	}

	public static void main(String[] args) {
		new RopeBridgeSolution().run();
	}

}
