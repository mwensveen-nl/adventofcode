package nl.mwensveen.adventofcode.year_2022.day_11;

import java.util.List;

public class Game {

    public List<Monkey> play(List<Monkey> input, int rounds) {
        for (int i = 0; i < rounds; i++) {
            for (Monkey monkey : input) {
                List<Integer> items = monkey.getItems();
                for (Integer item : items) {
                    Integer worryLevel = monkey.getOperation().calculate(item);
                    worryLevel = Math.floorDiv(worryLevel, 3);
                    boolean testResult = (worryLevel % monkey.getTestDivider()) == 0;
                    if (testResult) {
                        input.get(monkey.getTestTrueMonkey()).getItems().add(worryLevel);
                    } else {
                        input.get(monkey.getTestFalseMonkey()).getItems().add(worryLevel);
                    }
                }
                monkey.clearItems();
            }
        }
        return input;
    }

    public int calculateMonkeyBusiness(List<Monkey> monkeys) {
        int max1 = monkeys.stream().mapToInt(m -> m.getInspectedItems()).max().getAsInt();
        long count = monkeys.stream().mapToInt(Monkey::getInspectedItems).filter(i -> i == max1).count();
        if (count > 1L) {
            return max1 * max1;
        }
        int max2 = monkeys.stream().mapToInt(m -> m.getInspectedItems()).filter(i -> i != max1).max().getAsInt();
        return max1 * max2;

    }
}
