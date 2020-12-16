package nl.mwensveen.adventofcode.year_2020.day_16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InputParser {
    private static final int FIELDS = 0;
    private static final int MY_TICKET = 1;
    private static final int NEARBY_TICKETS = 2;

    public Input parse(List<String> inputStrings) {
        FieldParser fieldParser = new FieldParser();
        TicketParser ticketParser = new TicketParser();

        List<Field> fields = new ArrayList<>();
        List<Integer> myTicket = new ArrayList<>();
        List<List<Integer>> nearbyTickets = new ArrayList<>();

        int parsing = FIELDS;

        for (Iterator<String> iterator = inputStrings.iterator(); iterator.hasNext();) {
            String string = iterator.next();
            if (!string.isEmpty()) {
                if (string.startsWith("your ticket")) {
                    parsing = MY_TICKET;
                } else if (string.startsWith("nearby tickets")) {
                    parsing = NEARBY_TICKETS;
                } else {
                    switch (parsing) {
                        case FIELDS:
                            fields.add(fieldParser.parse(string));
                            break;
                        case MY_TICKET:
                            myTicket = ticketParser.parse(string);
                            break;
                        case NEARBY_TICKETS:
                            nearbyTickets.add(ticketParser.parse(string));
                            break;
                        default:
                            throw new RuntimeException("wrong parsing");
                    }
                }
            }
        }
        return Input.builder().withFields(fields).withMyTicket(myTicket).withNearbyTickets(nearbyTickets).build();
    }
}
