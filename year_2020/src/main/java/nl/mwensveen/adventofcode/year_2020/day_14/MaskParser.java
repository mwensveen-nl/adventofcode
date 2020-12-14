package nl.mwensveen.adventofcode.year_2020.day_14;

import java.util.HashMap;
import java.util.Map;

public class MaskParser {

    public Map<Integer, Integer> parse(String mask) {
        Map<Integer, Integer> result = new HashMap<>();
        String[] split = mask.split("");
        int length = split.length;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (!"X".equals(s)) {
                result.put(Integer.valueOf(length - i - 1), Integer.valueOf(s));
            }
        }
        return result;
    }
}
