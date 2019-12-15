package nl.mwensveen.adventofcode.year_2019.day_14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormulaParser {

    Map<String, Formula> parse(List<String> input) {
        Map<String, Formula> output = new HashMap<>();

        input.forEach(s -> parseFormula(output, s));
        return output;
    }

    private void parseFormula(Map<String, Formula> output, String s) {
        String[] split = s.split("=>");
        ChemicalAmount chemicalAmout = parseChemicalAmout(split[1]);
        Formula f = new Formula(chemicalAmout);
        output.put(f.getResult().getChemical(), f);

        String[] ingredients = split[0].split(",");
        for (int i = 0; i < ingredients.length; i++) {
            String string = ingredients[i];
            ChemicalAmount ca = parseChemicalAmout(string);
            f.getIngredients().add(ca);
        }
        return;
    }

    private ChemicalAmount parseChemicalAmout(String string) {
        String s = string.trim();
        String[] strings = s.split(" ");
        int amount = Integer.parseInt(strings[0]);
        String chemical = strings[1];
        ChemicalAmount ca = new ChemicalAmount(chemical, amount);
        return ca;

    }
}
