package nl.mwensveen.adventofcode.year_2021.day_18;

import java.util.Arrays;
import java.util.List;

public class SnailfishNumberCombiner {

    public String combine(List<String> input) {
        long max = Long.MIN_VALUE;
        SnailfishCalculator calculator = new SnailfishCalculator();

        int size = input.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    String result = calculator.calculate(Arrays.asList(input.get(i), input.get(j)));
                    max = Math.max(Long.parseLong(result), max);
                }
            }
        }
        return Long.toString(max);
    }
}
