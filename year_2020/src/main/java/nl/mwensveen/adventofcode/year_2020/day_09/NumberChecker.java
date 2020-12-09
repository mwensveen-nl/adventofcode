package nl.mwensveen.adventofcode.year_2020.day_09;

import java.util.List;

public class NumberChecker {

    public Long checkValidNumbers(List<Long> numbers, int preamble) {
        for (int i = preamble; i < numbers.size(); i++) {
            Long number = numbers.get(i);
            boolean valid = checkValidNumber(numbers.subList(i - preamble, i), number);
            if (!valid) {
                return number;
            }
        }
        throw new RuntimeException("no invalid numbers found");
    }

    public Long findContiguousSet(List<Long> numbers, long sumToFind) {
        for (int i = 0; i < numbers.size(); i++) {
            long sum = numbers.get(i);
            boolean done = false;
            long min = numbers.get(i);
            long max = numbers.get(i);
            for (int j = i + 1; j < numbers.size() && !done; j++) {
                sum += numbers.get(j);
                if (sum > sumToFind) {
                    done = true;
                }
                min = Math.min(min, numbers.get(j));
                max = Math.max(max, numbers.get(j));
                if (sum == sumToFind) {
                    return min + max;
                }
            }
        }
        throw new RuntimeException("No contiguous set found");
    }

    private boolean checkValidNumber(List<Long> list, Long number) {
        for (int i1 = 0; i1 < list.size(); i1++) {
            for (int i2 = i1 + 1; i2 < list.size(); i2++) {
                if (list.get(i1) + list.get(i2) == number) {
                    return true;
                }
            }
        }
        return false;
    }
}
