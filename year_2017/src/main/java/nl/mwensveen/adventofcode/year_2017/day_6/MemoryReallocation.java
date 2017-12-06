package nl.mwensveen.adventofcode.year_2017.day_6;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MemoryReallocation {
    List<Integer> memoryBanks;
    List<String> usedConfigs = new ArrayList<>();

    public MemoryReallocation(String blocks) {
        Iterable<String> split = Splitter.on(" ")
            .trimResults()
            .omitEmptyStrings()
            .split(blocks);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        memoryBanks = newArrayList.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public LoopStats calculate() {
        String mbString = toStringArray();
        int loopCounter = 0;
        while (!usedConfigs.contains(mbString)) {
            usedConfigs.add(mbString);
            redistribute();
            loopCounter++;
            mbString = toStringArray();
        }
        return new LoopStats(loopCounter, usedConfigs.size() - usedConfigs.indexOf(mbString));
    }

    private void redistribute() {
        Optional<Integer> max = memoryBanks.stream().max(Comparator.naturalOrder());
        int i = memoryBanks.indexOf(max.get());
        int count = memoryBanks.get(i);
        memoryBanks.set(i, Integer.valueOf(0));
        IntStream.range(0, count).reduce(next(i), (index, foo) -> {
            memoryBanks.set(index, memoryBanks.get(index) + 1);
            return next(index);
        });
    }

    private int next(int index) {
        return index + 1 == memoryBanks.size() ? 0 : index + 1;
    }

    private String toStringArray() {
        StringBuilder sb = new StringBuilder();
        return memoryBanks.stream().map(i -> i.toString()).collect(Collectors.joining("-"));
    }
}
