package nl.mwensveen.adventofcode.year_2017.day_24;

import com.google.common.base.MoreObjects;

public class Component {
    private final String portA;
    private final String portB;

    public String getPortA() {
        return portA;
    }

    public String getPortB() {
        return portB;
    }

    private Component(Builder builder) {
        this.portA = builder.portA;
        this.portB = builder.portB;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String portA;
        private String portB;

        public Builder setPortA(String portA) {
            this.portA = portA;
            return this;
        }

        public Builder setPortB(String portB) {
            this.portB = portB;
            return this;
        }

        public Component build() {
            return new Component(this);
        }
    }

    public boolean hasPort(String port) {
        return portA.equals(port) || portB.equals(port);
    }

    public String otherPort(String port) {
        return portA.equals(port) ? portB : portA;
    }

    public int strenght() {
        return Integer.valueOf(portA) + Integer.valueOf(portB);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("portA", portA).add("portB", portB).toString();
    }

}
