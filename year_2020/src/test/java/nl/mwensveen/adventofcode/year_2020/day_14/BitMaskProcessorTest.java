package nl.mwensveen.adventofcode.year_2020.day_14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BitMaskProcessorTest {

    @Test
    public void testProcessVersionOne() throws Exception {
        BitMaskProcessor bitMaskProcessor = new BitMaskProcessor();
        Map<Integer, Integer> bitMask = new HashMap<>();
        bitMask.put(1, 0);
        bitMask.put(6, 1);
        assertEquals(73L, bitMaskProcessor.processVersionOne(11, bitMask).longValue());
    }

    @Test
    public void testProcessVersionTwo() throws Exception {
        BitMaskProcessor bitMaskProcessor = new BitMaskProcessor();
        List<BigInteger> result = bitMaskProcessor.processVersionTwo(42, "000000000000000000000000000000X1001X");
        System.out.println(result);
    }

}
