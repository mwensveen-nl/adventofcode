package nl.mwensveen.adventofcode.year_2025.day_06;

import com.google.common.base.Strings;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class HomeWorksheetParser {

    public Table<Integer, Integer, String> parse(List<String> input) {
        Table<Integer, Integer, String> worksheet = HashBasedTable.create();
        IntStream.range(0, input.size()).forEach(i -> parse(input.get(i), worksheet, i));
        return worksheet;
    }

    private void parse(String s, Table<Integer, Integer, String> worksheet, int row) {
        String[] split = s.split(" ");
        AtomicInteger col = new AtomicInteger(0);
        Arrays.asList(split).stream()
                .filter(s2 -> s2 != null && !s2.isEmpty())
                .forEach(v -> worksheet.put(Integer.valueOf(row), Integer.valueOf(col.getAndIncrement()), v));
    }

    public List<List<String>> parseCephalopod(List<String> input2) {
        int lineEnd = input2.stream().map(String::length).max(Comparator.naturalOrder()).get();
        List<String> input = new ArrayList<>();
        for (int i = 0; i < input2.size(); i++) {
            input.add(Strings.padEnd(input2.get(i), lineEnd, ' '));
        }

        List<List<String>> worksheet = new ArrayList<>();

        boolean done = false;
        int start = 0;
        while (!done) {
            int end = start;

            for (String line : input) {
                int space = line.indexOf(" ", start);
                end = Math.max(end, space < 0 ? lineEnd : space);
            }
            List<String> values = new ArrayList<>();
            for (String line : input) {
                if (end >= lineEnd) {
                    values.add(line.substring(start));
                } else {
                    values.add(line.substring(start, end));
                }
            }
            start = end + 1;
            worksheet.add(values);
            if (start >= lineEnd) {
                done = true;
            }
        }

        return worksheet;
    }
}
