package nl.mwensveen.adventofcode.year_2018.day_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FabricClaim {
    private static final String REGEXP_ID = ".*?(\\d+)";
    private static final String REGEXP_FROM_LEFT = ".*?\\d+.*?(\\d+)";
    private static final String REGEXP_FROM_TOP = ".*?\\d+.*?\\d+.*?(\\d+)";
    private static final String REGEXP_WIDE = ".*?\\d+.*?\\d+.*?\\d+.*?(\\d+)";
    private static final String REGEXP_HEIGHT = ".*?\\d+.*?\\d+.*?\\d+.*?\\d+.*?(\\d+)";
    private static final Pattern PATTERN_ID = Pattern.compile(REGEXP_ID, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final Pattern PATTERN_FROM_LEFT = Pattern.compile(REGEXP_FROM_LEFT, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final Pattern PATTERN_FROM_TOP = Pattern.compile(REGEXP_FROM_TOP, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final Pattern PATTERN_WIDE = Pattern.compile(REGEXP_WIDE, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final Pattern PATTERN_HEIGHT = Pattern.compile(REGEXP_HEIGHT, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    private Integer id;
    private Integer fromLeft;
    private Integer fromTop;
    private Integer wide;
    private Integer height;

    public FabricClaim(String claimString) {
        id = extract(claimString, PATTERN_ID);
        fromLeft = extract(claimString, PATTERN_FROM_LEFT);
        fromTop = extract(claimString, PATTERN_FROM_TOP);
        wide = extract(claimString, PATTERN_WIDE);
        height = extract(claimString, PATTERN_HEIGHT);
    }

    private Integer extract(String claimString, Pattern p) {
        Matcher m = p.matcher(claimString);
        if (m.find()) {
            String int1 = m.group(1);
            return new Integer(int1);
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public Integer getFromLeft() {
        return fromLeft;
    }

    public Integer getEndFromLeft() {
        return fromLeft + wide - 1;
    }

    public Integer getFromTop() {
        return fromTop;
    }

    public Integer getEndFromTop() {
        return fromTop + height - 1;
    }

    public Integer getWide() {
        return wide;
    }

    public Integer getHeight() {
        return height;
    }

}
