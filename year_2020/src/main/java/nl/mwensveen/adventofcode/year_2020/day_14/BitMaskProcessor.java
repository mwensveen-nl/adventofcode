package nl.mwensveen.adventofcode.year_2020.day_14;

import java.math.BigInteger;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BitMaskProcessor {
    private static final Integer ZERO = Integer.valueOf(0);

    public BigInteger process(long in, Map<Integer, Integer> bitMaskList) {
        BigInteger result = new BigInteger(Long.toString(in));

        Set<Entry<Integer, Integer>> entrySet = bitMaskList.entrySet();
        for (Entry<Integer, Integer> entry : entrySet) {
            result = modifyBit(entry, result);
        }
        return result;
    }

    private BigInteger modifyBit(Entry<Integer, Integer> entry, BigInteger result) {
        if (ZERO.equals(entry.getValue())) {
            return result.clearBit(entry.getKey());
        } else {
            return result.setBit(entry.getKey());
        }
    }
}
