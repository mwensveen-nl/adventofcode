package nl.mwensveen.adventofcode.year_2020.day_04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HGTValidator {

    public static boolean validate(String value) {
        String heightPattern = "^([0-9]{2,3})(in|cm)$";
        Pattern pattern = Pattern.compile(heightPattern);
        Matcher m = pattern.matcher(value);
        if (m.matches()) {
            if (m.group(2).equals("in")) {
                return "59".compareTo(m.group(1)) <= 0 && "76".compareTo(m.group(1)) >= 0;
            } else {
                return "150".compareTo(m.group(1)) <= 0 && "193".compareTo(m.group(1)) >= 0;
            }
        }
        return false;
    }

}
