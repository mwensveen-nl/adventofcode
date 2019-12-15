package nl.mwensveen.adventofcode.year_2019.day_14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class FuelProductionCalculator {
    private boolean hasMaxOre = false;

    public int caluclateOre(List<String> input) {
        FormulaParser formulaParser = new FormulaParser();
        Map<String, Formula> formulas = formulaParser.parse(input);

        Map<String, AtomicInteger> stock = new HashMap<>();
        AtomicLong amountOre = new AtomicLong(0);

        Formula fuelFormula = formulas.get("FUEL");
        fuelFormula.getIngredients().forEach(ca -> aquire(ca.getChemical(), ca.getAmount(), formulas, stock, amountOre));

        return amountOre.intValue();
    }

    public int caluclateFuel(List<String> input, long stockOfOre) {
        FormulaParser formulaParser = new FormulaParser();
        Map<String, Formula> formulas = formulaParser.parse(input);

        Map<String, AtomicInteger> stock = new HashMap<>();
        AtomicLong amountOre = new AtomicLong(stockOfOre);
        hasMaxOre = true;
        Formula fuelFormula = formulas.get("FUEL");
        int amountFuel = 0;
        while (amountOre.longValue() > 0) {
            fuelFormula.getIngredients().forEach(ca -> aquire(ca.getChemical(), ca.getAmount(), formulas, stock, amountOre));
            if (amountOre.longValue() > 0) {
                amountFuel++;
                System.out.println("Fuel " + amountFuel);
            }
        }
        return amountFuel;
    }

    private void aquire(String chemicalToAquire, int amountToAquire, Map<String, Formula> formulas, Map<String, AtomicInteger> stock, AtomicLong amountOre) {
        if (chemicalToAquire.equals("ORE")) {
            if (hasMaxOre) {
                amountOre.addAndGet(-amountToAquire);
            } else {
                amountOre.addAndGet(amountToAquire);
            }
            return;
        }

        produceNewChemical(chemicalToAquire, amountToAquire, formulas, stock, amountOre);
        return;
    }

    private void produceNewChemical(String chemicalToAquire, int amountToAquire, Map<String, Formula> formulas, Map<String, AtomicInteger> stock,
            AtomicLong amountOre) {
        if (hasMaxOre && amountOre.longValue() <= 0) {
            return;
        }

        int notInStock = getFromStock(chemicalToAquire, amountToAquire, stock);
        if (notInStock > 0) {
            Formula formula = formulas.get(chemicalToAquire);
            int numberOfFormula = calc(notInStock, formula.getResult().getAmount());
            int amountFromFormula = numberOfFormula * formula.getResult().getAmount();
            putInStock(amountFromFormula - notInStock, chemicalToAquire, stock);
            for (int i = 0; i < numberOfFormula; i++) {
                formula.getIngredients().forEach(ca -> aquire(ca.getChemical(), ca.getAmount(), formulas, stock, amountOre));
            }
        }
    }

    private int calc(int required, int formulaAmount) {

        double a = (0.0 + required) / formulaAmount;
        // double ceil = Math.ceil(a);
        // return (int) ceil * ingredient.getAmount();
        double ceil = Math.ceil(a);
        return (int) ceil;
    }

    private int getFromStock(String chemicalToAquire, int amountToAquire, Map<String, AtomicInteger> stock) {
        if (stock.containsKey(chemicalToAquire)) {
            AtomicInteger stockForChemical = stock.get(chemicalToAquire);
            if (stockForChemical.intValue() >= amountToAquire) {
                stockForChemical.addAndGet(-amountToAquire);
                return 0;
            }
            int notInStock = amountToAquire - stockForChemical.intValue();
            stockForChemical.set(0);
            return notInStock;
        }
        AtomicInteger newStock = new AtomicInteger(0);
        stock.put(chemicalToAquire, newStock);
        return amountToAquire;
    }

    private void putInStock(int amount, String chemical, Map<String, AtomicInteger> stock) {
        if (stock.containsKey(chemical)) {
            stock.get(chemical).addAndGet(amount);
        } else {
            stock.put(chemical, new AtomicInteger(amount));
        }

    }
}
