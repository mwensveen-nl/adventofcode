package nl.mwensveen.adventofcode.year_2020.day_04;

import java.util.Optional;

public class PassportChecker {

    public boolean checkAllFields(Passport passport) {
        Optional<PassportField> missing = PassportField.requiredFields().filter(pf -> !passport.containsFiels(pf)).findAny();
        return missing.isEmpty();
    }

    public boolean checkAllValues(Passport passport) {
        Optional<PassportField> invalid = PassportField.requiredFields().filter(pf -> !validValue(pf, passport.getData().get(pf))).findAny();
        return invalid.isEmpty();
    }

    private boolean validValue(PassportField pf, String value) {
        switch (pf) {
            case BYR:
                return BYRValidator.validate(value);
            case IYR:
                return IYRValidator.validate(value);
            case EYR:
                return EYRValidator.validate(value);
            case HGT:
                return HGTValidator.validate(value);
            case ECL:
                return ECLValidator.validate(value);
            case HCL:
                return HCLValidator.validate(value);
            case PID:
                return PIDValidator.validate(value);
            default:
                return false;
        }
    }
}