package nl.mwensveen.adventofcode.year_2025.day_10;

import java.util.ArrayList;
import java.util.List;

public class RecursiveCombinations {

    public List<List<Button>> generateCombinations(List<Button> items) {
        List<List<Button>> result = new ArrayList<>();
        int n = items.size();
        // Total number of combinations is 2^n
        int totalCombinations = 1 << n;

        // Iterate from 0 to totalCombinations - 1 (includes the empty set)
        for (int i = 0; i < totalCombinations; i++) {
            List<Button> currentCombination = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit is set in the current combination number (i)
                if ((i & 1 << j) != 0) {
                    currentCombination.add(items.get(j));
                }
            }
            result.add(currentCombination);
        }

        result.remove(new ArrayList<>());

        result.sort((a, b) -> Integer.compare(a.size(), b.size()));
        return result;
    }

}
