package nl.mwensveen.adventofcode.year_2020.day_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class HGTValidatorTest {

    @Test
    public void testValidateCM() throws Exception {
        assertTrue(HGTValidator.validate("180cm"));
        assertTrue(HGTValidator.validate("150cm"));
        assertTrue(HGTValidator.validate("193cm"));
        assertFalse(HGTValidator.validate("149cm"));
        assertFalse(HGTValidator.validate("194cm"));
        assertFalse(HGTValidator.validate("1500cm"));
        assertFalse(HGTValidator.validate("1931cm"));
    }

    @Test
    public void testValidateIN() throws Exception {
        assertTrue(HGTValidator.validate("70in"));
        assertTrue(HGTValidator.validate("59in"));
        assertTrue(HGTValidator.validate("76in"));
        assertFalse(HGTValidator.validate("58in"));
        assertFalse(HGTValidator.validate("77in"));
        assertFalse(HGTValidator.validate("7in"));
        assertFalse(HGTValidator.validate("193in"));
    }

    @Test
    public void testValidate() throws Exception {
        assertFalse(HGTValidator.validate("70cn"));
    }

}
