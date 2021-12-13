package nl.mwensveen.adventofcode.year_2021.day_13;

import com.google.common.collect.Table;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PaperPrinter {

    void printPaper(Table<Integer, Integer, Character> paper) {
        Stream<Integer> rows = paper.rowKeySet().stream().sorted();
        rows.map(r -> paper.row(r)).forEach(row -> printLine(row));
        ;
    }

    private void printLine(Map<Integer, Character> row) {
        IntSummaryStatistics statistics = row.keySet().stream().collect(Collectors.summarizingInt(i -> i));
        IntStream.rangeClosed(0, statistics.getMax()).forEach(i -> {
            if (row.containsKey(i)) {
                System.out.print("#");
            } else {
                System.out.print(" ");
            }
        });
        System.out.println();
    }
}
