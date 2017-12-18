package nl.mwensveen.adventofcode.year_2017.day_17;

import java.util.ArrayList;
import java.util.List;

public class Spinlock {
    private final int steps;

    public Spinlock(String stepString) {
        steps = Integer.parseInt(stepString);
    }

    public int calculate(int repeat) {
        List<Integer> buffer = new ArrayList<>();
        buffer.add(Integer.valueOf(0));
        int position = 0;

        for (int i = 1; i <= repeat; i++) {
            int newPosition = (position + steps) % i + 1;
            buffer.add(newPosition, i);
            position = newPosition;
        }
        System.out.println(buffer);
        return buffer.get(position + 1);
    }

    public int calculateAfterZero(int repeat) {
        int position = 0;
        int afterZero = -1;

        for (int i = 1; i <= repeat; i++) {
            int newPosition = (position + steps) % i + 1;

            if (newPosition == 1) {
                afterZero = i;
            }
            position = newPosition;
        }
        return afterZero;
    }
}
