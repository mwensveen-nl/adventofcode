package nl.mwensveen.adventofcode.year_2020.day_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HCLValidator {

    public static boolean validate(String value) {
        String heightPattern = "^#[0-9a-f]{6}$";
        Pattern pattern = Pattern.compile(heightPattern);
        Matcher m = pattern.matcher(value);
        return m.matches();
    }

}
