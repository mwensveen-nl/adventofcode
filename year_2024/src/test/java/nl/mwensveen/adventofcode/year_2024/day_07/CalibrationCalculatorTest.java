package nl.mwensveen.adventofcode.year_2024.day_07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalibrationCalculatorTest {

    private String input = """
            190: 10 19
            3267: 81 40 27
            83: 17 5
            156: 15 6
            7290: 6 8 6 15
            161011: 16 10 13
            192: 17 8 14
            21037: 9 7 18 13
            292: 11 6 16 20
                        """;

    @Test
    public void testFindCalibrations() {
        CalibrationCalculator calculator = new CalibrationCalculator();
        long result = calculator.findCalibrations(input.lines().toList());
        assertEquals(3749, result);
    }

    @Test
    public void testFindCalibrationsWithConcat() {
        CalibrationCalculator calculator = new CalibrationCalculator();
        long result = calculator.findCalibrationsWithConcat(input.lines().toList());
        assertEquals(11387, result);
    }

}
