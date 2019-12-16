package nl.mwensveen.adventofcode.year_2019.day_16;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Algorithm {

    public List<Integer> applyAlgorithm(List<Integer> input, List<Integer> pattern) {
        List<Integer> output = new ArrayList<>();
        AtomicInteger ra = new AtomicInteger();
        for (int r = 1; r <= input.size(); r++) {
            long sum = calulate(r, pattern, input);
            long last = sum - sum / 10 * 10;
            output.add((int) last);
        }

        System.out.println(output);
        return output;
    }

    private long calulate(int repeat, List<Integer> pattern, List<Integer> input) {
        long sum = 0;
        int counter = 0;
        int length = pattern.size();
        for (Integer number : input) {
            counter++;
            int index = counter / repeat;
            index = index % length;
            sum += number * pattern.get(index);
        }
        return Math.abs(sum);
    }

}
