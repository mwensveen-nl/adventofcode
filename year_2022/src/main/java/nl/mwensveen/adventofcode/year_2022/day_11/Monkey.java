package nl.mwensveen.adventofcode.year_2022.day_11;

import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.List;

public class Monkey {
    private final Integer number;
    private final List<Integer> items;
    private final Operation operation;
    private final Integer testDivider;
    private final Integer testTrueMonkey;
    private final Integer testFalseMonkey;
    private int inspectedItems;

    public Integer getNumber() {
        return number;
    }

    public List<Integer> getItems() {
        return items;
    }

    public Operation getOperation() {
        return operation;
    }

    public Integer getTestDivider() {
        return testDivider;
    }

    public Integer getTestTrueMonkey() {
        return testTrueMonkey;
    }

    public Integer getTestFalseMonkey() {
        return testFalseMonkey;
    }

    public int getInspectedItems() {
        return inspectedItems;
    }

    private Monkey(Builder builder) {
        this.number = builder.number;
        this.items = builder.items;
        this.operation = builder.operation;
        this.testDivider = builder.testDivider;
        this.testTrueMonkey = builder.testTrueMonkey;
        this.testFalseMonkey = builder.testFalseMonkey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer number;
        private List<Integer> items = new ArrayList<Integer>();
        private Operation operation;
        private Integer testDivider;
        private Integer testTrueMonkey;
        private Integer testFalseMonkey;

        public Builder withNumber(Integer number) {
            this.number = number;
            return this;
        }

        public Builder withItems(List<Integer> items) {
            if (items == null) {
                throw new IllegalArgumentException("items is null");
            }
            this.items = items;
            return this;
        }

        public Builder addItems(List<Integer> itemsElements) {
            if (itemsElements == null) {
                throw new IllegalArgumentException("itemsElements is null");
            }
            this.items.addAll(itemsElements);
            return this;
        }

        public Builder addItems(Integer itemsElement) {
            this.items.add(itemsElement);
            return this;
        }

        public Builder withOperation(Operation operation) {
            this.operation = operation;
            return this;
        }

        public Builder withTestDivider(Integer testDivider) {
            this.testDivider = testDivider;
            return this;
        }

        public Builder withTestTrueMonkey(Integer testTrueMonkey) {
            this.testTrueMonkey = testTrueMonkey;
            return this;
        }

        public Builder withTestFalseMonkey(Integer testFalseMonkey) {
            this.testFalseMonkey = testFalseMonkey;
            return this;
        }

        public Monkey build() {
            return new Monkey(this);
        }
    }

    public void clearItems() {
        inspectedItems += items.size();
        items.clear();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("number", number).add("items", items).add("operation", operation).add("testDivider", testDivider).add("testTrueMonkey", testTrueMonkey)
                .add("testFalseMonkey", testFalseMonkey).add("inspectedItems", inspectedItems).toString();
    }

}
