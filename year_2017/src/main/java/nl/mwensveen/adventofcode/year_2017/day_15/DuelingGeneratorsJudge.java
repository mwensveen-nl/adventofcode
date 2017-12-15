package nl.mwensveen.adventofcode.year_2017.day_15;

import com.google.common.base.Strings;
import java.util.concurrent.RecursiveTask;

public class DuelingGeneratorsJudge extends RecursiveTask<Integer> {
    private static final int FACTOR_A = 16807;
    private static final int FACTOR_B = 48271;
    private static final int MULTIPLE_A = 4;
    private static final int MULTIPLE_B = 8;
    private static final long serialVersionUID = -1837516655277438446L;
    private long startA;
    private long startB;

    public DuelingGeneratorsJudge(long startA, long startB) {
        this.startA = startA;
        this.startB = startB;
    }

    @Override
    protected Integer compute() {
        int count = 0;
        long a = startA;
        long b = startB;
        for (int i = 0; i < 5_000_000; i++) {
            DuelingGeneratorsRecursiveTask taskA = new DuelingGeneratorsRecursiveTask(FACTOR_A, MULTIPLE_A, a);
            taskA.fork();
            DuelingGeneratorsRecursiveTask taskB = new DuelingGeneratorsRecursiveTask(FACTOR_B, MULTIPLE_B, b);
            b = taskB.compute();
            a = taskA.join();
            if (compare(a, b)) {
                count++;
            }
        }
        return count;
    }

    private boolean compare(long a, long b) {
        return Strings.commonSuffix(Long.toBinaryString(a), Long.toBinaryString(b)).length() >= 16;
    }

}
