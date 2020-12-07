package nl.mwensveen.adventofcode.year_2020.day_07;

public class BagContents {
    private final String color;
    private final int number;

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    private BagContents(Builder builder) {
        this.color = builder.color;
        this.number = builder.number;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String color;
        private int number;

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withNumber(int number) {
            this.number = number;
            return this;
        }

        public BagContents build() {
            return new BagContents(this);
        }
    }
}
