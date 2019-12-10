package nl.mwensveen.adventofcode.year_2019.day_10;

import com.codepoetics.protonpack.StreamUtils;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class LocationFinder {

    public Asteroid findLocation(List<String> input) {
        AsteroidMapper asteroidMapper = new AsteroidMapper();
        List<Asteroid> asteroids = asteroidMapper.mapAsteroids(input);
        Set<Point> pointSet = asteroids.stream().map(a -> a.getPoint()).collect(Collectors.toUnmodifiableSet());
        StreamUtils.zipWithIndex(asteroids.stream()).forEach(entry -> determineVisibleAsteroids(entry.getIndex(), entry.getValue(), asteroids, pointSet));

        Optional<Asteroid> max = asteroids.stream().max((a1, a2) -> a1.getDetectable().size() - a2.getDetectable().size());
        return max.get();
    }

    private void determineVisibleAsteroids(long index, Asteroid baseAstroid, List<Asteroid> asteroids, Set<Point> pointSet) {
        asteroids.stream().skip(index + 1).forEach(a -> setVisible(baseAstroid, a, pointSet));
    }

    private void setVisible(Asteroid baseAstroid, Asteroid a, Set<Point> pointSet) {
        LineCalculator calculator = new LineCalculator(baseAstroid.getPoint(), a.getPoint());
        Optional<Point> next = calculator.next();
        while (next.isPresent()) {
            Point p = next.get();
            if (pointSet.contains(p)) {
                a.getNotDetectable().add(baseAstroid);
                baseAstroid.getNotDetectable().add(a);
                return;
            }
            next = calculator.next();
        }
        baseAstroid.getDetectable().add(a);
        a.getDetectable().add(baseAstroid);
        return;
    }

}
