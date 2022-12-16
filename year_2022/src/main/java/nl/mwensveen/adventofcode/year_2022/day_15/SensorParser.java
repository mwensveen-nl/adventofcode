package nl.mwensveen.adventofcode.year_2022.day_15;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SensorParser {
    private static final Pattern PATTERN = Pattern.compile(
            "Sensor at x=([+-]?[0-9]+), y=([+-]?[0-9]+): closest beacon is at x=([+-]?[0-9]+), y=([+-]?[0-9]+)",
            Pattern.CASE_INSENSITIVE);

    public List<Sensor> parse(List<String> input) {
        return input.stream().map(s -> toSensor(s)).toList();
    }

    private Sensor toSensor(String s) {
        final Matcher matcher = PATTERN.matcher(s);
        matcher.matches();
        return new Sensor(
                Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2)), Integer.valueOf(matcher.group(3)), Integer.valueOf(matcher.group(4)));
    }
}
