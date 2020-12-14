package nl.mwensveen.adventofcode.year_2020.day_14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MaskParser {

    public Map<Integer, Integer> parseVersionOne(String mask) {
        Map<Integer, Integer> result = new HashMap<>();
        String[] split = mask.split("");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String s = split[i];
            if (!"X".equals(s)) {
                result.put(Integer.valueOf(length - i - 1), Integer.valueOf(s));
            }
        }
        return result;
    }

    private List<List<String>> processFloatingBit(List<String> orig) {
        boolean done = false;
        List<List<String>> oldMasks = new ArrayList<>();
        oldMasks.add(orig);
        while (!done) {
            done = true;
            List<List<String>> newMasks = new ArrayList<>();
            for (Iterator<List<String>> iterator = oldMasks.iterator(); iterator.hasNext();) {
                List<String> list = iterator.next();
                Collection<List<String>> replaceFirstFloating = replaceFirstFloating(list);
                if (replaceFirstFloating.size() != 0) {
                    done = false;
                    newMasks.addAll(replaceFirstFloating);
                }
            }
            if (!done) {
                oldMasks = newMasks;
            }
        }
        return oldMasks;
    }

    private List<List<String>> replaceFirstFloating(List<String> oldList) {
        List<List<String>> newLists = new ArrayList<>();
        int first = oldList.indexOf("X");
        if (first >= 0) {
            List<String> modified = new ArrayList<>(oldList);
            modified.set(first, "0");
            newLists.add(modified);
            modified = new ArrayList<>(oldList);
            modified.set(first, "1");
            newLists.add(modified);
        }
        return newLists;
    }

}
