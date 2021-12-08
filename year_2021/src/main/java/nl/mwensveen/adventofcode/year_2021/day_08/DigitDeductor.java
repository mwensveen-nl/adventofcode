package nl.mwensveen.adventofcode.year_2021.day_08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DigitDeductor {

    public Map<Integer, Set<Character>> deduct(String input) {
        String[] split = input.split("\\|");
        String signalString = split[0].trim();
        String[] signals = signalString.split(" ");

        Map<Integer, Set<Character>> decoded = new HashMap<>();

        // unique digits - lenghts
        for (String signal : signals) {
            switch (signal.length()) {
                case 2:
                    decoded.put(1, signalAsSet(signal));
                    break;
                case 3:
                    decoded.put(7, signalAsSet(signal));
                    break;
                case 4:
                    decoded.put(4, signalAsSet(signal));
                    break;
                case 7:
                    decoded.put(8, signalAsSet(signal));
                    break;
                default:
                    break;
            }
        }

        // deduct the other numbers
        for (String signal : signals) {
            switch (signal.length()) {
                case 5:
                    deductLengthFive(decoded, signal);
                    break;
                case 6:
                    deductLengthSix(decoded, signal);
                    break;
                default:
                    break;
            }
        }

        return decoded;
    }

    private void deductLengthFive(Map<Integer, Set<Character>> decoded, String signal) {
        Set<Character> signalAsSet = signalAsSet(signal);

        if (signalAsSet.containsAll(decoded.get(1))) {
            decoded.put(3, signalAsSet);
        } else {

            Set<Character> copy = new HashSet<>();
            copy.addAll(signalAsSet);
            copy.addAll(decoded.get(4));
            if (copy.equals(decoded.get(8))) {
                decoded.put(2, signalAsSet);
            } else {
                decoded.put(5, signalAsSet);
            }
        }
    }

    private void deductLengthSix(Map<Integer, Set<Character>> decoded, String signal) {
        Set<Character> signalAsSet = signalAsSet(signal);

        if (!signalAsSet.containsAll(decoded.get(1))) {
            decoded.put(6, signalAsSet);
        } else {
            Set<Character> copy = new HashSet<>();
            copy.addAll(signalAsSet);
            copy.addAll(decoded.get(4));
            if (copy.equals(decoded.get(8))) {
                decoded.put(0, signalAsSet);
            } else {
                decoded.put(9, signalAsSet);
            }
        }
    }

    private Set<Character> signalAsSet(String signal) {
        return signal.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
    }
}
