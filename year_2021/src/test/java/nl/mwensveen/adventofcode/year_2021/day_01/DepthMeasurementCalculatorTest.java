package nl.mwensveen.adventofcode.year_2021.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DepthMeasurementCalculatorTest {

	@Test
	public void testCalculateNumberOfIncreases() {
		List<Integer> input = Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
		DepthMeasurementCalculator calculator = new DepthMeasurementCalculator();
		long result = calculator.calculateNumberOfIncreases(input);
		assertEquals(7, result);
	}

}
