package nl.mwensveen.adventofcode.year_2025.day_01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class PasswordCalculatorTest {
    private String input = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
                    """;

    @Test
    public void calculate() {
        List<Rotation> rotations = input.lines().map(Rotation::new).toList();
        PasswordCalculator pc = new PasswordCalculator();
        long pw = pc.calculate(rotations);
        assertEquals(3, pw);
    }

    @Test
    public void calculateNewMethod() {
        List<Rotation> rotations = input.lines().map(Rotation::new).toList();
        PasswordCalculator pc = new PasswordCalculator();
        long pw = pc.calculateNewMethod(rotations);
        assertEquals(6, pw);
    }

}
