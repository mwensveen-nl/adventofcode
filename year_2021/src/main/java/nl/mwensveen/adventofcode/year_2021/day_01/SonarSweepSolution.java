package nl.mwensveen.adventofcode.year_2021.day_01;

import java.util.List;

import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class SonarSweepSolution extends AbstractTimedSolution {

	private List<Integer> input;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsIntegers("day_01.txt");
	}

	@Override
	protected void part1() {
		DepthMeasurementCalculator calculator = new DepthMeasurementCalculator();
		long result = calculator.calculateNumberOfIncreases(input);
		System.out.println("number of increases " + result);

	}

	@Override
	protected void part2() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		SonarSweepSolution solution = new SonarSweepSolution();
		solution.run();
	}

}
