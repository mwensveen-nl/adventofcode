package nl.mwensveen.adventofcode.year_2020.day_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PIDValidatorTest {

    @Test
    public void testValidate() throws Exception {
        assertTrue(PIDValidator.validate("123456789"));
        assertTrue(PIDValidator.validate("000000000"));
        assertFalse(PIDValidator.validate("00000000"));
        assertFalse(PIDValidator.validate("12345678"));
        assertFalse(PIDValidator.validate("1234567898"));
        assertFalse(PIDValidator.validate("abcdefgei"));
    }

}
