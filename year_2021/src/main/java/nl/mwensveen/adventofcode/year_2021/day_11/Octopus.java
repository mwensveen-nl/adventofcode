package nl.mwensveen.adventofcode.year_2021.day_11;

public class Octopus {

    private int energy;
    private boolean flashed = false;
    private int numberOfFlashes = 0;

    public Octopus(int energy) {
        super();
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void increaseEnergy() {
        energy++;
    }

    public boolean isFlashed() {
        return flashed;
    }

    public int getNumberOfFlashes() {
        return numberOfFlashes;
    }

    public void flash() {
        energy = 0;
        flashed = true;
        numberOfFlashes++;
    }

    public void resetFlash() {
        flashed = false;
    }

    @Override
    public String toString() {
        return "" + energy;
    }
}
