package nl.mwensveen.adventofcode.year_2018.day_13;

public enum TrackPart {
    STRAIGHT_HORIZONTAL("-"),
    STRAIGHT_VERTICAL("|"),
    CURVE_RIGHT("/"),
    CURVE_LEFT("\\"),
    CROSSING("+");

    private String symbol;

    private TrackPart(String symbol) {
        this.symbol = symbol;
    }

    public static TrackPart valueForSymbol(String symbol) {
        for (TrackPart track : TrackPart.values()) {
            if (track.symbol.equals(symbol)) {
                return track;
            }
        }
        throw new RuntimeException("cannot find TracPart for " + symbol);
    }
}
