package nl.mwensveen.adventofcode.year_2020.day_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamePlayer {

    public Long findNumber(int count, List<Long> start) {
        Map<Long, List<Long>> numbers = processStart(start);
        Long last = start.get(start.size() - 1);
        long index = start.size();
        while (index < count) {
            if (numbers.containsKey(last) && numbers.get(last).size() > 1) {
                List<Long> spoken = numbers.get(last);
                Long lastSpoken = spoken.get(spoken.size() - 1);
                Long beforeLastSpoken = spoken.get(spoken.size() - 2);
                last = lastSpoken - beforeLastSpoken;
            } else {
                last = Long.valueOf(0);
            }
            addNumber(numbers, index, last);
            index++;
        }
        return last;
    }

    private Map<Long, List<Long>> processStart(List<Long> start) {
        Map<Long, List<Long>> numbers = new HashMap<>();
        for (int i = 0; i < start.size(); i++) {
            addNumber(numbers, i, start.get(i));
        }
        return numbers;
    }

    private void addNumber(Map<Long, List<Long>> numbers, long position, Long num) {
        if (!numbers.containsKey(num)) {
            numbers.put(num, new ArrayList<>());
        }
        numbers.get(num).add(Long.valueOf(position));
    }
}
