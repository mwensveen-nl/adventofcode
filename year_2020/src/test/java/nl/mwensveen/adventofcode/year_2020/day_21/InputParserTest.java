package nl.mwensveen.adventofcode.year_2020.day_21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    public void testParse() throws Exception {
        List<String> input = Arrays.asList("mxmxvkd kfcds sqjhc nhms (contains dairy, fish)", "trh fvjkl sbzzf mxmxvkd (contains dairy)",
                "sqjhc fvjkl (contains soy)", "sqjhc mxmxvkd sbzzf (contains fish)");
        InputParser inputParser = new InputParser();
        AllergenInput allergens = inputParser.parse(input);
        assertEquals(5, allergens.getAllergens().size());
        assertEquals(13, allergens.getIngredients().size());
    }

}
