package nl.mwensveen.adventofcode.year_2022.day_10;

import java.util.ArrayList;
import java.util.List;

public class EvaluateCycle {
    private List<Integer> evalCycle = new ArrayList<>(List.of(20, 60, 100, 140, 180, 220));
    private int sum = 0;

    public int getCycleNumber() {
        return evalCycle.get(0);
    }

    public void removeCycle() {
        evalCycle.remove(0);
    }

    public boolean done() {
        return evalCycle.isEmpty();
    }

    public void addSum(int value) {
        sum += value;
    }

    public int getSum() {
        return sum;
    }
}
