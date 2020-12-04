package nl.mwensveen.adventofcode.year_2020.day_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EYRValidatorTest {

    @Test
    public void testValidate() throws Exception {
        assertTrue(EYRValidator.validate("2025"));
        assertTrue(EYRValidator.validate("2020"));
        assertTrue(EYRValidator.validate("2030"));
        assertFalse(EYRValidator.validate("2019"));
        assertFalse(EYRValidator.validate("2031"));
        assertFalse(EYRValidator.validate("999"));
        assertFalse(EYRValidator.validate("20210"));
    }

}
