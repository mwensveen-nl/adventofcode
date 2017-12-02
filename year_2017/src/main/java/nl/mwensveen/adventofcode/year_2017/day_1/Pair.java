package nl.mwensveen.adventofcode.year_2017.day_1;

import com.google.common.base.MoreObjects;

public class Pair {
    private Integer one;
    private Integer two;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("one", one).add("two", two).toString();
    }

    public Pair(Integer one, Integer two) {
        this.one = one;
        this.two = two;
    }

    public Integer getOne() {
        return one;
    }

    public void setOne(Integer one) {
        this.one = one;
    }

    public Integer getTwo() {
        return two;
    }

    public void setTwo(Integer two) {
        this.two = two;
    }

    public boolean matches() {
        return one.equals(two);
    }
}