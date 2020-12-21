package nl.mwensveen.adventofcode.year_2020.day_21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class AllergenParserTest {

    @Test
    public void testParse() throws Exception {
        String input = "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)";
        AllergenParser allergenParser = new AllergenParser();
        List<Allergen> list = allergenParser.parse(input);
        assertEquals(2, list.size());

        Allergen allergen = list.get(0);
        assertEquals("dairy", allergen.getName());
        assertEquals(4, allergen.getPossibleCode().size());
        assertTrue(allergen.getPossibleCode().contains("mxmxvkd"));
        assertTrue(allergen.getPossibleCode().contains("kfcds"));
        assertTrue(allergen.getPossibleCode().contains("sqjhc"));
        assertTrue(allergen.getPossibleCode().contains("nhms"));

        allergen = list.get(1);
        assertEquals("fish", allergen.getName());
        assertEquals(4, allergen.getPossibleCode().size());
        assertTrue(allergen.getPossibleCode().contains("mxmxvkd"));
        assertTrue(allergen.getPossibleCode().contains("kfcds"));
        assertTrue(allergen.getPossibleCode().contains("sqjhc"));
        assertTrue(allergen.getPossibleCode().contains("nhms"));
    }

    @Test
    public void testParse2() throws Exception {
        String input = "trh fvjkl sbzzf mxmxvkd (contains dairy)";
        AllergenParser allergenParser = new AllergenParser();
        List<Allergen> list = allergenParser.parse(input);
        assertEquals(1, list.size());

        Allergen allergen = list.get(0);
        assertEquals("dairy", allergen.getName());
        assertEquals(4, allergen.getPossibleCode().size());
        assertTrue(allergen.getPossibleCode().contains("trh"));
        assertTrue(allergen.getPossibleCode().contains("fvjkl"));
        assertTrue(allergen.getPossibleCode().contains("sbzzf"));
        assertTrue(allergen.getPossibleCode().contains("mxmxvkd"));
    }

}
