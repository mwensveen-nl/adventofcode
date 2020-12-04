package nl.mwensveen.adventofcode.year_2020.day_04;

public class IYRValidator {

    public static boolean validate(String value) {
        String yearPattern = "^[0-9]{4}$";
        if (value.matches(yearPattern) && "2010".compareTo(value) <= 0 && "2020".compareTo(value) >= 0) {
            return true;
        }
        return false;
    }

}
