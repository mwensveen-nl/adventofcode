package nl.mwensveen.adventofcode.year_2019.day_10;

import java.util.List;
import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class MonitoringStationSolution extends AbstractTimedSolution {
    private Asteroid location;

    public static void main(String[] args) {
        MonitoringStationSolution solution = new MonitoringStationSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        AsteroidMapProcessor asteroidMapProcessor = new AsteroidMapProcessor();
        location = asteroidMapProcessor.findLocation(FileReadHelper.readLines("Day10.txt"));
        System.out.println("Best location is " + location.getPoint() + " with number of other asteroids detected " + location.getDetectable().size());

    }

    @Override
    protected void part2() {
        AsteroidMapProcessor asteroidMapProcessor = new AsteroidMapProcessor();
        List<Asteroid> vaporizeAsteroids = asteroidMapProcessor.vaporizeAsteroids(location);
        Asteroid asteroid = vaporizeAsteroids.get(199);
        int x = asteroid.getPoint().getX();
        int y = asteroid.getPoint().getY();
        int result = x * 100 + y;
        System.out.println("Vaporized asteroid 200 = " + asteroid + ". The result = " + result);
    }

}
