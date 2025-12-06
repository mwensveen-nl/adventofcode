package nl.mwensveen.adventofcode.year_2025.day_02;

public record Range(long start, long end) {

    public Range(String range) {
        this(Long.valueOf(range.substring(0, range.indexOf("-"))), Long.valueOf(range.substring(range.indexOf("-") + 1)));
    }

    public boolean inRange(long l) {
        return l >= start && l <= end;
    }

    public boolean larger(long l) {
        return l > end;
    }
}
