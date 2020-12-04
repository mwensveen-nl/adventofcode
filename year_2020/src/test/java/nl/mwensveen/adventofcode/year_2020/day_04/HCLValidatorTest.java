package nl.mwensveen.adventofcode.year_2020.day_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HCLValidatorTest {

    @Test
    public void testValidate() throws Exception {
        assertTrue(HCLValidator.validate("#1290af"));
        assertTrue(HCLValidator.validate("#abcdef"));
        assertTrue(HCLValidator.validate("#123789"));
        assertFalse(HCLValidator.validate("123456"));
        assertFalse(HCLValidator.validate("#12345"));
        assertFalse(HCLValidator.validate("#1234567"));
        assertFalse(HCLValidator.validate("$123456"));
    }

}
