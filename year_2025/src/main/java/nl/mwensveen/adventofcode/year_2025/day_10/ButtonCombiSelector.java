package nl.mwensveen.adventofcode.year_2025.day_10;

import java.util.List;

public class ButtonCombiSelector {

    int findLeastCombination(IndicatorLight indicatorLight, List<List<Button>> combinations) {
        for (int i = 0; i < combinations.size(); i++) {
            Integer current = 0;
            var buttons = combinations.get(i);
            for (int j = 0; j < buttons.size(); j++) {
                current = current ^ buttons.get(j).bits();
            }
            if (current.equals(indicatorLight.bits())) {
                return buttons.size();
            }
        }
        throw new RuntimeException("combi not found " + indicatorLight.diagram());
    }
}
