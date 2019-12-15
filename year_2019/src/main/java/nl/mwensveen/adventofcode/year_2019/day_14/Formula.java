package nl.mwensveen.adventofcode.year_2019.day_14;

import java.util.ArrayList;
import java.util.List;

public class Formula {
    private ChemicalAmount result;
    private List<ChemicalAmount> ingredients = new ArrayList<>();

    public Formula(ChemicalAmount result) {
        super();
        this.result = result;
    }

    public ChemicalAmount getResult() {
        return result;
    }

    public List<ChemicalAmount> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Formula [" + result + " => " + ingredients;
    }

}
