package nl.mwensveen.adventofcode.year_2021.day_17;

public class Probe {

    private int xPos = 0;
    private int yPos = 0;
    private int xVel;
    private int yVel;

    private int heighest = Integer.MIN_VALUE;

    public Probe(int xVel, int yVel) {
        this.xVel = xVel;
        this.yVel = yVel;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getxVel() {
        return xVel;
    }

    public int getyVel() {
        return yVel;
    }

    public void performStep() {
        xPos += xVel;
        yPos += yVel;

        if (xVel > 0) {
            xVel--;
        } else if (xVel < 0) {
            xVel++;
        }

        yVel--;

        heighest = Math.max(yPos, heighest);
    }

    public int getHeighest() {
        return heighest;
    }
}
