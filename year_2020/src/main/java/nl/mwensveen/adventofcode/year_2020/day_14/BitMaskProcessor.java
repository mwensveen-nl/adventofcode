package nl.mwensveen.adventofcode.year_2020.day_14;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BitMaskProcessor {
    private static final String FLOATING = "X";
    private static final Integer ZERO = Integer.valueOf(0);
    private static final String ONE = "1";

    public BigInteger processVersionOne(long in, Map<Integer, Integer> bitMaskList) {
        BigInteger result = new BigInteger(Long.toString(in));

        Set<Entry<Integer, Integer>> entrySet = bitMaskList.entrySet();
        for (Entry<Integer, Integer> entry : entrySet) {
            result = modifyBit(entry, result);
        }
        return result;
    }

    public List<BigInteger> processVersionTwo(long in, String bitMask) {
        BigInteger ones = new BigInteger(Long.toString(in));
        ones = processV2OneBits(bitMask, ones);
        return prcessV2FloatingBits(bitMask, ones);
    }

    private List<BigInteger> prcessV2FloatingBits(String bitMask, BigInteger ones) {
        List<BigInteger> oldValues = new ArrayList<>();
        List<BigInteger> newValues;
        oldValues.add(ones);
        int length = bitMask.length();
        for (int i = 0; i < length; i++) {
            newValues = new ArrayList<>();
            if (bitMask.substring(i, i + 1).equals(FLOATING)) {
                Integer bit = Integer.valueOf(length - i - 1);
                for (BigInteger bigInteger : oldValues) {
                    newValues.add(bigInteger.setBit(bit));
                    newValues.add(bigInteger.clearBit(bit));
                }
                oldValues = newValues;
            }
        }
        return oldValues;
    }

    private BigInteger processV2OneBits(String bitMask, BigInteger result) {
        int length = bitMask.length();
        for (int i = 0; i < length; i++) {
            if (bitMask.substring(i, i + 1).equals(ONE)) {
                result = result.setBit(Integer.valueOf(length - i - 1));
            }
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
