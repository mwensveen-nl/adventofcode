package nl.mwensveen.adventofcode.year_2019.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FuelForMasCalculatorTest {

	@Test
	public void testCalculate() throws Exception {
		assertEquals(2, FuelForMasCalculator.calculate(12));
		assertEquals(2, FuelForMasCalculator.calculate(14));
		assertEquals(654, FuelForMasCalculator.calculate(1969));
		assertEquals(33583, FuelForMasCalculator.calculate(100756));
	}

	@Test
	public void testCalculateIncFuel() throws Exception {
		assertEquals(2, FuelForMasCalculator.calculateIncFuel(14));
		assertEquals(966, FuelForMasCalculator.calculateIncFuel(1969));
		assertEquals(50346, FuelForMasCalculator.calculateIncFuel(100756));
	}

}
