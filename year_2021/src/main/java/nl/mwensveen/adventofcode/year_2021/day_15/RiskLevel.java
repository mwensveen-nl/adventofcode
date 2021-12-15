package nl.mwensveen.adventofcode.year_2021.day_15;

import com.google.common.base.Objects;

public class RiskLevel {
    private final int row;
    private final int column;
    private final int risk;

    public RiskLevel(int row, int column, int risk) {
        this.row = row;
        this.column = column;
        this.risk = risk;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getRisk() {
        return risk;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }
        if (!getClass().equals(other.getClass())) {
            return false;
        }
        RiskLevel castOther = (RiskLevel) other;
        return Objects.equal(row, castOther.row) && Objects.equal(column, castOther.column) && Objects.equal(risk, castOther.risk);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(row, column, risk);
    }

}
