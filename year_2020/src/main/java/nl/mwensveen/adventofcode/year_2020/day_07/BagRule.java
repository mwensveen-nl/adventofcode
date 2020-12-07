package nl.mwensveen.adventofcode.year_2020.day_07;

import java.util.ArrayList;
import java.util.List;

public class BagRule {
    private final String color;
    private final List<BagContents> contains;

    public String getColor() {
        return color;
    }

    public List<BagContents> getContains() {
        return contains;
    }

    private BagRule(Builder builder) {
        this.color = builder.color;
        this.contains = builder.contains;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String color;
        private List<BagContents> contains = new ArrayList<>();

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withContains(List<BagContents> contains) {
            if (contains == null) {
                throw new IllegalArgumentException("contains is null");
            }
            this.contains = contains;
            return this;
        }

        public Builder addContains(List<BagContents> containsElements) {
            if (containsElements == null) {
                throw new IllegalArgumentException("containsElements is null");
            }
            this.contains.addAll(containsElements);
            return this;
        }

        public Builder addContains(BagContents containsElement) {
            this.contains.add(containsElement);
            return this;
        }

        public BagRule build() {
            return new BagRule(this);
        }
    }

    public boolean containsColor(String color2) {
        for (BagContents bagContents : contains) {
            if (bagContents.getColor().equals(color2)) {
                return true;
            }
        }
        return false;
    }
}
