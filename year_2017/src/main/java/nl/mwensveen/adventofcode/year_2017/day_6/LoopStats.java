package nl.mwensveen.adventofcode.year_2017.day_6;

public class LoopStats {
    private final int loopCounter;

    private final int loopSize;

    public LoopStats(int loopCounter, int loopSize) {
        super();
        this.loopCounter = loopCounter;
        this.loopSize = loopSize;
    }

    @Override
    public String toString() {
        return "Counter: " + loopCounter + "\nSize: " + loopSize;
    }

    public int getLoopCounter() {
        return loopCounter;
    }

    public int getLoopSize() {
        return loopSize;
    }
}
