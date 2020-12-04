package nl.mwensveen.adventofcode.year_2020.day_04;

import java.util.HashMap;
import java.util.Map;

public class Passport {

    private final Map<PassportField, String> data = new HashMap<>();

    public Passport addData(PassportField passportFields, String value) {
        data.put(passportFields, value);
        return this;
    }

    public boolean containsFiels(PassportField passportFields) {
        return data.containsKey(passportFields);
    }

    public Map<PassportField, String> getData() {
        return data;
    }

}
