package nl.mwensveen.adventofcode.year_2022.day_11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import nl.mwensveen.adventofcode.year_2022.day_11.Monkey.Builder;

public class MonkeyParser {
    private static final int MONKEY_LENGTH = "Monkey ".length();
    private static final int STARTING_ITEMS_LENGTH = "Starting items: ".length();
    private static final int OPERTION_LENGTH = "Operation: new = old ".length();
    private static final int TEST_LENGTH = "Test: divisible by ".length();
    private static final int TEST_TRUE_LENGTH = "If true: throw to monkey ".length();
    private static final int TEST_FALSE_LENGTH = "If false: throw to monkey ".length();

    public Monkey parse(List<String> input) {
        Builder builder = Monkey.builder();
        String in = input.get(0).trim();
        builder.withNumber(Integer.parseInt(in.substring(MONKEY_LENGTH, in.length() - 1)));

        in = input.get(1).trim();
        String sub = in.substring(STARTING_ITEMS_LENGTH);
        String[] split = sub.split(",");
        for (String s : split) {
            builder.addItems(BigInteger.valueOf(Long.parseLong(s.trim())));
        }

        in = input.get(2).trim();
        sub = in.substring(OPERTION_LENGTH);
        split = sub.split(" ");
        Function<BigInteger, BigInteger> f;
        if (split[1].equals("old")) {
            if (split[0].equals("+")) {
                f = (t) -> {
                    return t.add(t);
                };
            } else {
                f = (t) -> {
                    return t.multiply(t);
                };
            }

        } else {
            final BigInteger bi = BigInteger.valueOf(Long.parseLong(split[1]));
            if (split[0].equals("+")) {
                f = (t) -> {
                    return t.add(bi);
                };
            } else {
                f = (t) -> {
                    return t.multiply(bi);
                };
            }
        }
        builder.withOperation(f);

        in = input.get(3).trim();
        sub = in.substring(TEST_LENGTH);
        builder.withTestDivider(BigInteger.valueOf(Long.valueOf(sub)));

        in = input.get(4).trim();
        sub = in.substring(TEST_TRUE_LENGTH);
        builder.withTestTrueMonkey(Integer.parseInt(sub));

        in = input.get(5).trim();
        sub = in.substring(TEST_FALSE_LENGTH);
        builder.withTestFalseMonkey(Integer.parseInt(sub));

        return builder.build();
    }

    public List<Monkey> parseMonkeys(List<String> input) {
        ArrayList<String> lines = new ArrayList<>(input);
        List<Monkey> result = new ArrayList<>();
        while (!lines.isEmpty()) {
            List<String> monkey = List.of(lines.get(0), lines.get(1), lines.get(2), lines.get(3), lines.get(4), lines.get(5));
            Monkey parse = parse(monkey);
            result.add(parse);

            lines.remove(5);
            lines.remove(4);
            lines.remove(3);
            lines.remove(2);
            lines.remove(1);
            lines.remove(0);
            while (!lines.isEmpty() && lines.get(0).isBlank()) {
                lines.remove(0);
            }
        }
        return result;
    }
}
