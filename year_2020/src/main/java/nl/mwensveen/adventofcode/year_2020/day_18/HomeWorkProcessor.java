package nl.mwensveen.adventofcode.year_2020.day_18;

import java.util.List;
import java.util.stream.Collectors;

public class HomeWorkProcessor {

    public long processHomework(List<String> input) {
        Calculator calculator = new Calculator();
        return input.stream().map(calculator::calculate).collect(Collectors.summingLong(Long::longValue));
    }

    public long processHomeworkAdvanced(List<String> input) {
        Calculator calculator = new Calculator();
        return input.stream().map(calculator::calculateAdvanced).collect(Collectors.summingLong(Long::longValue));
    }
}
