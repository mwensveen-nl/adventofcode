package nl.mwensveen.adventofcode.year_2020.day_14;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramRunner {

    private static final String MASK = "mask = ";
    private static final int MASK_Lenght = MASK.length();

    public BigInteger runProgram(List<String> input) {
        MaskParser maskParser = new MaskParser();
        BitMaskProcessor bitMaskProcessor = new BitMaskProcessor();

        Map<Long, BigInteger> memory = new HashMap<>();
        Map<Integer, Integer> maskMap = new HashMap<>();
        for (String instruction : input) {
            if (instruction.startsWith(MASK)) {
                maskMap = maskParser.parseVersionOne(instruction.substring(MASK_Lenght));
            } else {
                int start = instruction.indexOf("[");
                int end = instruction.indexOf("]");
                int startNumber = instruction.indexOf("=");
                Long memPos = Long.parseLong(instruction.substring(start + 1, end));
                Long value = Long.parseLong(instruction.substring(startNumber + 2));
                memory.put(memPos, bitMaskProcessor.processVersionOne(value, maskMap));
            }
        }

        BigInteger result = new BigInteger("0");
        Collection<BigInteger> values = memory.values();
        for (BigInteger v : values) {
            result = result.add(v);
        }
        return result;
    }
}
