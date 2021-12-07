package nl.mwensveen.adventofcode.year_2021.day_07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FuelCalculatorTest {

    @Test
    public void testCalculateMinimumFuel() {
        List<Integer> input = Arrays.asList(16, 1, 2, 0, 4, 2, 7, 1, 2, 14);
        FuelCalculator fuelCalculator = new FuelCalculator();
        Integer result = fuelCalculator.calculateMinimumFuel(input);
        assertEquals(37, result);
    }

    @Test
    public void testCalculateMinimumFuelWithIncreasingExpense() {
        List<Integer> input = Arrays.asList(16, 1, 2, 0, 4, 2, 7, 1, 2, 14);
        FuelCalculator fuelCalculator = new FuelCalculator();
        long result = fuelCalculator.calculateMinimumFuelWithIncreasingExpense(input);
        assertEquals(168, result);
    }

}
