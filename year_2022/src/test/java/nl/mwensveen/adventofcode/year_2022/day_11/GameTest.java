package nl.mwensveen.adventofcode.year_2022.day_11;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
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
    public void testPlay1() {
        List<Monkey> monkeys = monkeyParser.parseMonkeys(INPUT_ALL.lines().toList());

        Game game = new Game();
        game.play(monkeys, 1);

        assertEquals(4, monkeys.size());
        Monkey monkey = monkeys.get(0);
        assertEquals(2, monkey.getInspectedItems());
        assertEquals(4, monkey.getItems().size());
        assertTrue(monkey.getItems().contains(20));
        assertTrue(monkey.getItems().contains(23));
        assertTrue(monkey.getItems().contains(27));
        assertTrue(monkey.getItems().contains(26));

        monkey = monkeys.get(1);
        assertEquals(4, monkey.getInspectedItems());
        assertEquals(6, monkey.getItems().size());
        assertTrue(monkey.getItems().contains(2080));
        assertTrue(monkey.getItems().contains(25));
        assertTrue(monkey.getItems().contains(167));
        assertTrue(monkey.getItems().contains(207));
        assertTrue(monkey.getItems().contains(401));
        assertTrue(monkey.getItems().contains(1046));

        monkey = monkeys.get(2);
        assertEquals(3, monkey.getInspectedItems());
        assertEquals(0, monkey.getItems().size());

        monkey = monkeys.get(3);
        assertEquals(5, monkey.getInspectedItems());
        assertEquals(0, monkey.getItems().size());

    }

    @Test
    public void testPlay20() {
        List<Monkey> monkeys = monkeyParser.parseMonkeys(INPUT_ALL.lines().toList());

        Game game = new Game();
        game.play(monkeys, 20);

        Monkey monkey = monkeys.get(0);
        assertEquals(101, monkey.getInspectedItems());
        monkey = monkeys.get(1);
        assertEquals(95, monkey.getInspectedItems());
        monkey = monkeys.get(2);
        assertEquals(7, monkey.getInspectedItems());
        monkey = monkeys.get(3);
        assertEquals(105, monkey.getInspectedItems());
    }

    @Test
    public void testCalculateMonkeyBusiness() {
        List<Monkey> monkeys = monkeyParser.parseMonkeys(INPUT_ALL.lines().toList());

        Game game = new Game();
        game.play(monkeys, 20);
        int monkeyBusiness = game.calculateMonkeyBusiness(monkeys);
        assertEquals(10605, monkeyBusiness);
    }
}
