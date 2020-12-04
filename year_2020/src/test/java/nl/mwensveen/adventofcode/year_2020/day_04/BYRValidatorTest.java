package nl.mwensveen.adventofcode.year_2020.day_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BYRValidatorTest {

    @Test
    public void testValidate() throws Exception {
        assertTrue(BYRValidator.validate("2000"));
        assertTrue(BYRValidator.validate("1920"));
        assertTrue(BYRValidator.validate("2002"));
        assertFalse(BYRValidator.validate("1919"));
        assertFalse(BYRValidator.validate("2003"));
        assertFalse(BYRValidator.validate("999"));
        assertFalse(BYRValidator.validate("20201"));
    }

}
