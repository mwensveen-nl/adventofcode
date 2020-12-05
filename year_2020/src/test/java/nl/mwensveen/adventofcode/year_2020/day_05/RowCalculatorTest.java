package nl.mwensveen.adventofcode.year_2020.day_05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RowCalculatorTest {

    @Test
    public void testDetermineRow() throws Exception {
        RowCalculator calculator = new RowCalculator();
        assertEquals(44, calculator.determineRow("FBFBBFF"));
        assertEquals(45, calculator.determineRow("FBFBBFB"));
    }

}
