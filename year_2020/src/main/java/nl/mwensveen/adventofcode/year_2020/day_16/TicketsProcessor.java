package nl.mwensveen.adventofcode.year_2020.day_16;

import java.util.List;
import java.util.stream.Collectors;

public class TicketsProcessor {

    public long process(List<List<Integer>> tickets, List<Field> fields) {
        TicketValidator ticketValidator = new TicketValidator();
        return tickets.stream().map(ticket -> ticketValidator.validate(ticket, fields)).collect(Collectors.summingLong(Integer::longValue));
    }
}
