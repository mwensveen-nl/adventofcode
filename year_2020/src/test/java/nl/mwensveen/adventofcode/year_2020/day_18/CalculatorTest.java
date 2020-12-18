package nl.mwensveen.adventofcode.year_2020.day_18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        Calculator calculator = new Calculator();
        Long result = calculator.calculate("1 + 2 * 3 + 4 * 5 + 6");
        assertEquals(71, result);
    }

    @Test
    public void testCalculate2() throws Exception {
        Calculator calculator = new Calculator();
        Long result = calculator.calculate("2 * 3 + (4 * 5)");
        assertEquals(26, result);
    }

    @Test
    public void testCalculate3() throws Exception {
        Calculator calculator = new Calculator();
        Long result = calculator.calculate("5 + (8 * 3 + 9 + 3 * 4 * 3)");
        assertEquals(437, result);
    }

    @Test
    public void testCalculate4() throws Exception {
        Calculator calculator = new Calculator();
        Long result = calculator.calculate("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))");
        assertEquals(12240, result);
    }

    @Test
    public void testCalculate5() throws Exception {
        Calculator calculator = new Calculator();
        Long result = calculator.calculate("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2");
        assertEquals(13632, result);
    }

    @Test
    public void testCalculateAdvanced() throws Exception {
        Calculator calculator = new Calculator();
        Long result = calculator.calculateAdvanced("1 + (2 * 3) + (4 * (5 + 6))");
        assertEquals(51, result);
    }

    @Test
    public void testCalculateAdvanced2() throws Exception {
        Calculator calculator = new Calculator();
        Long result = calculator.calculateAdvanced("2 * 3 + (4 * 5)");
        assertEquals(46, result);
    }

    @Test
    public void testCalculateAdvanced3() throws Exception {
        Calculator calculator = new Calculator();
        Long result = calculator.calculateAdvanced("5 + (8 * 3 + 9 + 3 * 4 * 3)");
        assertEquals(1445, result);
    }

    @Test
    public void testCalculateAdvanced4() throws Exception {
        Calculator calculator = new Calculator();
        Long result = calculator.calculateAdvanced("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))");
        assertEquals(669060, result);
    }

    @Test
    public void testCalculateAdvanced5() throws Exception {
        Calculator calculator = new Calculator();
        Long result = calculator.calculateAdvanced("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2");
        assertEquals(23340, result);
    }
}
