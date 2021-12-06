package nl.mwensveen.adventofcode.year_2021.day_03;

import java.util.List;

import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class BinaryDiagnosticSolution extends AbstractTimedSolution {

	private List<String> input;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("day_03.txt");
	}

	@Override
	protected void part1() {
		RateCalculator calculator = new RateCalculator();
		int result = calculator.calculatePowerConsumption(input);
		System.out.println("Power consumption of the submarine: " + result);
	}

	@Override
	protected void part2() {
		RateCalculator calculator = new RateCalculator();
		int result = calculator.calculateLifeSupportRating(input);
		System.out.println("Life Support Rating of the submarine: " + result);
	}

	public static void main(String[] args) {
		new BinaryDiagnosticSolution().run();
	}

}
