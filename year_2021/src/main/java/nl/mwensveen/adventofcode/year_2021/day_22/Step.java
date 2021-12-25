package nl.mwensveen.adventofcode.year_2021.day_22;

public class Step {
    private final int startX;
    private final int endX;
    private final int startY;
    private final int endY;
    private final int startZ;
    private final int endZ;
    private final String onOff;

    public int getStartX() {
        return startX;
    }

    public int getEndX() {
        return endX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndY() {
        return endY;
    }

    public int getStartZ() {
        return startZ;
    }

    public int getEndZ() {
        return endZ;
    }

    public String getOnOff() {
        return onOff;
    }

    private Step(Builder builder) {
        this.startX = builder.startX;
        this.endX = builder.endX;
        this.startY = builder.startY;
        this.endY = builder.endY;
        this.startZ = builder.startZ;
        this.endZ = builder.endZ;
        this.onOff = builder.onOff;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int startX;
        private int endX;
        private int startY;
        private int endY;
        private int startZ;
        private int endZ;
        private String onOff;

        public Builder() {
        }

        public Builder(Step object) {
            this.startX = object.startX;
            this.endX = object.endX;
            this.startY = object.startY;
            this.endY = object.endY;
            this.startZ = object.startZ;
            this.endZ = object.endZ;
            this.onOff = object.onOff;
        }

        public Builder withStartX(int startX) {
            this.startX = startX;
            return this;
        }

        public Builder withEndX(int endX) {
            this.endX = endX;
            return this;
        }

        public Builder withStartY(int startY) {
            this.startY = startY;
            return this;
        }

        public Builder withEndY(int endY) {
            this.endY = endY;
            return this;
        }

        public Builder withStartZ(int startZ) {
            this.startZ = startZ;
            return this;
        }

        public Builder withEndZ(int endZ) {
            this.endZ = endZ;
            return this;
        }

        public Builder withOnOff(String onOff) {
            this.onOff = onOff;
            return this;
        }

        public Step build() {
            return new Step(this);
        }
    }

    public long size() {
        return 1L * (Math.abs(Long.valueOf(startX) - Long.valueOf(endX)) + 1L) * (Math.abs(Long.valueOf(startY) - Long.valueOf(endY)) + 1L)
                * (Math.abs(Long.valueOf(startZ) - Long.valueOf(endZ)) + 1L);
    }

    @Override
    public String toString() {
        return "Step [" + onOff + ": X=" + startX + ".." + endX + ", Y=" + startY + ".." + endY + ", Z=" + startZ + ".." + endZ + ", size="
                + size() + "]";
    }

}
