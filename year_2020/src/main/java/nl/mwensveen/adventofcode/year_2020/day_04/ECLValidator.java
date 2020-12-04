package nl.mwensveen.adventofcode.year_2020.day_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ECLValidator {

    public static boolean validate(String value) {
        String heightPattern = "^(amb|blu|brn|gry|grn|hzl|oth)$";
        Pattern pattern = Pattern.compile(heightPattern);
        Matcher m = pattern.matcher(value);
        return m.matches();
    }

}
