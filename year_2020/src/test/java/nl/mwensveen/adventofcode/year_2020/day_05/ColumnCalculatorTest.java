package nl.mwensveen.adventofcode.year_2020.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ColumnCalculatorTest {

    @Test
    public void testCalcColumn() throws Exception {
        ColumnCalculator calculator = new ColumnCalculator();
        assertEquals(5, calculator.determineColumn("RLR"));
        assertEquals(4, calculator.determineColumn("RLL"));
    }

}
