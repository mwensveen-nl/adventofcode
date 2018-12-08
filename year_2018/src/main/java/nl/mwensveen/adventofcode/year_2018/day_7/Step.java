package nl.mwensveen.adventofcode.year_2018.day_7;

import com.google.common.base.MoreObjects;
import java.util.HashSet;
import java.util.Set;

public class Step {
    private static final char CHAR_A = 'A';
    private static final int INT_A = CHAR_A;
    private final String name;
    private final Set<Step> beforeSteps = new HashSet<>();
    private boolean done = false;
    private int executionTimeLeft;
    private boolean executionStarted;

    public Step(String name) {
        this.name = name.toUpperCase();
        int charAt = name.charAt(0);
        executionTimeLeft = charAt - INT_A + 1;
    }

    public String getName() {
        return name;
    }

    public Set<Step> getBeforeSteps() {
        return beforeSteps;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        this.done = true;
    }

    public boolean isReadyForExecution() {
        return !done && !executionStarted && beforeSteps.stream().filter(Step::isDone).count() == beforeSteps.size();
    }

    public void startExecution(int defaultTime) {
        executionTimeLeft = executionTimeLeft + defaultTime;
        executionStarted = true;
    }

    public void decreaseExecutionTime() {
        executionTimeLeft--;
    }

    public void executionSecondPassed() {
        executionTimeLeft--;
        if (executionTimeLeft <= 0) {
            setDone();
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).add("done", done).add("executionTimeLeft", executionTimeLeft).toString();
    }
}
