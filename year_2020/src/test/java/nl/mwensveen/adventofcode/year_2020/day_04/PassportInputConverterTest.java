package nl.mwensveen.adventofcode.year_2020.day_04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PassportInputConverterTest {

    @Test
    public void testConvert() throws Exception {
        PassportInputConverter converter = new PassportInputConverter();
        List<String> input = Arrays.asList("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd", "byr:1937 iyr:2017 cid:147 hgt:183cm", "",
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884", "hcl:#cfa07d byr:1929");
        List<Passport> output = converter.convert(input);
        assertEquals(2, output.size());
        Passport passport = output.get(0);
        assertEquals(8, passport.getData().size());
        assertTrue(passport.containsFiels(PassportField.BYR));
        assertEquals("1937", passport.getData().get(PassportField.BYR));
        assertTrue(passport.containsFiels(PassportField.CID));
        assertEquals("gry", passport.getData().get(PassportField.ECL));
        assertTrue(passport.containsFiels(PassportField.ECL));
        assertTrue(passport.containsFiels(PassportField.EYR));
        assertTrue(passport.containsFiels(PassportField.HCL));
        assertTrue(passport.containsFiels(PassportField.HGT));
        assertTrue(passport.containsFiels(PassportField.IYR));
        assertTrue(passport.containsFiels(PassportField.PID));

        passport = output.get(1);
        assertEquals(7, passport.getData().size());
    }

}
