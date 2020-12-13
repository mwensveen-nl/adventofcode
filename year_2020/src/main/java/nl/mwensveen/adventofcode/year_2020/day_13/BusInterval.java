package nl.mwensveen.adventofcode.year_2020.day_13;

import com.google.common.base.MoreObjects;

public class BusInterval implements Comparable<BusInterval> {
    private final long busNr;
    private final long interval;

    public long getBusNr() {
        return busNr;
    }

    public long getInterval() {
        return interval;
    }

    /**
     * Constructor that creates a BusInterval with the values of a BusInterval.Builder.
     */
    private BusInterval(Builder builder) {
        this.busNr = builder.busNr;
        this.interval = builder.interval;
    }

    /**
     * Creates a new {@link Builder} for {@link BusInterval} objects.
     *
     * @return a new Builder
     *
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * This class provides methods to build a {@link nl.mwensveen.adventofcode.year_2020.day_13.BusInterval}.
     */
    public static class Builder {
        private long busNr;
        private long interval;

        /**
         * Sets the {@link #busNr} property of this builder
         *
         * @param busNr
         * @return this builder
         */
        public Builder withBusNr(long busNr) {
            this.busNr = busNr;
            return this;
        }

        public Builder withBusNr(String busNr) {
            if ("x".equals(busNr)) {
                this.busNr = Long.MIN_VALUE;
            } else {
                this.busNr = Long.parseLong(busNr);
            }
            return this;
        }

        /**
         * Sets the {@link #interval} property of this builder
         *
         * @param interval
         * @return this builder
         */
        public Builder withInterval(long interval) {
            this.interval = interval;
            return this;
        }

        /**
         * Creates a new {@link BusInterval} based on this Builder.
         *
         * @return a new BusInterval
         */
        public BusInterval build() {
            return new BusInterval(this);
        }
    }

    @Override
    public int compareTo(BusInterval o) {
        return -1 * Long.compare(this.busNr, o.busNr);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("busNr", busNr).add("interval", interval).toString();
    }
}
