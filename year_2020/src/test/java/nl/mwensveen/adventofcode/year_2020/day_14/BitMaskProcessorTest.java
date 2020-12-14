package nl.mwensveen.adventofcode.year_2020.day_14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BitMaskProcessorTest {

    @Test
    public void testProcess() throws Exception {
        BitMaskProcessor bitMaskProcessor = new BitMaskProcessor();
        Map<Integer, Integer> bitMask = new HashMap<>();
        bitMask.put(1, 0);
        bitMask.put(6, 1);
        assertEquals(73L, bitMaskProcessor.process(11, bitMask).longValue());
    }

}
