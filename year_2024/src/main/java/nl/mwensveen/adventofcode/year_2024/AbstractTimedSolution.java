package nl.mwensveen.adventofcode.year_2024;

import java.time.Duration;
import java.time.Instant;

public abstract class AbstractTimedSolution {

    public void run() {
        Instant start = Instant.now();

        init();
        Instant finishInit = Instant.now();
        System.err.println("Duration init     " + Duration.between(start, finishInit).toString());

        part1();
        Instant finishOne = Instant.now();
        System.err.println("Duration part one " + Duration.between(finishInit, finishOne).toString());

        part2();
        Instant finishTwo = Instant.now();
        System.err.println("Duration part two " + Duration.between(finishOne, finishTwo).toString());

        System.err.println("Duration Total    " + Duration.between(start, finishTwo).toString());
    }

    protected abstract void init();

    protected abstract void part1();

    protected abstract void part2();

}
