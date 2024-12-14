package nl.mwensveen.adventofcode.year_2024.day_11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlinkingTest {
    private static final String input = "125 17";

    @Test
    public void testBlinkSingle() {
        int result = new Blinking().blink(Collections.singletonList(1L));
        assertEquals(55312, result);
    }

    @Test
    public void testBlink() {
        List<Long> list = Arrays.asList(input.split(" ")).stream().map(Long::valueOf).toList();
        int result = new Blinking().blink(list);
        assertEquals(55312, result);
    }

}
