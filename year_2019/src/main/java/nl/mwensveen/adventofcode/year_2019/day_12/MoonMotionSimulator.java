package nl.mwensveen.adventofcode.year_2019.day_12;

import java.util.List;

public class MoonMotionSimulator {

    public void simulateMotionOfMoons(List<Moon> moons, int numberOfTimeSteps) {
        GravityApplier gravityApplier = new GravityApplier();
        VelocityApplier velocityApplier = new VelocityApplier();
        for (int i = 0; i < numberOfTimeSteps; i++) {
            gravityApplier.applyGravity(moons);
            velocityApplier.applyVelocity(moons);
        }
    }
}
