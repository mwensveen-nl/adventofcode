package nl.mwensveen.adventofcode.year_2025.day_08;

public record Distance(Coordinate one, Coordinate two, double length) {

    public Distance(Coordinate one, Coordinate two) {
        this(one, two, calculate(one, two));
    }

    private static double calculate(Coordinate one, Coordinate two) {
        var x = Math.pow(one.x() - two.x(), 2);
        var y = Math.pow(one.y() - two.y(), 2);
        var z = Math.pow(one.z() - two.z(), 2);
        return Math.sqrt(x + y + z);
    }

    @Override
    public final boolean equals(Object arg0) {
        if (arg0 instanceof Distance other) {
            return this.one().equals(other.one()) && this.two().equals(other.two());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return one.hashCode() + two.hashCode();
    }
}
