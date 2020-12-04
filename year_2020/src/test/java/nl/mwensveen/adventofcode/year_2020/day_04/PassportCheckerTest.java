package nl.mwensveen.adventofcode.year_2020.day_04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PassportCheckerTest {

    private PassportChecker passportChecker = new PassportChecker();

    @Test
        public void testCheckAllFields() throws Exception {
            Passport passport = new Passport();
            passport.addData(PassportField.ECL, "gry").addData(PassportField.PID, "860033327").addData(PassportField.EYR, "2020")
                    .addData(PassportField.HCL, "#fffffd").addData(PassportField.BYR, "1937").addData(PassportField.IYR, "2017")
                    .addData(PassportField.CID, "147").addData(PassportField.HGT, "183cm");
            assertTrue(passportChecker.checkAllFields(passport));
        }

    @Test
        public void testCheckAllFieldsMissingOptional() throws Exception {
            Passport passport = new Passport();
            passport.addData(PassportField.HCL, "#ae17e1").addData(PassportField.IYR, "2013").addData(PassportField.EYR, "2024")
                    .addData(PassportField.ECL, "brn").addData(PassportField.PID, "760753108").addData(PassportField.BYR, "1931")
                    .addData(PassportField.HGT, "179cm");
            assertTrue(passportChecker.checkAllFields(passport));
        }

    @Test
    public void testCheckInvalid() throws Exception {
        Passport passport = new Passport();
        passport.addData(PassportField.IYR, "2013").addData(PassportField.ECL, "amb").addData(PassportField.CID, "350").addData(PassportField.EYR, "2023")
                .addData(PassportField.PID, "028048884").addData(PassportField.HCL, "#cfa07d").addData(PassportField.BYR, "1929");
        assertFalse(passportChecker.checkAllFields(passport));
    }

}
