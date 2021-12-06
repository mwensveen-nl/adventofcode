package nl.mwensveen.adventofcode.year_2021.day_06;

import java.util.List;

import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class LanternfishSolution extends AbstractTimedSolution {

	private List<Integer> input;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsIntegers("day_06.txt");
	}

	@Override
	protected void part1() {
		LanternfishSimulator lanternfishSimulator = new LanternfishSimulator();
		long result = lanternfishSimulator.simulate(input, 80);
		System.out.println("Number of lanternfish after 80 days: " + result);
	}

	@Override
	protected void part2() {
		LanternfishSimulator lanternfishSimulator = new LanternfishSimulator();
		long result = lanternfishSimulator.simulate(input, 256);
		System.out.println("Number of lanternfish after 256 days: " + result);
	}

	public static void main(String[] args) {
		new LanternfishSolution().run();
	}

}
