package nl.mwensveen.adventofcode.year_2020.day_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllergenInput {

    private final List<Allergen> allergens;
    private final List<String> ingredients;

    /**
     * Constructor that creates a AllergenInput with the values of a AllergenInput.Builder.
     */
    private AllergenInput(Builder builder) {
        this.allergens = builder.allergens;
        this.ingredients = builder.ingredients;
    }

    public List<Allergen> getAllergens() {
        return allergens;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    /**
     * Creates a new {@link Builder} for {@link AllergenInput} objects.
     *
     * @return a new Builder
     * 
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * This class provides methods to build a {@link nl.mwensveen.adventofcode.year_2020.day_21.AllergenInput}.
     */
    public static class Builder {
        private List<Allergen> allergens = new ArrayList<>();
        private List<String> ingredients = new ArrayList<>();

        /**
         * Sets the {@link #allergens} property of this builder
         *
         * @param allergens
         * @return this builder
         */
        public Builder withAllergens(List<Allergen> allergens) {
            if (allergens == null) {
                throw new IllegalArgumentException("allergens is null");
            }
            this.allergens = allergens;
            return this;
        }

        /**
         * Sets the {@link #allergens} property of this builder
         *
         * @param allergens
         * @return this builder
         * @throws IllegalArgumentException if allergens is null or contains a null element
         */
        public Builder withAllergens(Allergen... allergens) {
            if (allergens == null) {
                throw new IllegalArgumentException("allergens is null");
            }
            this.allergens = new ArrayList<>();
            Collections.addAll(this.allergens, allergens);
            return this;
        }

        /**
         * Adds to the {@link #allergens} property of this builder
         *
         * @param allergens
         * @return this builder
         * @throws IllegalArgumentException if allergens is null or contains a null element
         */
        public Builder addAllergens(List<Allergen> allergensElements) {
            if (allergensElements == null) {
                throw new IllegalArgumentException("allergensElements is null");
            }
            this.allergens.addAll(allergensElements);
            return this;
        }

        /**
         * Adds to the {@link #allergens} property of this builder
         *
         * @param allergens
         * @return this builder
         * @throws IllegalArgumentException if allergens is null or contains a null element
         */
        public Builder addAllergens(Allergen... allergensElements) {
            if (allergensElements == null) {
                throw new IllegalArgumentException("allergensElements is null");
            }
            Collections.addAll(this.allergens, allergensElements);
            return this;
        }

        /**
         * Adds to the {@link #allergens} property of this builder
         *
         * @param allergens
         * @return this builder
         * @throws IllegalArgumentException if allergens is null or contains a null element
         */
        public Builder addAllergens(Allergen allergensElement) {
            this.allergens.add(allergensElement);
            return this;
        }

        /**
         * Sets the {@link #ingredients} property of this builder
         *
         * @param ingredients
         * @return this builder
         */
        public Builder withIngredients(List<String> ingredients) {
            if (ingredients == null) {
                throw new IllegalArgumentException("ingredients is null");
            }
            this.ingredients = ingredients;
            return this;
        }

        /**
         * Sets the {@link #ingredients} property of this builder
         *
         * @param ingredients
         * @return this builder
         * @throws IllegalArgumentException if ingredients is null or contains a null element
         */
        public Builder withIngredients(String... ingredients) {
            if (ingredients == null) {
                throw new IllegalArgumentException("ingredients is null");
            }
            this.ingredients = new ArrayList<>();
            Collections.addAll(this.ingredients, ingredients);
            return this;
        }

        /**
         * Adds to the {@link #ingredients} property of this builder
         *
         * @param ingredients
         * @return this builder
         * @throws IllegalArgumentException if ingredients is null or contains a null element
         */
        public Builder addIngredients(List<String> ingredientsElements) {
            if (ingredientsElements == null) {
                throw new IllegalArgumentException("ingredientsElements is null");
            }
            this.ingredients.addAll(ingredientsElements);
            return this;
        }

        /**
         * Adds to the {@link #ingredients} property of this builder
         *
         * @param ingredients
         * @return this builder
         * @throws IllegalArgumentException if ingredients is null or contains a null element
         */
        public Builder addIngredients(String... ingredientsElements) {
            if (ingredientsElements == null) {
                throw new IllegalArgumentException("ingredientsElements is null");
            }
            Collections.addAll(this.ingredients, ingredientsElements);
            return this;
        }

        /**
         * Adds to the {@link #ingredients} property of this builder
         *
         * @param ingredients
         * @return this builder
         * @throws IllegalArgumentException if ingredients is null or contains a null element
         */
        public Builder addIngredients(String ingredientsElement) {
            this.ingredients.add(ingredientsElement);
            return this;
        }

        /**
         * Creates a new {@link AllergenInput} based on this Builder.
         *
         * @return a new AllergenInput
         */
        public AllergenInput build() {
            return new AllergenInput(this);
        }
    }
}
