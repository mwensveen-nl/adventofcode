package nl.mwensveen.adventofcode.year_2023.day_09;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HistoryCalculator {

    public int calculate(List<Integer> history, boolean prev) {
        List<List<Integer>> sequences = new ArrayList<List<Integer>>();
        sequences.add(history);
        while (sequences.getLast().stream().collect(Collectors.groupingBy(i -> i)).size() != 1) {
            ArrayList<Integer> newSequence = new ArrayList<>();
            List<Integer> last = sequences.getLast();
            IntStream.range(0, last.size() - 1).forEach(i -> newSequence.add(last.get(i + 1) - last.get(i)));
            sequences.add(newSequence);
        }

        return sequences.reversed().stream().map(l -> prev ? l.getFirst() : l.getLast()).collect(Collectors.reducing(0, (e, last) -> prev ? last - e : e + last));
    }
}
