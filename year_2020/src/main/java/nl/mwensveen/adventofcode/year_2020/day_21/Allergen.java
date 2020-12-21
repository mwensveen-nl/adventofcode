package nl.mwensveen.adventofcode.year_2020.day_21;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Allergen {
    private final String name;
    private List<String> possibleCode;

    public void setPossibleCode(List<String> possibleCode) {
        this.possibleCode = possibleCode;
    }

    public String getName() {
        return name;
    }

    public List<String> getPossibleCode() {
        return possibleCode;
    }

    /**
     * Constructor that creates a Allergen with the values of a Allergen.Builder.
     */
    private Allergen(Builder builder) {
        this.name = builder.name;
        this.possibleCode = builder.possibleCode;
    }

    /**
     * Creates a new {@link Builder} for {@link Allergen} objects.
     *
     * @return a new Builder
     *
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * This class provides methods to build a {@link nl.mwensveen.adventofcode.year_2020.day_21.Allergen}.
     */
    public static class Builder {
        private String name;
        private List<String> possibleCode = new ArrayList<>();

        /**
         * Sets the {@link #name} property of this builder
         *
         * @param name
         * @return this builder
         */
        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the {@link #possibleCode} property of this builder
         *
         * @param possibleCode
         * @return this builder
         */
        public Builder withPossibleCode(List<String> possibleCode) {
            if (possibleCode == null) {
                throw new IllegalArgumentException("possibleCode is null");
            }
            this.possibleCode = possibleCode;
            return this;
        }

        /**
         * Sets the {@link #possibleCode} property of this builder
         *
         * @param possibleCode
         * @return this builder
         * @throws IllegalArgumentException if possibleCode is null or contains a null element
         */
        public Builder withPossibleCode(String... possibleCode) {
            if (possibleCode == null) {
                throw new IllegalArgumentException("possibleCode is null");
            }
            this.possibleCode = new ArrayList<>();
            Collections.addAll(this.possibleCode, possibleCode);
            return this;
        }

        /**
         * Adds to the {@link #possibleCode} property of this builder
         *
         * @param possibleCode
         * @return this builder
         * @throws IllegalArgumentException if possibleCode is null or contains a null element
         */
        public Builder addPossibleCode(List<String> possibleCodeElements) {
            if (possibleCodeElements == null) {
                throw new IllegalArgumentException("possibleCodeElements is null");
            }
            this.possibleCode.addAll(possibleCodeElements);
            return this;
        }

        /**
         * Adds to the {@link #possibleCode} property of this builder
         *
         * @param possibleCode
         * @return this builder
         * @throws IllegalArgumentException if possibleCode is null or contains a null element
         */
        public Builder addPossibleCode(String... possibleCodeElements) {
            if (possibleCodeElements == null) {
                throw new IllegalArgumentException("possibleCodeElements is null");
            }
            Collections.addAll(this.possibleCode, possibleCodeElements);
            return this;
        }

        /**
         * Adds to the {@link #possibleCode} property of this builder
         *
         * @param possibleCode
         * @return this builder
         * @throws IllegalArgumentException if possibleCode is null or contains a null element
         */
        public Builder addPossibleCode(String possibleCodeElement) {
            this.possibleCode.add(possibleCodeElement);
            return this;
        }

        /**
         * Creates a new {@link Allergen} based on this Builder.
         *
         * @return a new Allergen
         */
        public Allergen build() {
            return new Allergen(this);
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", name).add("possibleCode", possibleCode).toString();
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Allergen)) {
            return false;
        }
        Allergen castOther = (Allergen) other;
        return Objects.equal(name, castOther.name) && Objects.equal(possibleCode, castOther.possibleCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, possibleCode);
    }
}
