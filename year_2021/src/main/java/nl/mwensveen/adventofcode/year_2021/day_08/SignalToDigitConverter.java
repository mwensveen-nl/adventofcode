package nl.mwensveen.adventofcode.year_2021.day_08;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SignalToDigitConverter {

    public long convert(List<String> input) {
        DigitDeductor digitDeductor = new DigitDeductor();
        DigitFinder digitFinder = new DigitFinder();

        long total = 0;
        for (String line : input) {
            Map<Integer, Set<Character>> deduct = digitDeductor.deduct(line);
            Integer digits = digitFinder.findDigits(line, deduct);
            total += digits.longValue();
        }
        return total;
    }
}
