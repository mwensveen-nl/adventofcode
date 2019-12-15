package nl.mwensveen.adventofcode.year_2019.day_14;

import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class SpaceStoichiometrySolution extends AbstractTimedSolution {

    @Override
    protected void part1() {
        FuelProductionCalculator fuelProductionCalculator = new FuelProductionCalculator();
        int ore = fuelProductionCalculator.caluclateOre(FileReadHelper.readLines("Day14.txt"));
        System.out.println("Required Ore: " + ore);
    }

    @Override
    protected void part2() {
        FuelProductionCalculator fuelProductionCalculator = new FuelProductionCalculator();
        int fuel = fuelProductionCalculator.caluclateFuel(FileReadHelper.readLines("Day14.txt"), 1000000000000L);
        System.out.println("Produced fuel: " + fuel);
    }

    public static void main(String[] args) {
        SpaceStoichiometrySolution solution = new SpaceStoichiometrySolution();
        solution.run();
    }

}
