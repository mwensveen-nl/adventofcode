package nl.mwensveen.adventofcode.year_2022.day_09;

import java.util.HashSet;
import java.util.List;

import nl.mwensveen.adventofcode.year_2022.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2022.FileReadHelper;

public class RopeBridgeSolution extends AbstractTimedSolution {

	private List<String> input;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("day09.txt");
	}

	@Override
	protected void part1() {
		RopeMover ropeMover = new RopeMover();
		Rope rope = new Rope(new Position(0, 0), new Position(0, 0), new HashSet<>());
		Rope result = ropeMover.multipleMoveRope(rope, input);
		System.out.println("Number of positions the tail of the rope visited at least once: " + result.tPositions().size());
	}

	@Override
	protected void part2() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new RopeBridgeSolution().run();
	}

}
