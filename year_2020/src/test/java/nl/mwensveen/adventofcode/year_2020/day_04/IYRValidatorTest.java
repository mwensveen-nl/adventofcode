package nl.mwensveen.adventofcode.year_2020.day_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IYRValidatorTest {

    @Test
    public void testValidate() throws Exception {
        assertTrue(IYRValidator.validate("2015"));
        assertTrue(IYRValidator.validate("2010"));
        assertTrue(IYRValidator.validate("2020"));
        assertFalse(IYRValidator.validate("2009"));
        assertFalse(IYRValidator.validate("2021"));
        assertFalse(IYRValidator.validate("999"));
        assertFalse(IYRValidator.validate("20210"));
    }

}
