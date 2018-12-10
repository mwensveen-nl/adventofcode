package nl.mwensveen.adventofcode.year_2018.day_9;

import java.time.Duration;
import java.time.Instant;

public class MarbleGameSolution {

    public static void main(String[] args) {
        MarbleGame marbleGame = new MarbleGame(486, 70833);
        System.out.println("Wining score = " + marbleGame.PlayGame());

        Instant start = Instant.now();

        marbleGame = new MarbleGame(486, 70833);
        System.out.println("Wining score = " + marbleGame.calculateGame());
        System.out.println(Duration.between(start, Instant.now()).toMillis());
        marbleGame = new MarbleGame(486, 70833 * 100);
        System.out.println("Wining score = " + marbleGame.calculateGame());
        System.out.println(Duration.between(start, Instant.now()).toMillis());

    }

}
