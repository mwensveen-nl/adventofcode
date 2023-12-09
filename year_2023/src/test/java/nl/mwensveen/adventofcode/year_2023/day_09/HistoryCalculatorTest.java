package nl.mwensveen.adventofcode.year_2023.day_09;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoryCalculatorTest {

    @Test
    public void testCalculate() {
        HistoryCalculator calculator = new HistoryCalculator();
        String[] strings = "0 3 6 9 12 15".split(" ");
        List<Integer> list = Arrays.asList(strings).stream().map(Integer::valueOf).toList();
        int result = calculator.calculate(list, false);
        assertEquals(18, result);
    }

    @Test
    public void testCalculate2() {
        HistoryCalculator calculator = new HistoryCalculator();
        String[] strings = "1 3 6 10 15 21".split(" ");
        List<Integer> list = Arrays.asList(strings).stream().map(Integer::valueOf).toList();
        int result = calculator.calculate(list, false);
        assertEquals(28, result);
    }

    @Test
    public void testCalculate3() {
        HistoryCalculator calculator = new HistoryCalculator();
        String[] strings = "10 13 16 21 30 45".split(" ");
        List<Integer> list = Arrays.asList(strings).stream().map(Integer::valueOf).toList();
        int result = calculator.calculate(list, false);
        assertEquals(68, result);
    }

    @Test
    public void testCalculatePrev3() {
        HistoryCalculator calculator = new HistoryCalculator();
        String[] strings = "10 13 16 21 30 45".split(" ");
        List<Integer> list = Arrays.asList(strings).stream().map(Integer::valueOf).toList();
        int result = calculator.calculate(list, true);
        assertEquals(5, result);
    }

}
