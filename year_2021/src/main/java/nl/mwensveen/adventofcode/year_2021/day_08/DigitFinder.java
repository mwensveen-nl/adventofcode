package nl.mwensveen.adventofcode.year_2021.day_08;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DigitFinder {

    public Integer findDigits(String input, Map<Integer, Set<Character>> knownDigits) {
        String[] split = input.split("\\|");
        String digitsString = split[1].trim();
        String[] digits = digitsString.split(" ");

        StringBuilder sb = new StringBuilder();
        Arrays.stream(digits).map(ds -> signalAsSet(ds))
                .forEach(digit -> {
                    sb.append(knownDigits.entrySet().stream().filter(entry -> entry.getValue().equals(digit)).findFirst().get().getKey().toString());
                });
        return Integer.valueOf(sb.toString());
    }

    private Set<Character> signalAsSet(String signal) {
        return signal.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
    }
}
