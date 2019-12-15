package nl.mwensveen.adventofcode.year_2019.day_14;

import com.google.common.base.Objects;

public class ChemicalAmount {
    private String chemical;
    private int amount;

    public ChemicalAmount(String chemical, int amount) {
        super();
        this.chemical = chemical;
        this.amount = amount;
    }

    public String getChemical() {
        return chemical;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof ChemicalAmount)) {
            return false;
        }
        ChemicalAmount castOther = (ChemicalAmount) other;
        return Objects.equal(amount, castOther.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }

    @Override
    public String toString() {
        return amount + "  " + chemical;
    }
}
