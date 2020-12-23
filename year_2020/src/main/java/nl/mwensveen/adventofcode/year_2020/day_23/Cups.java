package nl.mwensveen.adventofcode.year_2020.day_23;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cups {
    private List<Integer> circle;
    private List<Integer> pickUp;
    private Integer lowest;
    private Integer highest;

    public List<Integer> doPickUp() {
        pickUp = new ArrayList<>();
        pickUp.add(circle.remove(1));
        pickUp.add(circle.remove(1));
        pickUp.add(circle.remove(1));

        return pickUp;
    }

    public Integer dropPickup() {
        Integer destination = circle.get(0) - 1;
        return dropPickup(destination);
    }

    private Integer dropPickup(Integer destination) {
        Integer newDestination = destination;
        if (newDestination.intValue() < lowest.intValue()) {
            newDestination = highest;
        }
        if (pickUp.contains(newDestination)) {
            newDestination = newDestination - 1;
            return dropPickup(newDestination);
        } else {
            int index = circle.indexOf(newDestination);
            circle.addAll(index + 1, pickUp);
            return newDestination;
        }
    }

    public Integer pickNewCurrent() {
        circle.add(circle.remove(0));
        return circle.get(0);
    }

    public String finishedLabels() {
        int indexOf1 = circle.indexOf(Integer.valueOf(1));
        List<Indexed<Integer>> labels = StreamUtils.zipWithIndex(circle.stream()).filter(entry -> entry.getIndex() > indexOf1).collect(Collectors.toList());
        labels.addAll(StreamUtils.zipWithIndex(circle.stream()).filter(entry -> entry.getIndex() < indexOf1).collect(Collectors.toList()));
        return labels.stream().map(i -> i.getValue().toString()).collect(Collectors.joining());
    }

    /**
     * Constructor that creates a Cups with the values of a Cups.Builder.
     */
    private Cups(Builder builder) {
        this.circle = new ArrayList(builder.circle);
        init();
    }

    private void init() {
        lowest = circle.stream().min(Integer::compare).get();
        highest = circle.stream().max(Integer::compare).get();
    }

    /**
     * Creates a new {@link Builder} for {@link Cups} objects.
     *
     * @return a new Builder
     *
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * This class provides methods to build a {@link nl.mwensveen.adventofcode.year_2020.day_23.Cups}.
     */
    public static class Builder {
        private List<Integer> circle = new ArrayList<>();

        /**
         * Sets the {@link #circle} property of this builder
         *
         * @param circle
         * @return this builder
         */
        public Builder withCircle(List<Integer> circle) {
            if (circle == null) {
                throw new IllegalArgumentException("circle is null");
            }
            this.circle = circle;
            return this;
        }

        /**
         * Adds to the {@link #circle} property of this builder
         *
         * @param circle
         * @return this builder
         * @throws IllegalArgumentException if circle is null or contains a null element
         */
        public Builder addCircle(List<Integer> circleElements) {
            if (circleElements == null) {
                throw new IllegalArgumentException("circleElements is null");
            }
            this.circle.addAll(circleElements);
            return this;
        }

        /**
         * Adds to the {@link #circle} property of this builder
         *
         * @param circle
         * @return this builder
         * @throws IllegalArgumentException if circle is null or contains a null element
         */
        public Builder addCircle(Integer circleElement) {
            this.circle.add(circleElement);
            return this;
        }

        /**
         * Creates a new {@link Cups} based on this Builder.
         *
         * @return a new Cups
         */
        public Cups build() {
            return new Cups(this);
        }
    }
}
