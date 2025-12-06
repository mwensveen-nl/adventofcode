package nl.mwensveen.adventofcode.year_2025.day_03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class MaxJoltageDetectorTest {
    private String input = """
            987654321111111
            811111111111119
            234234234234278
            818181911112111
                    """;

    @Test
    public void maxJoltage() {
        MaxJoltageDetector mjd = new MaxJoltageDetector();
        BigInteger joultage = mjd.detect(input.lines().toList());
        assertEquals(BigInteger.valueOf(357L), joultage);
    }

}
