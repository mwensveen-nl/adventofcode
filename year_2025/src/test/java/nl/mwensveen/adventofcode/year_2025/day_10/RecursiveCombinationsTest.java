package nl.mwensveen.adventofcode.year_2025.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class RecursiveCombinationsTest {

    @Test
    public void generateCombinations() {
        RecursiveCombinations rc = new RecursiveCombinations();
        List<Button> initialList = List.of(new Button("3"), new Button("1, 3"), new Button("2"), new Button("2, 3"));
        List<List<Button>> combinations = rc.generateCombinations(initialList);
        assertEquals(15, combinations.size());
        assertEquals(new Button("3"), combinations.get(0).get(0));
        assertEquals(new Button("3"), combinations.get(14).get(0));
        assertEquals(new Button("1,3"), combinations.get(14).get(1));
        assertEquals(new Button("2"), combinations.get(14).get(2));
        assertEquals(new Button("2,3"), combinations.get(14).get(3));
    }

}
