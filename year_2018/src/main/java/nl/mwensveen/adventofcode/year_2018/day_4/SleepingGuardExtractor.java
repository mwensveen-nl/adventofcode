package nl.mwensveen.adventofcode.year_2018.day_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SleepingGuardExtractor {

    private List<GuardEvent> guardEvents;
    private Map<Integer, int[]> guardSleepMap;

    public SleepingGuardExtractor(List<String> input) {
        guardEvents = input.stream().map(GuardEvent::new).sorted().collect(Collectors.toList());
        guardSleepMap = buildMap();
    }

    public int strategyOne() {
        Comparator<int[]> comparator = Comparator.comparing(a -> a[1]);

        Optional<int[]> longestAsleep =
                guardSleepMap.entrySet().stream().map(sleep -> new int[] { sleep.getKey(), Arrays.stream(sleep.getValue()).sum() }).max(comparator);
        int[] is = guardSleepMap.get(longestAsleep.get()[0]);
        int max = 0;
        int minute = 0;
        for (int i = 0; i < is.length; i++) {
            if (is[i] > max) {
                max = is[i];
                minute = i;
            }
        }
        return minute * longestAsleep.get()[0];
    }

    public int strategyTwo() {
        AtomicInteger maxSleepPerMinute = new AtomicInteger(0);
        AtomicInteger minute = new AtomicInteger(0);
        AtomicInteger guard = new AtomicInteger(0);

        Set<Entry<Integer, int[]>> guardSleep = guardSleepMap.entrySet();
        guardSleep.stream().forEach(gs -> {
            int[] sleep = gs.getValue();
            for (int i = 0; i < sleep.length; i++) {
                if (sleep[i] > maxSleepPerMinute.get()) {
                    maxSleepPerMinute.set(sleep[i]);
                    minute.set(i);
                    guard.set(gs.getKey());
                }
            }
        });
        return guard.intValue() * minute.intValue();

    }

    private Map<Integer, int[]> buildMap() {
        Map<Integer, int[]> guardSleepMap = new HashMap<>();
        AtomicInteger guard = new AtomicInteger(0);
        AtomicInteger startSleep = new AtomicInteger(0);

        guardEvents.forEach(ge -> {
            if (Event.START_DUTY == ge.getEvent()) {
                guard.set(ge.getGuardNumber());
            }
            if (Event.FALL_ASLEEP == ge.getEvent()) {
                startSleep.set(ge.getEventTime().getMinute());
            }
            if (Event.WAKE_UP == ge.getEvent()) {
                int[] minutes;
                if (guardSleepMap.containsKey(guard.intValue())) {
                    minutes = guardSleepMap.get(guard.intValue());
                } else {
                    minutes = new int[60];
                    guardSleepMap.put(guard.intValue(), minutes);
                }
                for (int m = startSleep.intValue(); m < ge.getEventTime().getMinute(); m++) {
                    minutes[m]++;
                }
            }
        });
        return guardSleepMap;
    }
}
