package nl.mwensveen.adventofcode.year_2020.day_22;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private final String name;

    private final List<Integer> spaceCards;

    public String getName() {
        return name;
    }

    public Integer getTopSpaceCard() {
        return spaceCards.remove(0);
    }

    public boolean hasSpaceCards() {
        return spaceCards.size() > 0;
    }

    public int numberOfSpaceCards() {
        return spaceCards.size();
    }

    public List<Integer> getSpaceCard() {
        return spaceCards;
    }

    public void addSpaceCards(Integer card1, Integer card2) {
        spaceCards.add(card1);
        spaceCards.add(card2);
    }

    public List<Integer> copyDeck(int numberOfCards) {
        return spaceCards.stream().limit(numberOfCards).collect(Collectors.toList());
    }

    /**
     * Constructor that creates a Player with the values of a Player.Builder.
     */
    private Player(Builder builder) {
        this.name = builder.name;
        this.spaceCards = builder.spaceCards;
    }

    /**
     * Creates a new {@link Builder} for {@link Player} objects.
     *
     * @return a new Builder
     *
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * This class provides methods to build a {@link nl.mwensveen.adventofcode.year_2020.day_22.Player}.
     */
    public static class Builder {
        private String name;
        private List<Integer> spaceCards = new ArrayList<>();

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
         * Sets the {@link #spaceCards} property of this builder
         *
         * @param spaceCards
         * @return this builder
         */
        public Builder withSpaceCards(List<Integer> spaceCards) {
            if (spaceCards == null) {
                throw new IllegalArgumentException("spaceCards is null");
            }
            this.spaceCards = spaceCards;
            return this;
        }

        /**
         * Adds to the {@link #spaceCards} property of this builder
         *
         * @param spaceCards
         * @return this builder
         * @throws IllegalArgumentException if spaceCards is null or contains a null element
         */
        public Builder addSpaceCards(List<Integer> spaceCardsElements) {
            if (spaceCardsElements == null) {
                throw new IllegalArgumentException("spaceCardsElements is null");
            }
            this.spaceCards.addAll(spaceCardsElements);
            return this;
        }

        /**
         * Adds to the {@link #spaceCards} property of this builder
         *
         * @param spaceCards
         * @return this builder
         * @throws IllegalArgumentException if spaceCards is null or contains a null element
         */
        public Builder addSpaceCards(Integer spaceCardsElement) {
            this.spaceCards.add(spaceCardsElement);
            return this;
        }

        /**
         * Creates a new {@link Player} based on this Builder.
         *
         * @return a new Player
         */
        public Player build() {
            return new Player(this);
        }
    }

}
