package nl.mwensveen.adventofcode.year_2020.day_05;

public class SeatIDCalculator {

    private RowCalculator rowCalculator = new RowCalculator();
    private ColumnCalculator columnCalculator = new ColumnCalculator();

    public int calcSeatId(String code) {
        int r = rowCalculator.determineRow(code.substring(0, 7));
        int c = columnCalculator.determineColumn(code.substring(7));
        return r * 8 + c;
    }
}
