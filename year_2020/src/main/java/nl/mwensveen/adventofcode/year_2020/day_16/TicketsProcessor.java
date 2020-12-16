package nl.mwensveen.adventofcode.year_2020.day_16;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketsProcessor {

    private TicketValidator ticketValidator = new TicketValidator();

    public long processInvalidValues(List<List<Integer>> tickets, List<Field> fields) {
        return tickets.stream().map(ticket -> ticketValidator.validate(ticket, fields)).collect(Collectors.summingLong(Integer::longValue));
    }

    public BigInteger processIdentifyFields(List<List<Integer>> tickets, List<Field> fields, List<Integer> myTicket) {
        List<List<Integer>> validTickets = tickets.stream().filter(ticket -> ticketValidator.validate(ticket, fields) == 0).collect(Collectors.toList());

        List<List<Integer>> possibleFieldNumbers = possibleFieldNumber(fields.size());

        // list<list> = row<column>; row = fields, column = possible position
        for (int r = 0; r < fields.size(); r++) {
            for (int c = 0; c < fields.size(); c++) {
                boolean possible = checkFieldOnPosition(fields.get(r), c, validTickets);
                if (!possible) {
                    possibleFieldNumbers.get(r).set(c, null);
                }
            }
        }

        possibleFieldNumbers.stream().forEach(this::removeNull);

        boolean done = false;
        while (!done) {
            List<Integer> found = possibleFieldNumbers.stream().filter(row -> row.size() == 1).map(row -> row.get(0)).collect(Collectors.toList());
            possibleFieldNumbers.stream().filter(row -> row.size() > 1).forEach(row -> remove(row, found));
            done = possibleFieldNumbers.stream().filter(row -> row.size() > 1).count() == 0L;
        }

        List<Long> departurefields = StreamUtils.zipWithIndex(fields.stream()).filter(entry -> entry.getValue().getName().startsWith("departure"))
                .map(Indexed::getIndex).collect(Collectors.toList());

        BigInteger result = departurefields.stream().map(l -> possibleFieldNumbers.get(l.intValue()).get(0)).map(i -> BigInteger.valueOf(myTicket.get(i)))
                .reduce(BigInteger.ONE, BigInteger::multiply);
        return result;
    }

    private void remove(List<Integer> row, List<Integer> found) {
        found.forEach(i -> row.remove(i));
    }

    private void removeNull(List<Integer> row) {
        boolean b = true;
        while (b) {
            b = row.remove(null);
        }
    }

    private boolean checkFieldOnPosition(Field field, int c, List<List<Integer>> validTickets) {
        return validTickets.stream().map(ticket -> ticket.get(c)).filter(i -> !ticketValidator.validateValue(i, field)).findAny().isEmpty();

        // boolean valid = true;
        // for (Iterator<List<Integer>> iterator = validTickets.iterator(); valid && iterator.hasNext();) {
        // List<Integer> ticket = iterator.next();
        // Integer value = ticket.get(c);
        // if (value != null) {
        // valid = ticketValidator.validateValue(value, field);
        // }
        // }
        // return valid;
    }

    private List<List<Integer>> possibleFieldNumber(int fieldSize) {
        List<List<Integer>> possibleFieldNumbers = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < fieldSize; i++) {
            temp.add(i);
        }
        for (int i = 0; i < fieldSize; i++) {
            possibleFieldNumbers.add(new ArrayList<>(temp));
        }
        return possibleFieldNumbers;
    }
}
