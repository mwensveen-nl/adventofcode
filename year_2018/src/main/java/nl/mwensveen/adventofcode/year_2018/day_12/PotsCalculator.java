package nl.mwensveen.adventofcode.year_2018.day_12;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PotsCalculator {
    private static final String REG_EX = "(.*)\\s=>\\s(.)";
    private static final Pattern pattern = Pattern.compile(REG_EX, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private String initialState;

    private final List<String> spread;

    public PotsCalculator(String initialState, List<String> notes) {
        this.initialState = initialState;
        spread = notes.stream().map(n -> extract(n, pattern)).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public long deductPots(long cycles) {
        // after cycle 90 every next cycle adds 50 to the sum.
        // sum of cycle 90 = 5195
        return 5195 + (cycles - 90) * 50;
    }

    public int calculatePots(int cycles) {
        AtomicInteger index = new AtomicInteger(0);
        List<Pot> pots = initialState.chars().mapToObj(c -> new Pot(index.getAndIncrement(), '#' == c)).collect(Collectors.toList());
        int x = 0;
        int sumold = 0;
        for (int i = 0; i < cycles; i++) {
            int sum = pots.stream().filter(Pot::isPlant).mapToInt(Pot::getNumber).sum();
            System.out.println(x++ + " " + sum + " " + (sum - sumold));
            sumold = sum;
            pots = performGenerator(pots);
        }
        int sum = pots.stream().filter(Pot::isPlant).mapToInt(Pot::getNumber).sum();
        System.out.println(x++ + " " + sum + " " + (sum - sumold));
        return sum;
    }

    private List<Pot> performGenerator(List<Pot> pots) {
        preparePots(pots);
        return IntStream.range(0, pots.size()).mapToObj(i -> new Pot(pots.get(i).getNumber(), spread.contains(getPotsWithNeighbours(pots, i))))
                .collect(Collectors.toList());
    }

    private String getPotsWithNeighbours(List<Pot> pots, int i) {
        if (i < 2 || i > pots.size() - 3) {
            return ".....";
        }
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(i - 2, i + 2).forEach(index -> sb.append(pots.get(index).isPlant() ? "#" : "."));
        return sb.toString();
    }

    private void preparePots(List<Pot> pots) {
        int number = pots.get(0).getNumber();
        if (pots.get(0).isPlant()) {
            prependPots(pots, 4, number);
        } else if (pots.get(1).isPlant()) {
            prependPots(pots, 3, number);
        } else if (pots.get(2).isPlant()) {
            prependPots(pots, 2, number);
        } else if (pots.get(3).isPlant()) {
            prependPots(pots, 1, number);
        }

        int last = pots.size() - 1;
        number = pots.get(last).getNumber();
        if (pots.get(last).isPlant()) {
            appendPots(pots, 4, number);
        } else if (pots.get(last - 1).isPlant()) {
            appendPots(pots, 3, number);
        } else if (pots.get(last - 2).isPlant()) {
            appendPots(pots, 2, number);
        } else if (pots.get(last - 3).isPlant()) {
            appendPots(pots, 1, number);
        }
    }

    private void appendPots(List<Pot> pots, int count, int number) {
        IntStream.rangeClosed(1, count).forEach(i -> pots.add(new Pot(number + i, false)));
    }

    private void prependPots(List<Pot> pots, int count, int number) {
        IntStream.rangeClosed(1, count).forEach(i -> pots.add(0, new Pot(number - i, false)));
    }

    private String extract(String input, Pattern p) {
        Matcher m = p.matcher(input);
        if (m.find()) {
            String s = m.group(1);
            String fill = m.group(2);
            if ("#".equals(fill)) {
                return s;
            }
        }
        return null;
    }
}
