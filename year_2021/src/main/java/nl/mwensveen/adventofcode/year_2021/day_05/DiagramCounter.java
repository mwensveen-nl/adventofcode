package nl.mwensveen.adventofcode.year_2021.day_05;

import com.google.common.collect.Table;
import java.util.concurrent.atomic.AtomicInteger;

public class DiagramCounter {

    public long countPointsWithOverlap(Table<Integer, Integer, AtomicInteger> diagram) {
        return diagram.values().stream().filter(i -> i.get() > 1).count();
    }
}
