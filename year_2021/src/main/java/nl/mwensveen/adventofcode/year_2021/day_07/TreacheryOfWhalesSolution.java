package nl.mwensveen.adventofcode.year_2021.day_07;

import java.util.List;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class TreacheryOfWhalesSolution extends AbstractTimedSolution {

    private List<Integer> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsIntegers("day_07.txt");
    }

    @Override
    protected void part1() {
        FuelCalculator fuelCalculator = new FuelCalculator();
        Integer result = fuelCalculator.calculateMinimumFuel(input);
        System.out.println("Amount of fuel crabs must spend to align to horizontal position: " + result);
    }

    @Override
    protected void part2() {
        FuelCalculator fuelCalculator = new FuelCalculator();
        long result = fuelCalculator.calculateMinimumFuelWithIncreasingExpense(input);
        System.out.println("Amount of fuel crabs must spend to align to horizontal position with increasing fuel expense: " + result);
    }

    public static void main(String[] args) {
        new TreacheryOfWhalesSolution().run();
    }

}
