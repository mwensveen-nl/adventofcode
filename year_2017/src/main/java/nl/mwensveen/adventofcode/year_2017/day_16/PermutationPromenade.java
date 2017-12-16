package nl.mwensveen.adventofcode.year_2017.day_16;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationPromenade {
    private int numberDancers;
    private List<String> moves;

    private List<Character> progs;

    public PermutationPromenade(String input, int numberDancers) {
        this.numberDancers = numberDancers;
        moves = toStringList(input);
    }

    public String calculate() {
        progs = IntStream.range(0, numberDancers).mapToObj(i -> (char) (i + 97)).collect(Collectors.toList());
        performMoves();
        return progs.stream().map(c -> c.toString()).collect(Collectors.joining());
    }

    public String calculateRepeating(int repeat) {
        progs = IntStream.range(0, numberDancers).mapToObj(i -> (char) (i + 97)).collect(Collectors.toList());
        List<Character> progsOrig = IntStream.range(0, numberDancers).mapToObj(i -> (char) (i + 97)).collect(Collectors.toList());
        int cycle = -1;
        for (int i = 1; i <= repeat && cycle == -1; i++) {
            performMoves();
            if (progsOrig.equals(progs)) {
                cycle = i;
            }
        }
        if (cycle == -1) {
            return progs.stream().map(c -> c.toString()).collect(Collectors.joining());
        }

        int number = repeat % cycle;
        progs = progsOrig;
        for (int i = 0; i < number; i++) {
            performMoves();
        }
        return progs.stream().map(c -> c.toString()).collect(Collectors.joining());
    }

    private void performMoves() {
        moves.stream().forEach(m -> move(m));
    }

    private void move(String m) {
        String type = m.substring(0, 1);
        String data = m.substring(1);
        switch (type) {
            case "s":
                spin(data);
                break;
            case "x":
                exchange(data);
                break;
            case "p":
                partner(data);
                break;
            default:
                throw new RuntimeException("unrecognises type " + type);
        }
    }

    private void partner(String data) {
        char a = data.charAt(0);
        char b = data.charAt(2);

        int i1 = progs.indexOf(a);
        int i2 = progs.indexOf(b);
        progs.set(i1, b);
        progs.set(i2, a);
    }

    private void exchange(String data) {
        int index = data.indexOf("/");
        int posA = Integer.parseInt(data.substring(0, index));
        int posB = Integer.parseInt(data.substring(index + 1));

        char a = progs.get(posA);
        char b = progs.get(posB);
        progs.set(posB, a);
        progs.set(posA, b);
    }

    private void spin(String data) {
        int count = Integer.parseInt(data);
        int index = numberDancers - count;

        List<Character> start = new ArrayList<>(progs.subList(index, numberDancers));
        start.addAll(progs.subList(0, index));
        progs = new ArrayList<>(start);
    }

    private List<String> toStringList(String in) {
        Iterable<String> split = Splitter.on(",")
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        System.out.println(newArrayList);
        return newArrayList;
    }

    public <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
