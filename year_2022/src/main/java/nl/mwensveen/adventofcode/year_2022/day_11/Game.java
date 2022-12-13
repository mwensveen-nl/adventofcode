package nl.mwensveen.adventofcode.year_2022.day_11;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Game {

    private boolean needDivider;
    private BigInteger div;
    private Function<BigInteger, BigInteger> divideFunction;

    public List<Monkey> play(List<Monkey> input, int rounds, int divider) {
        div = BigInteger.valueOf(divider);
        needDivider = !div.equals(BigInteger.ONE);
        if (needDivider) {
            divideFunction = (t) -> t.divide(new BigInteger("3"));
        } else {
            // Ok, I cheated on this one and got the solution from Reddit.
            int productDeviders = input.stream().mapToInt(monkey -> monkey.getTestDivider().intValue()).reduce(1, (a, b) -> a * b);
            divideFunction = (t) -> t.remainder(BigInteger.valueOf(productDeviders));
        }
        IntStream.range(0, rounds).forEach(i -> playRound(input));
        return input;
    }

    private void playRound(List<Monkey> input) {
        input.forEach(monkey -> playMonkey(input, monkey));
    }

    private void playMonkey(List<Monkey> input, Monkey monkey) {
        monkey.getItems().forEach(item -> {
            BigInteger worryLevel = monkey.getOperation().apply(item);
            worryLevel = divideFunction.apply(worryLevel);
            BigInteger[] divideAndRemainder = worryLevel.divideAndRemainder(monkey.getTestDivider());
            int number = (divideAndRemainder[1] == BigInteger.ZERO) ? monkey.getTestTrueMonkey() : monkey.getTestFalseMonkey();
            input.get(number).getItems().add(worryLevel);
        });
        monkey.clearItems();
    }

    public long calculateMonkeyBusiness(List<Monkey> monkeys) {
        List<Long> max = monkeys.stream().mapToLong(m -> -1 * m.getInspectedItems()).sorted().limit(2).mapToObj(l -> l).toList();
        return max.get(0) * max.get(1);

    }
}
