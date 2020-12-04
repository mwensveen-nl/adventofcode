package nl.mwensveen.adventofcode.year_2020.day_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ECLValidatorTest {

    @Test
    public void testValidate() throws Exception {
        assertTrue(ECLValidator.validate("amb"));
        assertTrue(ECLValidator.validate("blu"));
        assertTrue(ECLValidator.validate("brn"));
        assertTrue(ECLValidator.validate("gry"));
        assertTrue(ECLValidator.validate("grn"));
        assertTrue(ECLValidator.validate("hzl"));
        assertTrue(ECLValidator.validate("oth"));

        assertFalse(ECLValidator.validate("abc"));
        assertFalse(ECLValidator.validate("ambamb"));
        assertFalse(ECLValidator.validate("am"));
        assertFalse(ECLValidator.validate("blubrn"));
    }

}
