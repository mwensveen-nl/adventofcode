package nl.mwensveen.adventofcode.year_2020.day_12;

import com.google.common.base.MoreObjects;

public class Instruction {
    private final Direction action;
    private final Integer value;

    public Direction getAction() {
        return action;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("action", action).add("value", value).toString();
    }

    /**
     * Constructor that creates a Instruction with the values of a Instruction.Builder.
     */
    private Instruction(Builder builder) {
        this.action = builder.actions;
        this.value = builder.value;
    }

    /**
     * Creates a new {@link Builder} for {@link Instruction} objects.
     *
     * @return a new Builder
     *
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * This class provides methods to build a {@link nl.mwensveen.adventofcode.year_2020.day_12.Instruction}.
     */
    public static class Builder {
        private Direction actions;
        private Integer value;

        /**
         * Sets the {@link #action} property of this builder
         *
         * @param action
         * @return this builder
         */
        public Builder withActions(Direction actions) {
            this.actions = actions;
            return this;
        }

        /**
         * Sets the {@link #value} property of this builder
         *
         * @param value
         * @return this builder
         */
        public Builder withValue(Integer value) {
            this.value = value;
            return this;
        }

        /**
         * Creates a new {@link Instruction} based on this Builder.
         *
         * @return a new Instruction
         */
        public Instruction build() {
            return new Instruction(this);
        }
    }
}
