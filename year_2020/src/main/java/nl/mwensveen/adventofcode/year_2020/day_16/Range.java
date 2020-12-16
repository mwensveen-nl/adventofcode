package nl.mwensveen.adventofcode.year_2020.day_16;

public class Range {

    private final int min;
    private final int max;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public boolean inRange(int value) {
        return min <= value && value <= max;
    }

    private Range(Builder builder) {
        this.min = builder.min;
        this.max = builder.max;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int min;
        private int max;

        public Builder withMin(int min) {
            this.min = min;
            return this;
        }

        public Builder withMax(int max) {
            this.max = max;
            return this;
        }

        public Range build() {
            return new Range(this);
        }
    }
}
