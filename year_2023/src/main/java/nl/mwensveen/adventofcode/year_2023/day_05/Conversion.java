package nl.mwensveen.adventofcode.year_2023.day_05;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record Conversion(String source, String destination, List<ConversionRange> conversionRanges) {

    // parse first line of the conversion (temperature-to-humidity map:)
    public static Conversion parse(String line) {
        final Pattern pattern = Pattern.compile("([A-Za-z]+)-to-([A-Za-z]+) map:", Pattern.CASE_INSENSITIVE);
        // Match regex against input
        final Matcher matcher = pattern.matcher(line);
        matcher.matches();
        String source = matcher.group(1);
        String destination = matcher.group(2);
        return new Conversion(source, destination, new ArrayList<ConversionRange>());
    }

    public void addRange(String line) {
        conversionRanges.add(ConversionRange.parse(line));
    }
}
