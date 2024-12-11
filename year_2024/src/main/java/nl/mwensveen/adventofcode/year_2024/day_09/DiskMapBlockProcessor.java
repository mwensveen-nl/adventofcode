package nl.mwensveen.adventofcode.year_2024.day_09;

import java.util.ArrayList;
import java.util.List;

public class DiskMapBlockProcessor {

    public long parse(String input) {
        char[] cs = input.toCharArray();

        int startId = 0;
        int endId = input.length() - 1;
        int blockId = 0;
        long checksum = 0;

        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        while (startId < endId) {
            Integer count = Integer.valueOf(Character.toString(cs[startId]));
            if (startId % 2 == 0) {
                // file
                int id = startId / 2;
                addRepeat(start, count, id);
            } else {
                addRepeat(start, count, Integer.MIN_VALUE);
            }
            startId++;
            int freeIndex = start.indexOf(Integer.MIN_VALUE);
            while (freeIndex >= 0) {
                while (end.isEmpty() && startId < endId) {
                    count = Integer.valueOf(Character.toString(cs[endId]));
                    if (endId % 2 == 0) {
                        // file
                        int id = endId / 2;
                        addRepeat(end, count, id);
                    }
                    endId--;
                }
                if (end.isEmpty()) {
                    break;
                }
                Integer r = end.getLast();
                end.removeLast();
                start.set(freeIndex, r);
                freeIndex = start.indexOf(Integer.MIN_VALUE);
            }
            for (int i = 0; i < start.size(); i++) {
                Integer s = start.get(i);
                if (!s.equals(Integer.MIN_VALUE)) {
                    checksum += s * blockId;
                    blockId++;
                }
            }
            start = new ArrayList<>();
        }
        for (int i = end.size() - 1; i >= 0; i--) {
            Integer s = end.get(i);
            if (!".".equals(s)) {
                checksum += s * blockId;
                blockId++;
            }
        }
        return checksum;
    }

    private void addRepeat(List<Integer> start, Integer count, int id) {
        for (int c = 0; c < count; c++) {
            start.add(id);
        }
    }
}
