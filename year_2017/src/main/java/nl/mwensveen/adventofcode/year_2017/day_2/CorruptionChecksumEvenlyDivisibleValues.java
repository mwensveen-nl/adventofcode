package nl.mwensveen.adventofcode.year_2017.day_2;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CorruptionChecksumEvenlyDivisibleValues {

    private List<List<Integer>> cells;

    public CorruptionChecksumEvenlyDivisibleValues(String sheet) {
        List<String> rows = toLineList(sheet);
        cells = rows.stream().map(row -> toIntList(row)).collect(Collectors.toList());
    }

    public Integer calculate() {
        return Integer.valueOf(cells.stream().map(row -> findDuo(row)).collect(Collectors.summingInt(Duo::devide)));
    }

    private Duo findDuo(List<Integer> row) {
        return IntStream.range(0, row.size()).mapToObj(i -> toPairsWithThisIndex(row, i)).flatMap(List<Duo>::stream).filter(Duo::evenlyDivide).findFirst()
            .get();
    }

    private List<Duo> toPairsWithThisIndex(List<Integer> row, int i) {
        return IntStream.range(i + 1, row.size()).mapToObj(j -> new Duo(row.get(i), row.get(j))).collect(Collectors.toList());
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
