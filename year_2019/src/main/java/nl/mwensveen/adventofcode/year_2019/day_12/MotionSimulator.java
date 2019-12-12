package nl.mwensveen.adventofcode.year_2019.day_12;

import java.util.List;

public class MotionSimulator {

    private List<Moon> moons;

    public MotionSimulator(List<Moon> moons) {
        this.moons = moons;
    }

    public int simulate(int steps) {
        GravityApplier gravityApplier = new GravityApplier();
        VelocityApplier velocityApplier = new VelocityApplier();
        // System.out.println(moons);
        for (int i = 0; i < steps; i++) {
            gravityApplier.apply(moons);
            velocityApplier.applyVelocity(moons);
            // System.out.println(moons);
        }

        EnergyCalculator calculator = new EnergyCalculator();
        int totalEnergy = moons.stream().mapToInt(m -> calculator.calculateEnergie(m)).sum();
        return totalEnergy;
    }
}
