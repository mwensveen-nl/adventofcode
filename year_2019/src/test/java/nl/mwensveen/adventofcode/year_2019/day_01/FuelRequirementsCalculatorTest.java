package nl.mwensveen.adventofcode.year_2019.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class FuelRequirementsCalculatorTest {

	@Test
	public void testCalculateFuelReququirementsForModules() throws Exception {
		List<String> input = Arrays.asList("12", "14", "1969", "100756");
		FuelRequirementsCalculator calculator = new FuelRequirementsCalculator();
		assertEquals(2 + 2 + 654 + 33583, calculator.calculateFuelReququirementsForModules(input));
	}

	@Test
	public void testCalculateFuelReququirementsForModulesAndFuelOneModule() throws Exception {
		List<String> input = Arrays.asList("14", "1969", "100756");
		FuelRequirementsCalculator calculator = new FuelRequirementsCalculator();
		assertEquals(2 + 966 + 50346, calculator.calculateFuelReququirementsForModulesAndFuel(input));
	}

}
