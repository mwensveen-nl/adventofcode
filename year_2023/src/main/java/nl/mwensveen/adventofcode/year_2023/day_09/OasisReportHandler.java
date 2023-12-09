package nl.mwensveen.adventofcode.year_2023.day_09;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OasisReportHandler {

    public long handleReport(List<String> input, boolean prev) {
        HistoryCalculator calculator = new HistoryCalculator();
        return input.stream().map(this::toInts).map(l -> calculator.calculate(l, prev)).collect(Collectors.summingLong(l -> l));
    }

    private List<Integer> toInts(String string) {
        String[] strings = string.split(" ");
        return Arrays.asList(strings).stream().map(Integer::valueOf).toList();
    }
}
