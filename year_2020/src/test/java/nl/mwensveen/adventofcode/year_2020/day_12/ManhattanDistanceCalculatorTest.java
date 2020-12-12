package nl.mwensveen.adventofcode.year_2020.day_12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ManhattanDistanceCalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        ManhattanDistanceCalculator calculator = new ManhattanDistanceCalculator();
        assertEquals(25, calculator.calculate(0, 0, 8, 17));
    }

}
