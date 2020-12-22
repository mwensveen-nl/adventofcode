package nl.mwensveen.adventofcode.year_2020.day_21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AllergenProcessorTest {

    @Test
    public void findIngredentsOfAllergens() throws Exception {
        List<String> input = Arrays.asList("mxmxvkd kfcds sqjhc nhms (contains dairy, fish)", "trh fvjkl sbzzf mxmxvkd (contains dairy)",
                "sqjhc fvjkl (contains soy)", "sqjhc mxmxvkd sbzzf (contains fish)");
        InputParser inputParser = new InputParser();
        AllergenInput allergenInput = inputParser.parse(input);

        List<Allergen> allergens = allergenInput.getAllergens();

        AllergenProcessor allergenProcessor = new AllergenProcessor();
        List<String> result = allergenProcessor.findIngredentsOfAllergens(allergens);

        assertEquals(3, result.size());
        assertTrue(result.contains("mxmxvkd"));
        assertTrue(result.contains("sqjhc"));
        assertTrue(result.contains("fvjkl"));

    }

    @Test
    public void testFindAllergens() throws Exception {
        List<String> input = Arrays.asList("mxmxvkd kfcds sqjhc nhms (contains dairy, fish)", "trh fvjkl sbzzf mxmxvkd (contains dairy)",
                "sqjhc fvjkl (contains soy)", "sqjhc mxmxvkd sbzzf (contains fish)");
        InputParser inputParser = new InputParser();
        AllergenInput allergenInput = inputParser.parse(input);

        List<Allergen> allergens = allergenInput.getAllergens();

        AllergenProcessor allergenProcessor = new AllergenProcessor();
        List<Allergen> result = allergenProcessor.findAllergens(allergens);
        assertEquals(3, result.size());
    }

}
