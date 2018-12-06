package nl.mwensveen.adventofcode.year_2018.day_6;

public class Distance {
    private Coordinate coordinate;
    private int distance;

    public Distance(int startDistance) {
        this.distance = startDistance;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void addToDistance(int addDistance) {
        this.distance = this.distance + addDistance;
    }
}
