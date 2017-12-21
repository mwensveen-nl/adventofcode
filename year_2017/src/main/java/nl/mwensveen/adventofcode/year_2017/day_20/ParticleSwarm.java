package nl.mwensveen.adventofcode.year_2017.day_20;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParticleSwarm {

    private List<Particle> particles;

    public ParticleSwarm(String input) {
        particles = toParticleList(input);
    }

    public int calculate() {
        IntStream.range(0, 50000).forEach(i -> particles.forEach(p -> p.tick()));

        Optional<Particle> min = particles.stream().min((p1, p2) -> p1.distance().compareTo(p2.distance()));
        return min.get().getId();
    }

    public int calculateCollision() {
        IntStream.range(0, 50000).forEach(i -> moveParticlesAndRemoveColliding());

        return particles.size();
    }

    private void moveParticlesAndRemoveColliding() {
        particles.forEach(p -> p.tick());

        Map<Position, Set<Particle>> positionMap = particles.stream().collect(Collectors.groupingBy(Particle::getPosition, Collectors.toSet()));

        positionMap.entrySet().stream().filter(e -> e.getValue().size() > 1).flatMap(e -> e.getValue().stream())
            .forEach(p -> particles.remove(p));
    }

    private Object comparePosition(Particle p1, Particle p2) {
        // TODO Auto-generated method stub
        return null;
    }

    private List<Particle> toParticleList(String in) {
        ArrayList<String> newArrayList = splitOn(in, "\n");

        List<Particle> collect = newArrayList.stream().map(s -> makeParticle(s)).collect(Collectors.toList());

        System.out.println(collect);
        return collect;
    }

    private ArrayList<String> splitOn(String in, String splitString) {
        Iterable<String> split = Splitter.on(splitString)
            .trimResults()
            .omitEmptyStrings()
            .split(in);
        ArrayList<String> newArrayList = Lists.newArrayList(split);
        return newArrayList;
    }

    private Particle makeParticle(String s) {
        ArrayList<String> newArrayList = splitOn(s, ", ");
        String string = newArrayList.get(0);
        ArrayList<String> p = splitOn(string.substring(3, string.length() - 1), ",");
        string = newArrayList.get(1);
        ArrayList<String> v = splitOn(string.substring(3, string.length() - 1), ",");
        string = newArrayList.get(2);
        ArrayList<String> a = splitOn(string.substring(3, string.length() - 1), ",");

        return Particle.builder().setPx(p.get(0)).setPy(p.get(1)).setPz(p.get(2))
            .setVx(v.get(0)).setVy(v.get(1)).setVz(v.get(2)).setAx(a.get(0))
            .setAy(a.get(1)).setAz(a.get(2)).build();
    }

}
