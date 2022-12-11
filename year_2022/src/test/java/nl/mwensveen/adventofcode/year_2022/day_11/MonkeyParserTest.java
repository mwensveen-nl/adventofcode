package nl.mwensveen.adventofcode.year_2022.day_11;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonkeyParserTest {

    public static final String INPUT = """
            Monkey 0:
              Starting items: 75, 63
              Operation: new = old * 3
              Test: divisible by 11
                If true: throw to monkey 7
                If false: throw to monkey 2
                        """;

    public static final String INPUT_ALL = """
            Monkey 0:
              Starting items: 79, 98
              Operation: new = old * 19
              Test: divisible by 23
                If true: throw to monkey 2
                If false: throw to monkey 3

            Monkey 1:
              Starting items: 54, 65, 75, 74
              Operation: new = old + 6
              Test: divisible by 19
                If true: throw to monkey 2
                If false: throw to monkey 0

            Monkey 2:
              Starting items: 79, 60, 97
              Operation: new = old * old
              Test: divisible by 13
                If true: throw to monkey 1
                If false: throw to monkey 3

            Monkey 3:
              Starting items: 74
              Operation: new = old + 3
              Test: divisible by 17
                If true: throw to monkey 0
                If false: throw to monkey 1
                        """;

    private MonkeyParser monkeyParser = new MonkeyParser();

    @Test
    public void testParse() {
        Monkey monkey = monkeyParser.parse(INPUT.lines().toList());

        assertEquals(0, monkey.getNumber());
        assertEquals(2, monkey.getItems().size());
        assertTrue(monkey.getItems().contains(75));
        assertTrue(monkey.getItems().contains(63));
        assertEquals(new Operation("*", "3"), monkey.getOperation());
        assertEquals(11, monkey.getTestDivider());
        assertEquals(7, monkey.getTestTrueMonkey());
        assertEquals(2, monkey.getTestFalseMonkey());
    }

    @Test
    public void testParseMonkeys() {
        List<Monkey> parseMonkeys = monkeyParser.parseMonkeys(INPUT_ALL.lines().toList());
        assertEquals(4, parseMonkeys.size());

    }

}
