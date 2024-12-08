package nl.mwensveen.adventofcode.year_2024.day_08;

import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.javatuples.Pair;

public class AntinodesFinder {

    private int rowSize;
    private int colSize;

    public long find(Multimap<String, Position> grid, int rows, int cols) {
        this.rowSize = rows;
        this.colSize = cols;
        return grid.keySet().stream().flatMap(a -> find(grid.get(a)).stream()).distinct().count();
    }

    public long findResonantHarmonic(Multimap<String, Position> grid, int rows, int cols) {
        this.rowSize = rows;
        this.colSize = cols;

        List<Position> antinodes = grid.keySet().stream().flatMap(a -> findResonantHarmonic(grid.get(a)).stream()).distinct().toList();
        long anCount = antinodes.size();

        long antennaCount = grid.keySet().stream().filter(a -> grid.get(a).size() > 1).flatMap(a -> grid.get(a).stream()).filter(p -> !antinodes.contains(p)).count();

        return anCount + antennaCount;
    }

    private List<Position> find(Collection<Position> pos) {
        return pos.stream().flatMap(p0 -> combine(pos, p0)).filter(p -> !p.getValue0().equals(p.getValue1())).flatMap(p -> antinodes(p).stream()).distinct().toList();
    }

    private List<Position> findResonantHarmonic(Collection<Position> pos) {
        return pos.stream().flatMap(p0 -> combine(pos, p0)).filter(p -> !p.getValue0().equals(p.getValue1())).flatMap(p -> antinodesResonantHarmonic(p).stream()).distinct().toList();
    }

    private Stream<Pair<Position, Position>> combine(Collection<Position> pos, Position p0) {
        return pos.stream().map(p1 -> new Pair<Position, Position>(p0, p1)).toList().stream();
    }

    private List<Position> antinodes(Pair<Position, Position> p) {
        List<Position> antinodes = new ArrayList<>();
        Position p0 = p.getValue0();
        Position p1 = p.getValue1();

        int rowDif = Math.abs(p0.row() - p1.row());
        int colDif = Math.abs(p0.col() - p1.col());

        int newRow = p0.row() < p1.row() ? p0.row() - rowDif : p0.row() + rowDif;
        int newCol = p0.col() < p1.col() ? p0.col() - colDif : p0.col() + colDif;
        if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize) {
            antinodes.add(new Position(newRow, newCol));
        }

        newRow = p1.row() < p0.row() ? p1.row() - rowDif : p1.row() + rowDif;
        newCol = p1.col() < p0.col() ? p1.col() - colDif : p1.col() + colDif;
        if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize) {
            antinodes.add(new Position(newRow, newCol));
        }
        return antinodes;
    }

    private List<Position> antinodesResonantHarmonic(Pair<Position, Position> p) {
        List<Position> antinodes = new ArrayList<>();
        Position p0 = p.getValue0();
        Position p1 = p.getValue1();

        int rowDif = Math.abs(p0.row() - p1.row());
        int colDif = Math.abs(p0.col() - p1.col());

        Position pb = p0;
        while (pb != null) {
            int newRow = p0.row() < p1.row() ? pb.row() - rowDif : pb.row() + rowDif;
            int newCol = p0.col() < p1.col() ? pb.col() - colDif : pb.col() + colDif;

            if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize) {
                pb = new Position(newRow, newCol);
                antinodes.add(pb);
            } else {
                pb = null;
            }
        }

        pb = p1;
        while (pb != null) {
            int newRow = p1.row() < p0.row() ? pb.row() - rowDif : pb.row() + rowDif;
            int newCol = p1.col() < p0.col() ? pb.col() - colDif : pb.col() + colDif;
            if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize) {
                pb = new Position(newRow, newCol);
                antinodes.add(pb);
            } else {
                pb = null;
            }
        }
        return antinodes;
    }
}
