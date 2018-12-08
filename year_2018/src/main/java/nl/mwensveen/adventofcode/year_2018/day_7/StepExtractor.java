package nl.mwensveen.adventofcode.year_2018.day_7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepExtractor {
    private static final String STEP_BEFORE_REGEXP = ".*?(?:[a-z][a-z0-9_]*).*?((?:[a-z][a-z0-9_]*))";
    private static final Pattern STEP_BEFORE_PATTER = Pattern.compile(STEP_BEFORE_REGEXP, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final String STEP_AFTER_REGEXP =
            ".*?(?:[a-z][a-z0-9_]*).*?(?:[a-z][a-z0-9_]*).*?(?:[a-z][a-z0-9_]*).*?(?:[a-z][a-z0-9_]*).*?(?:[a-z][a-z0-9_]*).*?(?:[a-z][a-z0-9_]*).*?(?:[a-z]"
                    + "[a-z0-9_]*).*?((?:[a-z][a-z0-9_]*))";
    private static final Pattern STEP_AFTER_PATTER = Pattern.compile(STEP_AFTER_REGEXP, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private final String before;
    private final String after;

    public StepExtractor(String input) {
        before = extract(input, STEP_BEFORE_PATTER);
        after = extract(input, STEP_AFTER_PATTER);
    }

    private String extract(String input, Pattern p) {
        Matcher m = p.matcher(input);
        if (m.find()) {
            String s = m.group(1);
            return s;
        }
        return null;
    }

    public String getBefore() {
        return before;
    }

    public String getAfter() {
        return after;
    }
}
