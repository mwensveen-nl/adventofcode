package nl.mwensveen.adventofcode.year_2022.day_11;

import com.google.common.base.MoreObjects;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Monkey {
    private final Integer number;
    private List<BigInteger> items;
    private final Function<BigInteger, BigInteger> operation;
    private final BigInteger testDivider;
    private final int testTrueMonkey;
    private final int testFalseMonkey;
    private long inspectedItems;

    public Integer getNumber() {
        return number;
    }

    public List<BigInteger> getItems() {
        return items;
    }

    public Function<BigInteger, BigInteger> getOperation() {
        return operation;
    }

    public BigInteger getTestDivider() {
        return testDivider;
    }

    public Integer getTestTrueMonkey() {
        return testTrueMonkey;
    }

    public Integer getTestFalseMonkey() {
        return testFalseMonkey;
    }

    public long getInspectedItems() {
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
        private List<BigInteger> items = new ArrayList<BigInteger>();
        private Function<BigInteger, BigInteger> operation;
        private BigInteger testDivider;
        private Integer testTrueMonkey;
        private Integer testFalseMonkey;

        public Builder withNumber(Integer number) {
            this.number = number;
            return this;
        }

        public Builder withItems(List<BigInteger> items) {
            if (items == null) {
                throw new IllegalArgumentException("items is null");
            }
            this.items = items;
            return this;
        }

        public Builder addItems(BigInteger itemsElement) {
            this.items.add(itemsElement);
            return this;
        }

        public Builder withOperation(Function<BigInteger, BigInteger> operation) {
            this.operation = operation;
            return this;
        }

        public Builder withTestDivider(BigInteger testDivider) {
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
        items = new ArrayList<>();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("number", number).add("items", items).add("operation", operation).add("testDivider", testDivider).add("testTrueMonkey", testTrueMonkey)
                .add("testFalseMonkey", testFalseMonkey).add("inspectedItems", inspectedItems).toString();
    }

}
