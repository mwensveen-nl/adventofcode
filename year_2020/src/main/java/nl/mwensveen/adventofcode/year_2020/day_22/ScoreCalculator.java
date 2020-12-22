package nl.mwensveen.adventofcode.year_2020.day_22;

public class ScoreCalculator {

    public long calculateScore(Player player) {
        int multiplier = player.numberOfSpaceCards();
        long sum = 0;
        while (player.hasSpaceCards()) {
            Integer card = player.getTopSpaceCard();
            sum += card.intValue() * multiplier;
            multiplier--;
        }
        return sum;
    }
}
