package nl.mwensveen.adventofcode.year_2025.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ButtonCombiSelectorTest {

    @Test
    public void findLeastCombinationOne() {
        List<Button> initialList = List.of(new Button("3"), new Button("1, 3"), new Button("2"), new Button("2, 3"));
        RecursiveCombinations rc = new RecursiveCombinations();
        List<List<Button>> combinations = rc.generateCombinations(initialList);

        IndicatorLight indicatorLight = new IndicatorLight(".##.");

        ButtonCombiSelector combiSelector = new ButtonCombiSelector();
        int leastCombination = combiSelector.findLeastCombination(indicatorLight, combinations);
        assertEquals(2, leastCombination);
    }

    @Test
    public void findLeastCombinationTwo() {
        List<Button> initialList = List.of(new Button("0,2,3,4"), new Button("2,3"), new Button("0,4"), new Button("0,1,2"), new Button("1,2,3,4"));
        RecursiveCombinations rc = new RecursiveCombinations();
        List<List<Button>> combinations = rc.generateCombinations(initialList);

        IndicatorLight indicatorLight = new IndicatorLight("...#.");

        ButtonCombiSelector combiSelector = new ButtonCombiSelector();
        int leastCombination = combiSelector.findLeastCombination(indicatorLight, combinations);
        assertEquals(3, leastCombination);
    }

}
