package nl.mwensveen.adventofcode.year_2022.day_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class CalorieCounter {

    public Long countMostCalories(List<String> input) {
        List<Long> calsPerElf = caloriesPerElf(input);

        Optional<Long> max = calsPerElf.stream().max(Comparator.naturalOrder());

        return max.get();

    }

    public Long countThreeMostCalories(List<String> input) {
        List<Long> calsPerElf = caloriesPerElf(input);

        Optional<Long> max = calsPerElf.stream().max(Comparator.naturalOrder());
        Long sumThree = calsPerElf.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.summingLong(Long::longValue));
        return sumThree;

    }

    private List<Long> caloriesPerElf(List<String> input) {
        List<Long> calsPerElf = new ArrayList<>();

        AtomicLong cals = new AtomicLong();
        input.stream().forEach(s -> {
            if (s.isBlank()) {
                calsPerElf.add(cals.longValue());
                cals.set(0);
            } else {
                cals.addAndGet(Long.valueOf(s));
            }
        });
        calsPerElf.add(cals.longValue());
        return calsPerElf;
    }
}
