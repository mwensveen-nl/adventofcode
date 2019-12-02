package nl.mwensveen.adventofcode.year_2019.day_01;

import java.util.List;

import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class FuelRequirementsSolution extends AbstractTimedSolution {
	public static void main(String[] args) {
		FuelRequirementsSolution solution = new FuelRequirementsSolution();
		solution.run();
	}

	@Override
	protected void part1() {
		List<String> input = FileReadHelper.readLines("Day01.txt");
		FuelRequirementsCalculator calculator = new FuelRequirementsCalculator();
		int fuelReququirements = calculator.calculateFuelReququirementsForModules(input);
		System.out.println("FuelReququirements part one: " + fuelReququirements);

	}

	@Override
	protected void part2() {
		List<String> input = FileReadHelper.readLines("Day01.txt");
		FuelRequirementsCalculator calculator = new FuelRequirementsCalculator();
		Integer fuelReququirements = calculator.calculateFuelReququirementsForModulesAndFuel(input);
		System.out.println("FuelReququirements part two: " + fuelReququirements);
	}
}
