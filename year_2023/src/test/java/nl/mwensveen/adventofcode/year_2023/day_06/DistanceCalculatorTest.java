package nl.mwensveen.adventofcode.year_2023.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DistanceCalculatorTest {

	@Test
	public void testCalculate() {
		DistanceCalculator distanceCalculator = new DistanceCalculator();
		long distance = distanceCalculator.calculate(7, 2);
		assertEquals(10, distance);

		distance = distanceCalculator.calculate(7, 7);
		assertEquals(0, distance);
	}

}
