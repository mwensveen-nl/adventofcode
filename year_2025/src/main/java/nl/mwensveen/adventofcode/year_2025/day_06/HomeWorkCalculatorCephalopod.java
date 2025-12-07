package nl.mwensveen.adventofcode.year_2025.day_06;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWorkCalculatorCephalopod {

    private int lastRow;

    public BigInteger calculate(List<List<String>> worksheet) {
        return worksheet.stream().map(this::calculateCol).reduce(BigInteger.ZERO, BigInteger::add);
    }

    private BigInteger calculateCol(List<String> col) {

        if ("+".equals(col.getLast().trim())) {
            return add(col);
        } else if ("*".equals(col.getLast().trim())) {
            return multiply(col);
        } else {
            throw new RuntimeException("invalid calculation " + col.get(lastRow));
        }
    }

    private BigInteger multiply(List<String> col) {
        List<BigInteger> newValues = modifyColl(col, "*");
        return newValues.stream().reduce(BigInteger.ONE, BigInteger::multiply);
    }

    private BigInteger add(List<String> col) {
        List<BigInteger> newValues = modifyColl(col, "+");
        return newValues.stream().reduce(BigInteger.ZERO, BigInteger::add);

    }

    private List<BigInteger> modifyColl(List<String> col, String operator) {
        Integer length = col.stream().map(String::length).max(Comparator.naturalOrder()).get();

        List<BigInteger> values = new ArrayList<>();
        for (int c = 0; c < length; c++) {
            final int i = c;
            String value = col.stream().filter(s -> !operator.equals(s.trim())).map(s -> s.substring(i, i + 1)).collect(Collectors.joining());
            values.add(new BigInteger(value.trim()));
        }
        return values;
    }
}
