package nl.mwensveen.adventofcode.year_2021.day_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PositionCalculatorTest {

    @Test
    public void testCalculateSimplePostion() {
        List<String> input = Arrays.asList("forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2");
        PositionCalculator calculator = new PositionCalculator();
        int result = calculator.calculateSimplePostion(input);
        assertEquals(150, result);
    }

    @Test
    public void testCalculatePostionWithAim() {
        List<String> input = Arrays.asList("forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2");
        PositionCalculator calculator = new PositionCalculator();
        int result = calculator.calculatePostionWithAim(input);
        assertEquals(900, result);
    }

}
