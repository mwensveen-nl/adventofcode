package nl.mwensveen.adventofcode.year_2017.day_2;

public class Duo {
    private final Integer one;
    private final Integer two;

    public Duo(Integer one, Integer two) {
        super();
        this.one = one;
        this.two = two;
    }

    public Integer getOne() {
        return one;
    }

    public Integer getTwo() {
        return two;
    }

    public boolean evenlyDivide() {
        return max() % min() == 0;
    }

    public int devide() {
        return max() / min();
    }

    private int max() {
        return Math.max(one.intValue(), two.intValue());
    }

    private int min() {
        return Math.min(one.intValue(), two.intValue());
    }
}
