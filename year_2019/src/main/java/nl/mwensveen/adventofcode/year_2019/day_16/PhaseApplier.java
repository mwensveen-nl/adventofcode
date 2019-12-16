package nl.mwensveen.adventofcode.year_2019.day_16;

import java.util.Arrays;
import java.util.List;

public class PhaseApplier {

    private final int counter;
    private final List<Integer> pattern = Arrays.asList(0, 1, 0, -1);

    public PhaseApplier(int counter) {
        super();
        this.counter = counter;
    }

    public List<Integer> applyPhases(List<Integer> input) {
        Algorithm algorithm = new Algorithm();

        List<Integer> list = input;
        for (int i = 0; i < counter; i++) {
            list = algorithm.applyAlgorithm(list, pattern);
        }

        return list;
    }
}
