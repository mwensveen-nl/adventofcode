package nl.mwensveen.adventofcode.year_2025.day_06;

import com.google.common.collect.Table;
import java.math.BigInteger;
import java.util.Map;
import java.util.stream.IntStream;

public class HomeWorkCalculator {

    private int lastRow;

    public BigInteger calculate(Table<Integer, Integer, String> worksheet) {
        lastRow = worksheet.rowKeySet().size() - 1;
        return IntStream.range(0, worksheet.columnKeySet().size())
                .mapToObj(i -> worksheet.column(i))
                .map(col -> calculateCol(col))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private BigInteger calculateCol(Map<Integer, String> col) {
        if ("+".equals(col.get(lastRow))) {
            return add(col);
        } else if ("*".equals(col.get(lastRow))) {
            return multiply(col);
        } else {
            throw new RuntimeException("invalid calculation " + col.get(lastRow));
        }
    }

    private BigInteger multiply(Map<Integer, String> col) {
        return col.values().stream()
                .filter(s -> !"*".equals(s))
                .map(BigInteger::new)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    private BigInteger add(Map<Integer, String> col) {
        return col.values().stream()
                .filter(s -> !"+".equals(s))
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add);

    }
}
