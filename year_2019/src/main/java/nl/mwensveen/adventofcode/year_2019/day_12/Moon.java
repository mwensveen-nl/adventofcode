package nl.mwensveen.adventofcode.year_2019.day_12;

public class Moon {
    private int positionX;
    private int positionY;
    private int positionZ;
    private int velocityX;
    private int velocityY;
    private int velocityZ;

    public Moon(int positionX, int positionY, int positionZ) {
        super();
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
    }

    public void UpdatePosition(int positionX, int positionY, int positionZ) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
    }

    public void UpdateVelocity(int velocityX, int velocityY, int velocityZ) {
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getPositionZ() {
        return positionZ;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public int getVelocityZ() {
        return velocityZ;
    }

    public void increaseVelocityX(int increase) {
        velocityX += increase;
    }

    public void increaseVelocityY(int increase) {
        velocityY += increase;
    }

    public void increaseVelocityZ(int increase) {
        velocityZ += increase;
    }

    @Override
    public String toString() {
        return String.format("pos=<x=%4d, y=%4d, z=%4d>, vel=<x=%4d, y=%4d, z=%4d>", positionX, positionY, positionZ, velocityX, velocityY, velocityZ);
    }
}
