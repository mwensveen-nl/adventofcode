package nl.mwensveen.adventofcode.year_2017.day_15;

import java.util.concurrent.RecursiveTask;

public class DuelingGeneratorsRecursiveTask extends RecursiveTask<Long> {
    private static final long serialVersionUID = -1591382401594928679L;
    private int factor;
    private int multiple;
    private long start;
    private static final int DIVIDER = 2147483647;

    public DuelingGeneratorsRecursiveTask(int factor, int multiple, long start) {
        this.factor = factor;
        this.multiple = multiple;
        this.start = start;
    }

    @Override
    protected Long compute() {
        long l = start * factor % DIVIDER;
        while (l % multiple != 0) {
            l = l * factor % DIVIDER;
        }
        return l;
    }

}
