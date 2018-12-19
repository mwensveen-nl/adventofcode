package nl.mwensveen.adventofcode.year_2018.day_12;

import com.google.common.base.MoreObjects;

public class Pot {
    private int number;
    private boolean plant;

    public Pot(int number, boolean plant) {
        super();
        this.number = number;
        this.plant = plant;
    }

    public int getNumber() {
        return number;
    }

    public boolean isPlant() {
        return plant;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("number", number).add("plant", plant).toString();
    }
}
