package nl.mwensveen.adventofcode.year_2021.day_17;

public class Trajectory {

    public int findHightsTrajectory(String input) {
        TargetArea targetArea = TargetArea.parse(input);
        int heighest = Integer.MIN_VALUE;
        for (int x = 0; x <= targetArea.getxMax(); x++) {
            for (int y = 0; y < 10000; y++) {
                Probe probe = new Probe(x, y);
                boolean move = true;
                while (move) {
                    if (targetArea.isInArea(probe.getxPos(), probe.getyPos())) {
                        move = false;
                        heighest = Math.max(heighest, probe.getHeighest());
                    } else if (targetArea.isBeyond(probe.getxPos(), probe.getyPos())) {
                        move = false;
                    } else if (probe.getxVel() == 0 && !targetArea.isXInArea(probe.getxPos())) {
                        move = false;
                    } else {
                        probe.performStep();
                    }
                }
            }
        }
        return heighest;
    }

    public int findNumberOfVelocities(String input) {
        TargetArea targetArea = TargetArea.parse(input);
        int count = 0;
        for (int x = 0; x <= targetArea.getxMax(); x++) {
            for (int y = targetArea.getyMin(); y < 10000; y++) {
                Probe probe = new Probe(x, y);
                boolean move = true;
                while (move) {
                    if (targetArea.isInArea(probe.getxPos(), probe.getyPos())) {
                        move = false;
                        count++;
                    } else if (targetArea.isBeyond(probe.getxPos(), probe.getyPos())) {
                        move = false;
                    } else if (probe.getxVel() == 0 && !targetArea.isXInArea(probe.getxPos())) {
                        move = false;
                    } else {
                        probe.performStep();
                    }
                }
            }
        }
        return count;
    }
}
