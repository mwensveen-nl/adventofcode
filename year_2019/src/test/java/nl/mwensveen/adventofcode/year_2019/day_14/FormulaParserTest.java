package nl.mwensveen.adventofcode.year_2019.day_14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class FormulaParserTest {

    @Test
    public void testParse() throws Exception {
        FormulaParser parser = new FormulaParser();
        List<String> input = Arrays.asList("3 A, 4 B => 1 AB", "2 AB, 3 BC, 4 CA => 1 FUEL", "9 ORE => 2 A");

        Map<String, Formula> output = parser.parse(input);

        assertEquals(3, output.keySet().size());

        Formula formula = output.get("FUEL");
        assertNotNull(formula);
        assertEquals("FUEL", formula.getResult().getChemical());
        assertEquals(1, formula.getResult().getAmount());
        assertEquals(3, formula.getIngredients().size());
        assertEquals(2, formula.getIngredients().get(0).getAmount());
        assertEquals("AB", formula.getIngredients().get(0).getChemical());
        assertEquals(3, formula.getIngredients().get(1).getAmount());
        assertEquals("BC", formula.getIngredients().get(1).getChemical());
        assertEquals(4, formula.getIngredients().get(2).getAmount());
        assertEquals("CA", formula.getIngredients().get(2).getChemical());

        formula = output.get("AB");
        assertNotNull(formula);
        assertEquals("AB", formula.getResult().getChemical());
        assertEquals(1, formula.getResult().getAmount());
        assertEquals(2, formula.getIngredients().size());
        assertEquals(3, formula.getIngredients().get(0).getAmount());
        assertEquals("A", formula.getIngredients().get(0).getChemical());
        assertEquals(4, formula.getIngredients().get(1).getAmount());
        assertEquals("B", formula.getIngredients().get(1).getChemical());

        formula = output.get("A");
        assertNotNull(formula);
        assertEquals("A", formula.getResult().getChemical());
        assertEquals(2, formula.getResult().getAmount());
        assertEquals(1, formula.getIngredients().size());
        assertEquals(9, formula.getIngredients().get(0).getAmount());
        assertEquals("ORE", formula.getIngredients().get(0).getChemical());
    }

}
