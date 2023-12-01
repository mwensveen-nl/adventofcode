package nl.mwensveen.adventofcode.year_2023.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalibrationRecovererTest {
	private String input = """
			1abc2
			pqr3stu8vwx
			a1b2c3d4e5f
			treb7uchet
			""";

	private String input2 = """
			two1nine
			eightwothree
			abcone2threexyz
			xtwone3four
			4nineeightseven2
			zoneight234
			7pqrstsixteen
						""";

	@Test
	public void testCalculateSumOfCalibrations() {
		CalibrationRecoverer calibrationRecoverer = new CalibrationRecoverer();
		Long sumOfCalibrations = calibrationRecoverer.calculateSumOfCalibrations(input.lines().toList());
		assertEquals(142, sumOfCalibrations);
	}

	@Test
	public void testCalculateSumOfCalibrationsWithWords() {
		CalibrationRecoverer calibrationRecoverer = new CalibrationRecoverer();
		Long sumOfCalibrations = calibrationRecoverer.calculateSumOfCalibrationsWithWords(input2.lines().toList());
		assertEquals(281, sumOfCalibrations);
	}

}
