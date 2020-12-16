package nl.mwensveen.adventofcode.year_2020.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TicketValidatorTest {

    private static List<Field> fields;

    @Test
    public void testValidate() throws Exception {
        TicketParser parser = new TicketParser();
        TicketValidator ticketValidator = new TicketValidator();
        assertEquals(0, ticketValidator.validate(parser.parse("7,3,47"), fields));
    }

    @Test
    public void testValidate2() throws Exception {
        TicketParser parser = new TicketParser();
        TicketValidator ticketValidator = new TicketValidator();
        assertEquals(55, ticketValidator.validate(parser.parse("55,2,20"), fields));
    }

    @Test
    public void testValidate3() throws Exception {
        TicketParser parser = new TicketParser();
        TicketValidator ticketValidator = new TicketValidator();
        assertEquals(255, ticketValidator.validate(parser.parse("55,2,200"), fields));
    }

    @BeforeAll
    public static void setup() {
        FieldParser fieldParser = new FieldParser();
        fields = new ArrayList<>();
        fields.add(fieldParser.parse("class: 1-3 or 5-7"));
        fields.add(fieldParser.parse("row: 6-11 or 33-44"));
        fields.add(fieldParser.parse("seat: 13-40 or 45-50"));
    }

}
