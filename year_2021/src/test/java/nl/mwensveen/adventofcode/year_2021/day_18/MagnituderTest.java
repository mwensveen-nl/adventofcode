package nl.mwensveen.adventofcode.year_2021.day_18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class MagnituderTest {

    @Test
    public void testCalculateMagnitude() {
        Magnituder magnituder = new Magnituder();
        String magnitude = magnituder.calculateMagnitude(stringAsList("[[1,2],[[3,4],5]]"));
        assertEquals("143", magnitude);
    }

    @Test
    public void testCalculateMagnitude2() {
        Magnituder magnituder = new Magnituder();
        String magnitude = magnituder.calculateMagnitude(stringAsList("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]"));
        assertEquals("3488", magnitude);
    }

    private List<String> stringAsList(String signal) {
        return signal.chars().mapToObj(e -> Character.toString(e)).collect(Collectors.toList());
    }
}
