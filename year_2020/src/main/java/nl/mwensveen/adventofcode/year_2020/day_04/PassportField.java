package nl.mwensveen.adventofcode.year_2020.day_04;

import java.util.Arrays;
import java.util.stream.Stream;

public enum PassportField {

    BYR("Birth Year", true),
    IYR("Issue Year", true),
    EYR("Expiration Year", true),
    HGT("Height", true),
    HCL("Hair Color", true),
    ECL("Eye Color", true),
    PID("Passport ID", true),
    CID("Country ID", false);

    private String text;
    private boolean required;

    PassportField(String text, boolean required) {
        this.text = text;
        // TODO Auto-generated constructor stub
        this.required = required;
    }

    public String getText() {
        return text;
    }

    public boolean isRequired() {
        return required;
    }

    public static Stream<PassportField> requiredFields() {
        return Arrays.stream(PassportField.values()).filter(PassportField::isRequired);
    }

    public static PassportField fromString(String input) {
        for (PassportField element : PassportField.values()) {
            if (element.name().equalsIgnoreCase(input)) {
                return element;
            }
        }
        throw new RuntimeException("not found: " + input);
    }
}
