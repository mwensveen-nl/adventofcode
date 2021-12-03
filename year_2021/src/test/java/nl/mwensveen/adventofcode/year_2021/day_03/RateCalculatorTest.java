package nl.mwensveen.adventofcode.year_2021.day_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RateCalculatorTest {

	@Test
	public void testCalculateRates() {
		List<String> input = Arrays.asList("00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100",
				"10000", "11001", "00010", "01010");
		RateCalculator calculator = new RateCalculator();
		int result = calculator.calculateRates(input);
		assertEquals(198, result);
	}

}
