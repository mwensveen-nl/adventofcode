package nl.mwensveen.adventofcode.year_2020.day_04;

public class BYRValidator {

    public static boolean validate(String value) {
        String yearPattern = "^[0-9]{4}$";
        if (value.matches(yearPattern) && "1920".compareTo(value) <= 0 && "2002".compareTo(value) >= 0) {
            return true;
        }
        return false;
    }
}
