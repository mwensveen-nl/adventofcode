package nl.mwensveen.adventofcode.year_2020.day_04;

public class PIDValidator {

    public static boolean validate(String value) {
        String yearPattern = "^[0-9]{9}$";
        return value.matches(yearPattern);
    }

}
