package nl.mwensveen.adventofcode.year_2017.day_15;

import com.google.common.base.Strings;
import java.util.concurrent.ForkJoinPool;

public class DuelingGenerators {
    private static final int FACTOR_A = 16807;
    private static final int FACTOR_B = 48271;
    private static final int DIVIDER = 2147483647;
    private final long startA;
    private final long startB;

    public DuelingGenerators(long startA, long startB) {
        this.startA = startA;
        this.startB = startB;
    }

    public long calculate() {
        int count = 0;
        long a = startA;
        long b = startB;
        for (int i = 0; i < 40_000_000; i++) {

            a = nextA(a);
            b = nextb(b);
            if (compare(a, b)) {
                count++;
            }
        }
        return count;
    }

    public long calculateWithCriteria() {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        DuelingGeneratorsJudge judge = new DuelingGeneratorsJudge(startA, startB);
        return commonPool.invoke(judge);
    }

    private boolean compare(long a, long b) {
        return Strings.commonSuffix(Long.toBinaryString(a), Long.toBinaryString(b)).length() >= 16;
    }

    private long nextb(long b) {
        return b * FACTOR_B % DIVIDER;
    }

    private long nextA(long a) {
        return a * FACTOR_A % DIVIDER;
    }

}
