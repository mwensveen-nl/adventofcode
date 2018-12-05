package nl.mwensveen.adventofcode.year_2018.day_4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuardEvent implements Comparable<GuardEvent> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final String REGEXP_DATE =
            ".*?((?:(?:[1]{1}\\d{1}\\d{1}\\d{1})|(?:[2]{1}\\d{3}))[-:\\/.](?:[0]?[1-9]|[1][012])[-:\\/.](?:(?:[0-2]?\\d{1})|(?:[3][01]{1})))(?![\\d])";
    private static final String REGEXP_TIME = ".*?((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM))?)";
    private static final String REGEXP_EVENT_NOTE = ".*?((?:[a-z][a-z0-9_]*))";
    private static final String REGEXP_GUARD_NUMBER = ".*?#(\\d*)(?![-+0-9])";

    private static final Pattern PATTERN_DATE = Pattern.compile(REGEXP_DATE, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final Pattern PATTERN_TIME = Pattern.compile(REGEXP_TIME, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final Pattern PATTERN_EVENT_NOTE = Pattern.compile(REGEXP_EVENT_NOTE, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final Pattern PATTERN_GUARD_NUMBER = Pattern.compile(REGEXP_GUARD_NUMBER, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private LocalDateTime eventTime;
    private Event event;
    private Integer guardNumber;

    public GuardEvent(String input) {

        String date = extract(input, PATTERN_DATE);
        String time = extract(input, PATTERN_TIME);
        eventTime = LocalDateTime.parse(date + "T" + time, FORMATTER);

        String eventString = extract(input, PATTERN_EVENT_NOTE);
        event = Event.valueFor(eventString);

        if (Event.START_DUTY == event) {
            String number = extract(input, PATTERN_GUARD_NUMBER);
            guardNumber = new Integer(number);
        }
    }

    private String extract(String input, Pattern p) {
        Matcher m = p.matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public Event getEvent() {
        return event;
    }

    public Integer getGuardNumber() {
        return guardNumber;
    }

    @Override
    public int compareTo(GuardEvent o) {
        return eventTime.isBefore(o.eventTime) ? -1 : 1;
    }

}
