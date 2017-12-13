package nl.mwensveen.adventofcode.year_2017.day_13;

public class Layer {
    private final int number;
    private final int depth;
    private final int onTop;

    public Layer(int number, int depth) {
        super();
        this.number = number;
        this.depth = depth;
        onTop = depth * 2 - 2;
    }

    public int getNumber() {
        return number;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isOnTop(int picoSecond) {
        return picoSecond % onTop == 0;
    }

}
