package nl.mwensveen.adventofcode.year_2020.day_01;

import java.util.List;
import java.util.Optional;

public class ReportRepairCalculator {

    private static final Integer SUM_2020 = 2020;

    public Integer findEntriesInExpenceReportTwo(List<Integer> entries) {
        Optional<Integer> calc = calcTwo(entries);
        if (calc.isPresent()) {
            return calc.get();
        }

        throw new RuntimeException("not found");
    }

    public Integer findEntriesInExpenceReportThree(List<Integer> entries) {
        Optional<Integer> calc = calcThree(entries);
        if (calc.isPresent()) {
            return calc.get();
        }

        throw new RuntimeException("not found");
    }

    private Optional<Integer> calcTwo(List<Integer> entries) {
        for (int i = 0; i < entries.size(); i++) {
            Integer entryOne = entries.get(i);
            for (int j = i + 1; j < entries.size(); j++) {
                Integer entryTwo = entries.get(j);
                if (SUM_2020.equals(entryOne + entryTwo)) {
                    return Optional.of(entryOne * entryTwo);
                }
            }
        }
        return Optional.empty();
    }

    private Optional<Integer> calcThree(List<Integer> entries) {
        for (int i = 0; i < entries.size(); i++) {
            Integer entryOne = entries.get(i);
            for (int j = i + 1; j < entries.size(); j++) {
                Integer entryTwo = entries.get(j);
                for (int k = j + 1; k < entries.size(); k++) {
                    Integer entryThree = entries.get(k);
                    if (SUM_2020.equals(entryOne + entryTwo + entryThree)) {
                        return Optional.of(entryOne * entryTwo * entryThree);
                    }
                }
            }
        }
        return Optional.empty();
    }
}
