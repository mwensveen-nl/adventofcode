package nl.mwensveen.adventofcode.year_2020.day_16;

import nl.mwensveen.adventofcode.year_2020.day_16.Field.Builder;

public class FieldParser {

    private static final String MIN_STRING = "-";
    private static final int MIN_LENGTH = MIN_STRING.length();
    private static final String COLON_STRING = ":";
    private static final int COLON_SIZE = COLON_STRING.length();
    private static final String OR_STRING = "or";
    private static final int OR_SIZE = OR_STRING.length();

    public Field parse(String input) {
        Builder builder = Field.builder();

        int colon = input.indexOf(COLON_STRING);
        builder.withName(input.substring(0, colon));

        String substring = input.substring(colon);
        int or = substring.indexOf(OR_STRING);
        builder.addRanges(parseRange(substring.substring(COLON_SIZE, or).trim()));
        builder.addRanges(parseRange(substring.substring(or + OR_SIZE).trim()));

        return builder.build();
    }

    private Range parseRange(String rangeString) {
        int index = rangeString.indexOf(MIN_STRING);
        return Range.builder().withMin(Integer.parseInt(rangeString.substring(0, index))).withMax(Integer.parseInt(rangeString.substring(index + MIN_LENGTH)))
                .build();
    }
}
