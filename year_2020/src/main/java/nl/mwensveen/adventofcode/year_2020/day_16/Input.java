package nl.mwensveen.adventofcode.year_2020.day_16;

import java.util.ArrayList;
import java.util.List;

public class Input {

    private final List<Field> fields;
    private final List<Integer> myTicket;
    private final List<List<Integer>> nearbyTickets;

    public List<Field> getFields() {
        return fields;
    }

    public List<Integer> getMyTicket() {
        return myTicket;
    }

    public List<List<Integer>> getNearbyTickets() {
        return nearbyTickets;
    }

    private Input(Builder builder) {
        this.fields = builder.fields;
        this.myTicket = builder.myTicket;
        this.nearbyTickets = builder.nearbyTickets;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<Field> fields = new ArrayList<>();
        private List<Integer> myTicket = new ArrayList<>();
        private List<List<Integer>> nearbyTickets;

        public Builder withFields(List<Field> fields) {
            if (fields == null) {
                throw new IllegalArgumentException("fields is null");
            }
            this.fields = fields;
            return this;
        }

        public Builder withMyTicket(List<Integer> myTicket) {
            if (myTicket == null) {
                throw new IllegalArgumentException("myTicket is null");
            }
            this.myTicket = myTicket;
            return this;
        }

        public Builder withNearbyTickets(List<List<Integer>> nearbyTickets) {
            this.nearbyTickets = nearbyTickets;
            return this;
        }

        public Input build() {
            return new Input(this);
        }
    }
}
