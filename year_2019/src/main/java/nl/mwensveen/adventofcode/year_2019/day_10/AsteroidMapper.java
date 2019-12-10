package nl.mwensveen.adventofcode.year_2019.day_10;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.stream.Collectors;

public class AsteroidMapper {

    public List<Asteroid> mapAsteroids(List<String> input) {
        return StreamUtils.zipWithIndex(input.stream()).map(entry -> mapAsteroid(entry.getIndex(), entry.getValue())).flatMap(list -> list.stream())
                .collect(Collectors.toList());
    }

    private List<Asteroid> mapAsteroid(long y, String value) {
        return StreamUtils.zipWithIndex(Lists.charactersOf(value).stream()).filter(entry -> entry.getValue().equals('#'))
                .map(entry -> mapAsteroid(entry.getIndex(), y)).collect(Collectors.toList());

    }

    private Asteroid mapAsteroid(long x, long y) {
        return new Asteroid(new Point((int) x, (int) y));
    }
}
