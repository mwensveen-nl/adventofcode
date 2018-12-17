package nl.mwensveen.adventofcode.year_2018.day_11;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FuelCellGridAnalyser {

    private static final int GRID_SIZE = 300;
    private int gridSerialNumber;

    public FuelCellGridAnalyser(int gridSerialNumber) {
        this.gridSerialNumber = gridSerialNumber;
    }

    public List<Integer> analyse3x3() {
        Table<Integer, Integer, Integer> grid = HashBasedTable.create();

        AtomicInteger topX = new AtomicInteger(0);
        AtomicInteger topY = new AtomicInteger(0);
        AtomicInteger maxPower = new AtomicInteger(0);

        IntStream.rangeClosed(1, GRID_SIZE - 2).forEach(x -> IntStream.rangeClosed(1, GRID_SIZE - 2).forEach(y -> {
            int p = getPowerOfSquare(x, y, grid, 3);
            if (maxPower.get() < p) {
                maxPower.set(p);
                topX.set(x);
                topY.set(y);
            }
        }));

        return Arrays.asList(topX.get(), topY.get(), maxPower.get());
    }

    public List<Integer> analyseAnySize() {
        Table<Integer, Integer, Integer> grid = HashBasedTable.create();

        AtomicInteger topX = new AtomicInteger(0);
        AtomicInteger topY = new AtomicInteger(0);
        AtomicInteger squareSize = new AtomicInteger(0);
        AtomicInteger maxPower = new AtomicInteger(Integer.MIN_VALUE);

        IntStream.rangeClosed(1, GRID_SIZE).forEach(x -> IntStream.rangeClosed(1, GRID_SIZE).forEach(y -> {
            AtomicInteger curPower = new AtomicInteger(0);
            IntStream.rangeClosed(1, GRID_SIZE + 1 - Math.max(x, y)).forEach(size -> {
                // System.out.println(x + " " + y + " " + size);
                int p = curPower.addAndGet(getPowerOfRowAndColumn(x, y, grid, size));
                if (maxPower.get() < p) {
                    maxPower.set(p);
                    topX.set(x);
                    topY.set(y);
                    squareSize.set(size);
                }
            });
        }));

        return Arrays.asList(topX.get(), topY.get(), squareSize.get(), maxPower.get());
    }

    private int getPowerOfRowAndColumn(int x, int y, Table<Integer, Integer, Integer> grid, int size) {
        return IntStream.rangeClosed(y, y + size - 1).map(y2 -> getOrSet(x + size - 1, y2, grid)).sum()
                + IntStream.rangeClosed(x, x + size - 2).map(x2 -> getOrSet(x2, y + size - 1, grid)).sum();
    }

    private int getPowerOfSquare(int x, int y, Table<Integer, Integer, Integer> grid, int squareSize) {
        if (x + squareSize > GRID_SIZE || y + squareSize > GRID_SIZE) {
            return 0;
        }
        return IntStream.rangeClosed(x, x + squareSize - 1).map(x2 -> IntStream.rangeClosed(y, y + squareSize - 1).map(y2 -> getOrSet(x2, y2, grid)).sum())
                .sum();
    }

    private int getOrSet(int x2, int y2, Table<Integer, Integer, Integer> grid) {
        // System.out.println(" " + x2 + " " + y2);
        if (grid.contains(x2, y2)) {
            return grid.get(x2, y2);
        }

        int power = PowerCalculator.calculate(x2, y2, gridSerialNumber);
        grid.put(x2, y2, power);
        return power;
    }
}
