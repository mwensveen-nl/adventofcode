package nl.mwensveen.adventofcode.year_2020.day_04;

import java.util.ArrayList;
import java.util.List;

public class PassportInputConverter {

    public List<Passport> convert(List<String> input) {
        List<Passport> output = new ArrayList<>();

        Passport p = newPassport(output);
        for (String s : input) {
            if (s.isEmpty()) {
                p = newPassport(output);
            } else {
                addFieldsToPassport(p, s);
            }
        }
        return output;
    }

    private void addFieldsToPassport(Passport p, String s) {
        String[] split = s.split(" ");
        for (String entry : split) {
            String[] entrySplit = entry.split(":");
            p.addData(PassportField.fromString(entrySplit[0]), entrySplit[1]);
        }
    }

    private Passport newPassport(List<Passport> output) {
        Passport passport = new Passport();
        output.add(passport);
        return passport;
    }
}
