package nl.mwensveen.adventofcode.year_2020.day_16;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private final String name;
    private final List<Range> ranges;

    public String getName() {
        return name;
    }

    public List<Range> getRanges() {
        return ranges;
    }

    private Field(Builder builder) {
        this.name = builder.name;
        this.ranges = builder.ranges;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private List<Range> ranges = new ArrayList<>();

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withRanges(List<Range> ranges) {
            if (ranges == null) {
                throw new IllegalArgumentException("ranges is null");
            }
            this.ranges = ranges;
            return this;
        }

        public Builder addRanges(List<Range> rangesElements) {
            if (rangesElements == null) {
                throw new IllegalArgumentException("rangesElements is null");
            }
            this.ranges.addAll(rangesElements);
            return this;
        }

        public Builder addRanges(Range rangesElement) {
            this.ranges.add(rangesElement);
            return this;
        }

        public Field build() {
            return new Field(this);
        }
    }
}
