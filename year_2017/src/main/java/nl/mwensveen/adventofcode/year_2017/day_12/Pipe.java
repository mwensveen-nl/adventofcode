package nl.mwensveen.adventofcode.year_2017.day_12;

import java.util.List;

public class Pipe {
    private final Integer base;
    private final List<Integer> connections;

    public Pipe(Integer base, List<Integer> connections) {
        super();
        this.base = base;
        this.connections = connections;
    }

    public Integer getBase() {
        return base;
    }

    public List<Integer> getConnections() {
        return connections;
    }

}
