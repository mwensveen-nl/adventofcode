package nl.mwensveen.adventofcode.year_2022.day_11;

import java.math.BigInteger;
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
        game.play(monkeys, 1, 3);

        assertEquals(4, monkeys.size());
        Monkey monkey = monkeys.get(0);
        assertEquals(2, monkey.getInspectedItems());
        assertEquals(4, monkey.getItems().size());
        assertTrue(monkey.getItems().contains(BigInteger.valueOf(20L)));
        assertTrue(monkey.getItems().contains(BigInteger.valueOf(23L)));
        assertTrue(monkey.getItems().contains(BigInteger.valueOf(27L)));
        assertTrue(monkey.getItems().contains(BigInteger.valueOf(26L)));

        monkey = monkeys.get(1);
        assertEquals(4, monkey.getInspectedItems());
        assertEquals(6, monkey.getItems().size());
        assertTrue(monkey.getItems().contains(BigInteger.valueOf(2080L)));
        assertTrue(monkey.getItems().contains(BigInteger.valueOf(25L)));
        assertTrue(monkey.getItems().contains(BigInteger.valueOf(167L)));
        assertTrue(monkey.getItems().contains(BigInteger.valueOf(207L)));
        assertTrue(monkey.getItems().contains(BigInteger.valueOf(401L)));
        assertTrue(monkey.getItems().contains(BigInteger.valueOf(1046L)));

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
        game.play(monkeys, 20, 3);

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
    public void testPlay1NoDivide() {
        List<Monkey> monkeys = monkeyParser.parseMonkeys(INPUT_ALL.lines().toList());

        Game game = new Game();
        game.play(monkeys, 1, 1);

        Monkey monkey = monkeys.get(0);
        assertEquals(2, monkey.getInspectedItems());
        monkey = monkeys.get(1);
        assertEquals(4, monkey.getInspectedItems());
        monkey = monkeys.get(2);
        assertEquals(3, monkey.getInspectedItems());
        monkey = monkeys.get(3);
        assertEquals(6, monkey.getInspectedItems());
    }

    @Test
    public void testPlay20NoDivide() {
        List<Monkey> monkeys = monkeyParser.parseMonkeys(INPUT_ALL.lines().toList());

        Game game = new Game();
        game.play(monkeys, 20, 1);

        Monkey monkey = monkeys.get(0);
        // assertEquals(99, monkey.getInspectedItems());
        monkey = monkeys.get(1);
        // assertEquals(97, monkey.getInspectedItems());
        monkey = monkeys.get(2);
        // assertEquals(8, monkey.getInspectedItems());
        monkey = monkeys.get(3);
        // assertEquals(103, monkey.getInspectedItems());
    }

    @Test
    public void testCalculateMonkeyBusiness() {
        List<Monkey> monkeys = monkeyParser.parseMonkeys(INPUT_ALL.lines().toList());

        Game game = new Game();
        game.play(monkeys, 20, 3);
        long monkeyBusiness = game.calculateMonkeyBusiness(monkeys);
        assertEquals(10605, monkeyBusiness);
    }
}
