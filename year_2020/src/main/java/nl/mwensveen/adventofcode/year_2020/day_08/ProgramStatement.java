package nl.mwensveen.adventofcode.year_2020.day_08;

import com.google.common.base.MoreObjects;

public class ProgramStatement {

    private final Instruction instruction;
    private final int argument;

    public Instruction getInstruction() {
        return instruction;
    }

    public int getArgument() {
        return argument;
    }

    /**
     * Constructor that creates a ProgramStatement with the values of a ProgramStatement.Builder.
     */
    private ProgramStatement(Builder builder) {
        this.instruction = builder.instruction;
        this.argument = builder.argument;
    }

    /**
     * Creates a new {@link Builder} for {@link ProgramStatement} objects.
     *
     * @return a new Builder
     *
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * This class provides methods to build a {@link nl.mwensveen.adventofcode.year_2020.day_08.ProgramStatement}.
     */
    public static class Builder {
        private Instruction instruction;
        private int argument;

        /**
         * Sets the {@link #instruction} property of this builder
         *
         * @param instruction
         * @return this builder
         */
        public Builder withInstruction(Instruction instruction) {
            this.instruction = instruction;
            return this;
        }

        /**
         * Sets the {@link #argument} property of this builder
         *
         * @param argument
         * @return this builder
         */
        public Builder withArgument(int argument) {
            this.argument = argument;
            return this;
        }

        /**
         * Creates a new {@link ProgramStatement} based on this Builder.
         *
         * @return a new ProgramStatement
         */
        public ProgramStatement build() {
            return new ProgramStatement(this);
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("instruction", instruction).add("argument", argument).toString();
    }
}
