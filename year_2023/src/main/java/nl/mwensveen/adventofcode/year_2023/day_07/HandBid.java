package nl.mwensveen.adventofcode.year_2023.day_07;

public record HandBid(Hand hand, Long bid) {

    public static HandBid parse(String input) {
        String[] split = input.split(" ");
        return new HandBid(Hand.parse(split[0]), Long.valueOf(split[1]));
    }
}
