package nl.mwensveen.adventofcode.year_2021.day_08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class DigitFinderTest {

    @Test
    public void testFindDigits() {
        Map<Integer, Set<Character>> knownDigits = new HashMap<>();

        knownDigits.put(8, signalAsSet("acedgfb"));
        knownDigits.put(5, signalAsSet("cdfbe"));
        knownDigits.put(2, signalAsSet("gcdfa"));
        knownDigits.put(3, signalAsSet("fbcad"));
        knownDigits.put(7, signalAsSet("dab"));
        knownDigits.put(9, signalAsSet("cefabd"));
        knownDigits.put(6, signalAsSet("cdfgeb"));
        knownDigits.put(4, signalAsSet("eafb"));
        knownDigits.put(0, signalAsSet("cagedb"));
        knownDigits.put(1, signalAsSet("ab"));

        DigitFinder digitFinder = new DigitFinder();
        Integer result = digitFinder.findDigits("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf", knownDigits);
        assertEquals(5353, result);
    }

    private Set<Character> signalAsSet(String signal) {
        return signal.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
    }

}
