package nl.mwensveen.adventofcode.year_2025.day_06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class HomeWorkCalculatorTest {
    private String input = """
            123 328  51 64
             45 64  387 23
              6 98  215 314
            *   +   *   +
                    """;

    @Test
    public void calculate() {
        Table<Integer, Integer, String> worksheet = new HomeWorksheetParser().parse(input.lines().toList());

        BigInteger result = new HomeWorkCalculator().calculate(worksheet);
        assertEquals(4277556L, result.longValue());
    }

}
