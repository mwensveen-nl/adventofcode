package nl.mwensveen.adventofcode.year_2019.day_01;

import java.util.List;

public class FuelRequirementsCalculator {

	int calculateFuelReququirementsForModules(List<String> input) {
		return input.stream().mapToInt(Integer::parseInt).map(FuelForMasCalculator::calculate).sum();
	}

	public Integer calculateFuelReququirementsForModulesAndFuel(List<String> input) {
		return input.stream().mapToInt(Integer::parseInt).map(FuelForMasCalculator::calculateIncFuel).sum();
	}

}
