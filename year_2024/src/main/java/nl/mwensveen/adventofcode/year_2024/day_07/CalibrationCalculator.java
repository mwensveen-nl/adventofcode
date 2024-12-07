package nl.mwensveen.adventofcode.year_2024.day_07;

import java.util.ArrayList;
import java.util.List;

public class CalibrationCalculator {

    public Long findCalibrations(List<String> input) {
        return input.stream().mapToLong(this::calibrate).sum();
    }

    public Long findCalibrationsWithConcat(List<String> input) {
        return input.stream().mapToLong(this::calibrateWithConcat).sum();
    }

    private Long calibrate(String in) {
        String[] split = in.split(":");

        Long expected = Long.valueOf(split[0]);
        String[] numberStrings = split[1].trim().split(" ");
        List<Long> numbers = new ArrayList<>();
        for (int ns = 0; ns < numberStrings.length; ns++) {
            numbers.add(Long.valueOf(numberStrings[ns]));
        }

        List<Long> values = new ArrayList<>();
        values.add(numbers.getFirst());

        for (int i = 1; i < numbers.size(); i++) {
            long n = numbers.get(i);
            List<Long> newValues = new ArrayList<>();
            for (int v = 0; v < values.size(); v++) {
                newValues.add(values.get(v) + n);
                newValues.add(values.get(v) * n);
            }
            values = newValues;
        }

        if (values.contains(expected)) {
            return expected;
        }
        return 0L;
    }

    private Long calibrateWithConcat(String in) {
        String[] split = in.split(":");

        Long expected = Long.valueOf(split[0]);
        String[] numberStrings = split[1].trim().split(" ");
        List<Long> numbers = new ArrayList<>();
        for (int ns = 0; ns < numberStrings.length; ns++) {
            numbers.add(Long.valueOf(numberStrings[ns]));
        }

        List<Long> values = new ArrayList<>();
        values.add(numbers.getFirst());

        for (int i = 1; i < numbers.size(); i++) {
            long n = numbers.get(i);
            List<Long> newValues = new ArrayList<>();
            for (int v = 0; v < values.size(); v++) {
                newValues.add(values.get(v) + n);
                newValues.add(values.get(v) * n);
                newValues.add(Long.valueOf(values.get(v).toString().concat(Long.toString(n))));
            }
            values = newValues;
        }

        if (values.contains(expected)) {
            return expected;
        }
        return 0L;
    }
}
