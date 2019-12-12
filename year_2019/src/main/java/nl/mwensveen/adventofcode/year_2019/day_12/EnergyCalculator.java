package nl.mwensveen.adventofcode.year_2019.day_12;

public class EnergyCalculator {

    public int calculateEnergie(Moon m) {
        int potential = Math.abs(m.getPositionX()) + Math.abs(m.getPositionY()) + Math.abs(m.getPositionZ());
        int kinetic = Math.abs(m.getVelocityX()) + Math.abs(m.getVelocityY()) + Math.abs(m.getVelocityZ());
        return potential * kinetic;
    }
}
