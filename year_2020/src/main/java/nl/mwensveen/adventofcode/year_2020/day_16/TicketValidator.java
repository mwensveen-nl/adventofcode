package nl.mwensveen.adventofcode.year_2020.day_16;

import java.util.List;
import java.util.stream.Collectors;

public class TicketValidator {
    public int validate(List<Integer> ticket, List<Field> fields) {
        return ticket.stream().filter(value -> validateValue(value, fields)).collect(Collectors.summingInt(Integer::intValue));
    }

    private boolean validateValue(Integer value, List<Field> fields) {
        return fields.stream().filter(f -> validateValue(value, f)).findAny().isEmpty();
    }

    private boolean validateValue(Integer value, Field f) {
        return f.getRanges().stream().filter(r -> r.inRange(value)).findAny().isPresent();
    }
}
