package nl.mwensveen.adventofcode.year_2024.day_11;

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blinking {
    private static final Long ONE = Long.valueOf(1L);
    private static final long MULTIPLIER = Long.valueOf(2024L);

    public long blink(List<Long> list, int times) {
        Map<Long, Long> stones = Maps.toMap(list, l -> 1L);

        for (int i = 0; i < times; i++) {
            stones = blinkOnce(stones);
        }
        return stones.values().stream().mapToLong(Long::valueOf).sum();
    }

    private Map<Long, Long> blinkOnce(Map<Long, Long> stones) {

        Map<Long, Long> newStones = new HashMap<>();
        stones.entrySet().forEach(e -> {
            Long number = e.getKey();
            Long count = e.getValue();
            if (number == 0) {
                addOrUpdate(newStones, ONE, count);
            } else if (number.toString().length() % 2 == 0) {
                int index = number.toString().length() / 2;
                addOrUpdate(newStones, Long.valueOf(number.toString().substring(0, index)), count);
                addOrUpdate(newStones, Long.valueOf(number.toString().substring(index)), count);
            } else {
                addOrUpdate(newStones, number * MULTIPLIER, count);
            }
        });
        return newStones;
    }

    private void addOrUpdate(Map<Long, Long> newStones, Long number, Long count) {
        long c = newStones.getOrDefault(number, 0L) + count;
        newStones.put(number, c);
    }
}
