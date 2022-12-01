package nl.mwensveen.adventofcode.year_2022.day_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class CalorieCounter {

    public Long countMostCalories(List<String> input) {
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

        Optional<Long> max = calsPerElf.stream().max(Comparator.naturalOrder());

        return max.get();

    }
}
