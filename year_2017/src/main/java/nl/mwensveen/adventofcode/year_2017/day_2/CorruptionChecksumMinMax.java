package nl.mwensveen.adventofcode.year_2017.day_2;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CorruptionChecksumMinMax {

    private List<List<Integer>> cells;

    public CorruptionChecksumMinMax(String sheet) {
        List<String> rows = toLineList(sheet);
        cells = rows.stream().map(row -> toIntList(row)).collect(Collectors.toList());
    }

    public Integer calculate() {
        return cells.stream().map(row -> row.stream().collect(Collectors.summarizingInt(i -> i.intValue())))
            .map(summarized -> new MinMax(summarized.getMin(), summarized.getMax())).map(MinMax::difference).collect(Collectors.summingInt(i -> i.intValue()));
    }

    private List<String> toLineList(String in) {
        Iterable<String> split = Splitter.on("\n")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        System.out.println(newArrayList);
        return newArrayList;

    }

    private List<Integer> toIntList(String in) {
        Iterable<String> split = Splitter.on(" ")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        List<Integer> list = newArrayList.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
        System.out.println(list);
        return list;

    }

    public static class MinMax {
        int min;
        int max;

        public MinMax(int min, int max) {
            super();
            this.min = min;
            this.max = max;
        }

        public Integer difference() {
            return Integer.valueOf(max - min);
        }
    }
}
