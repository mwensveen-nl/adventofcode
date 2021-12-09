package nl.mwensveen.adventofcode.year_2021.day_08;

import java.util.List;

import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class SevenSegmentSearchSolution extends AbstractTimedSolution {

	private List<String> input;

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("day_08.txt");
	}

	@Override
	protected void part1() {
		DigitCounter digitCounter = new DigitCounter();
		long result = digitCounter.countKnownDigits(input);
		System.out.println("How many times in the output values, the digits 1, 4, 7, or 8 appear :" + result);

	}

	@Override
	protected void part2() {
		SignalToDigitConverter signalToDigitConverter = new SignalToDigitConverter();
		long result = signalToDigitConverter.convert(input);
		System.out.println("Result of all added output values: " + result);
	}

	public static void main(String[] args) {
		new SevenSegmentSearchSolution().run();
	}

}
