package nl.mwensveen.adventofcode.year_2018.day_18;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class LumberCollection {
    private Table<Long, Long, AcreContent> area = HashBasedTable.create();

    public LumberCollection(List<String> input) {
        StreamUtils.zipWithIndex(input.stream()).forEach(ys -> StreamUtils.zipWithIndex(ys.getValue().chars().mapToObj(i -> Character.toString((char) i)))
                .forEach(xc -> area.put(xc.getIndex(), ys.getIndex(), AcreContent.valueFromSymbol(xc.getValue()))));
        printArea();
    }

    public long performMagicChanges(int minutes) {
        IntStream.range(0, minutes).forEach(i -> changeArea(i));
        long countTrees = area.cellSet().stream().filter(c -> c.getValue() == AcreContent.TREES).count();
        long countLumber = area.cellSet().stream().filter(c -> c.getValue() == AcreContent.LUMBER).count();
        return countLumber * countTrees;
    }

    private void changeArea(int minute) {
        Table<Long, Long, AcreContent> newArea = HashBasedTable.create();
        area.columnKeySet().forEach(x -> area.column(x).keySet().forEach(y -> newArea.put(x, y, changeAcre(x, y))));
        area = newArea;
        // output for part 2: discover repeat.
        long countTrees = area.cellSet().stream().filter(c -> c.getValue() == AcreContent.TREES).count();
        long countLumber = area.cellSet().stream().filter(c -> c.getValue() == AcreContent.LUMBER).count();
        System.out.println(minute + " : " + countTrees + " * " + countLumber + " = " + countTrees * countLumber);
    }

    private AcreContent changeAcre(Long x, Long y) {
        AcreContent content = area.get(x, y);
        switch (content) {
            case LUMBER:
                return changeLumber(x, y);
            case OPEN:
                return changeOpen(x, y);
            case TREES:
                return changeTrees(x, y);
        }
        return null;
    }

    private AcreContent changeTrees(Long x, Long y) {
        AtomicInteger count = new AtomicInteger(0);
        IntStream.rangeClosed(-1, 1).forEach(xAdd -> IntStream.rangeClosed(-1, 1).forEach(yAdd -> {
            if (xAdd != 0 || yAdd != 0) {
                AcreContent acreContent = area.get(x + xAdd, y + yAdd);
                if (AcreContent.LUMBER == acreContent) {
                    count.incrementAndGet();
                }
            }
        }));
        return count.get() >= 3 ? AcreContent.LUMBER : AcreContent.TREES;
    }

    private AcreContent changeOpen(Long x, Long y) {
        AtomicInteger count = new AtomicInteger(0);
        IntStream.rangeClosed(-1, 1).forEach(xAdd -> IntStream.rangeClosed(-1, 1).forEach(yAdd -> {
            if (xAdd != 0 || yAdd != 0) {
                if (AcreContent.TREES == area.get(x + xAdd, y + yAdd)) {
                    count.incrementAndGet();
                }
            }
        }));
        return count.get() >= 3 ? AcreContent.TREES : AcreContent.OPEN;
    }

    private AcreContent changeLumber(Long x, Long y) {
        AtomicInteger countLumber = new AtomicInteger(0);
        AtomicInteger countTrees = new AtomicInteger(0);
        IntStream.rangeClosed(-1, 1).forEach(xAdd -> IntStream.rangeClosed(-1, 1).forEach(yAdd -> {
            if (xAdd != 0 || yAdd != 0) {
                if (AcreContent.LUMBER == area.get(x + xAdd, y + yAdd)) {
                    countLumber.incrementAndGet();
                }
                if (AcreContent.TREES == area.get(x + xAdd, y + yAdd)) {
                    countTrees.incrementAndGet();
                }
            }
        }));
        return countLumber.get() >= 1 && countTrees.get() >= 1 ? AcreContent.LUMBER : AcreContent.OPEN;
    }

    private void printArea() {
        System.out.println();
        area.columnKeySet().forEach(i -> {
            area.column(i).values().forEach(ac -> System.out.print(ac.getSymbol()));
            System.out.println();
        });

    }
}
