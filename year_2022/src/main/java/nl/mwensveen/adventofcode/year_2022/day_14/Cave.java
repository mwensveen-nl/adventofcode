package nl.mwensveen.adventofcode.year_2022.day_14;

import com.google.common.collect.Table;

public class Cave {
    private Table<Integer, Integer, String> map;
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    public Table<Integer, Integer, String> getMap() {
        return map;
    }

    public int getxMin() {
        return xMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMin() {
        return yMin;
    }

    public int getyMax() {
        return yMax;
    }

    private Cave(Builder builder) {
        this.map = builder.rocks;
        this.xMin = builder.xMin;
        this.xMax = builder.xMax;
        this.yMin = builder.yMin;
        this.yMax = builder.yMax;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Table<Integer, Integer, String> rocks;
        private int xMin;
        private int xMax;
        private int yMin;
        private int yMax;

        public Builder withRocks(Table<Integer, Integer, String> rocks) {
            this.rocks = rocks;
            return this;
        }

        public Builder withXMin(int xMin) {
            this.xMin = xMin;
            return this;
        }

        public Builder withXMax(int xMax) {
            this.xMax = xMax;
            return this;
        }

        public Builder withYMin(int yMin) {
            this.yMin = yMin;
            return this;
        }

        public Builder withYMax(int yMax) {
            this.yMax = yMax;
            return this;
        }

        public Cave build() {
            return new Cave(this);
        }
    }

}
