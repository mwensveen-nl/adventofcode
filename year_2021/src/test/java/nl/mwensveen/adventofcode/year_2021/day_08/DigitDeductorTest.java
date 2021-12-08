package nl.mwensveen.adventofcode.year_2021.day_08;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class DigitDeductorTest {

    @Test
    public void testDeduct() {
        DigitDeductor digitDeductor = new DigitDeductor();

        Map<Integer, Set<Character>> deduct = digitDeductor.deduct("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf");

        assertTrue(signalAsSet("acedgfb").equals(deduct.get(8)));
        assertTrue(signalAsSet("cdfbe").equals(deduct.get(5)));
        assertTrue(signalAsSet("gcdfa").equals(deduct.get(2)));
        assertTrue(signalAsSet("fbcad").equals(deduct.get(3)));
        assertTrue(signalAsSet("dab").equals(deduct.get(7)));
        assertTrue(signalAsSet("cefabd").equals(deduct.get(9)));
        assertTrue(signalAsSet("cdfgeb").equals(deduct.get(6)));
        assertTrue(signalAsSet("eafb").equals(deduct.get(4)));
        assertTrue(signalAsSet("cagedb").equals(deduct.get(0)));
        assertTrue(signalAsSet("ab").equals(deduct.get(1)));
    }

    private Set<Character> signalAsSet(String signal) {
        return signal.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
    }
}
