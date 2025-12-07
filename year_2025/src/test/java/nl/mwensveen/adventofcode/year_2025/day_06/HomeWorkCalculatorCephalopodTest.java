package nl.mwensveen.adventofcode.year_2025.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;

class HomeWorkCalculatorCephalopodTest {

    private String input = """
            123 328  51 64
             45 64  387 23
              6 98  215 314
            *   +   *   +
                    """;

    @Test
    public void calculate() {
        List<List<String>> worksheet = new HomeWorksheetParser().parseCephalopod(input.lines().toList());

        BigInteger result = new HomeWorkCalculatorCephalopod().calculate(worksheet);
        assertEquals(3263827L, result.longValue());
    }
}
