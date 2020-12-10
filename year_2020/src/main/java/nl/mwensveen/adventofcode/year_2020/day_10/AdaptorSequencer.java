package nl.mwensveen.adventofcode.year_2020.day_10;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdaptorSequencer {

    public long determineSequenceJoltageRatings(List<Long> adaptors) {
        Stream<Long> sorted = adaptors.stream().sorted();
        AtomicLong jolts = new AtomicLong(0);
        AtomicInteger countOne = new AtomicInteger();
        AtomicInteger countThree = new AtomicInteger();
        sorted.forEach(l -> {
            if (l.intValue() - jolts.get() == 1) {
                countOne.incrementAndGet();
            } else if (l.longValue() - jolts.get() == 3) {
                countThree.incrementAndGet();
            } else {
                throw new RuntimeException("Cannot calculate diff: " + jolts.intValue() + " " + l.intValue());
            }
            jolts.set(l.longValue());
        });
        int countedOne = countOne.get();
        int countedThree = countThree.incrementAndGet(); // add one for your device's built-in adapter
        return countedOne * countedThree;
    }

    public long determineDistinctWays(List<Long> adaptors) {
        List<Long> sorted = adaptors.stream().sorted().collect(Collectors.toList());
        Long last = sorted.get(sorted.size() - 1);
        sorted.add(last + 3);
        int count = find(0, sorted);
        return count;
    }

    private int find(long jolts, List<Long> sorted) {
        int count = 0;
        boolean done = false;
        for (int i = 0; i < sorted.size() && !done; i++) {
            if (sorted.get(i) - jolts < 4) {
                // System.out.println(Strings.repeat(".", sorted.size()) + " " + jolts + " " + sorted.get(i));
                count += find(sorted.get(i), sorted.subList(i + 1, sorted.size()));
                if (sorted.size() == 1) {
                    count++;
                }
            } else {
                done = true;
            }
        }
        return count;
    }
}
