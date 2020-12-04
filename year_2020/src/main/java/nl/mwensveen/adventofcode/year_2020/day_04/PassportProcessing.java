package nl.mwensveen.adventofcode.year_2020.day_04;

import java.util.List;

/**
 * Processing of a list of passports.
 */
public class PassportProcessing {

    private List<Passport> passports;

    public PassportProcessing(List<String> input) {
        PassportInputConverter converter = new PassportInputConverter();
        passports = converter.convert(input);
    }

    public long countValidPassports() {
        PassportChecker passportChecker = new PassportChecker();
        return passports.stream().filter(passportChecker::checkAllFields).count();
    }

    public long countValidPassportsWithValues() {
        PassportChecker passportChecker = new PassportChecker();
        return passports.stream().filter(passportChecker::checkAllFields).filter(passportChecker::checkAllValues).count();
    }
}
