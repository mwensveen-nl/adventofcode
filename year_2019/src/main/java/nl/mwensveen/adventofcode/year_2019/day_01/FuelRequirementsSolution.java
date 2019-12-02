package nl.mwensveen.adventofcode.year_2019.day_01;

import java.util.List;

import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class FuelRequirementsSolution {
	public static void main(String[] args) {
		List<String> input = FileReadHelper.readLines("Day01.txt");

		FuelRequirementsCalculator calculator = new FuelRequirementsCalculator();
		int fuelReququirements = calculator.calculateFuelReququirementsForModules(input);
		System.out.println("FuelReququirements part one: " + fuelReququirements);

		fuelReququirements = calculator.calculateFuelReququirementsForModulesAndFuel(input);
		System.out.println("FuelReququirements part two: " + fuelReququirements);
	}
}
