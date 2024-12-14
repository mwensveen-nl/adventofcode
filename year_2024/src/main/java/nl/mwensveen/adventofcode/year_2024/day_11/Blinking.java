package nl.mwensveen.adventofcode.year_2024.day_11;

import java.util.LinkedList;
import java.util.List;

public class Blinking {
    private static final Long ONE = Long.valueOf(1L);
    private static final long MULTIPLIER = Long.valueOf(2024L);

    public int blink(List<Long> list) {
        List<Long> stones = new LinkedList<>(list);
        for (int i = 0; i < 25; i++) {
            System.out.println(i);
            System.out.println("  " + stones);
            stones = blinkOnce(stones);

        }
        return stones.size();
    }

    private List<Long> blinkOnce(List<Long> stones) {
        List<Long> newStones = new LinkedList<>();
        for (int i = 0; i < stones.size(); i++) {
            Long number = stones.get(i);
            if (number == 0) {
                newStones.add(ONE);
            } else if (number.toString().length() % 2 == 0) {
                int index = number.toString().length() / 2;
                newStones.add(Long.valueOf(number.toString().substring(0, index)));
                newStones.add(Long.valueOf(number.toString().substring(index)));
            } else {
                newStones.add(number * MULTIPLIER);
            }
        }
        return newStones;
    }
}
