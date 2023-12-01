package nl.mwensveen.adventofcode.year_2023.day_01;

import java.util.List;

import nl.mwensveen.adventofcode.year_2023.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2023.FileReadHelper;

public class TrebuchetSolution extends AbstractTimedSolution {

	private List<String> input;
	private CalibrationRecoverer calibrationRecoverer = new CalibrationRecoverer();

	@Override
	protected void init() {
		input = FileReadHelper.readLinesAsStrings("Day_01.txt");
	}

	@Override
	protected void part1() {
		Long sum = calibrationRecoverer.calculateSumOfCalibrations(input);
		System.out.println("The sum of all of the calibration values: " + sum);
	}

	@Override
	protected void part2() {
		Long sum = calibrationRecoverer.calculateSumOfCalibrationsWithWords(input);
		System.out.println("The sum of all of the calibration values including words: " + sum);
	}

	public static void main(String[] args) {
		new TrebuchetSolution().run();

	}

}
