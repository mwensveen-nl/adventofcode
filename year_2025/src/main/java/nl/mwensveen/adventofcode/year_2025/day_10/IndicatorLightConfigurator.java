package nl.mwensveen.adventofcode.year_2025.day_10;

import java.util.List;

public class IndicatorLightConfigurator {

    private RecursiveCombinations combinations = new RecursiveCombinations();
    private ButtonCombiSelector combiSelector = new ButtonCombiSelector();

    public int configure(List<Machine> machines) {
        return machines.stream().map(this::configureMachine).reduce(0, (a, b) -> a + b);
    }

    private int configureMachine(Machine machine) {
        List<List<Button>> buttons = combinations.generateCombinations(machine.buttons());
        return combiSelector.findLeastCombination(machine.indicatorLight(), buttons);
    }
}
