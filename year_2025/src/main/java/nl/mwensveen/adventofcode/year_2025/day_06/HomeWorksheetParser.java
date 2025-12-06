package nl.mwensveen.adventofcode.year_2025.day_06;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;
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
}
