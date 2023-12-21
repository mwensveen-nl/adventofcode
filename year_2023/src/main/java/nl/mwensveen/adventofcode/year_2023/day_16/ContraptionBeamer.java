package nl.mwensveen.adventofcode.year_2023.day_16;

import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.List;

public class ContraptionBeamer {

    public long beamTopLeft(Table<Integer, Integer, Cell> contraption) {
        step(new Beam(0, 0, Direction.RIGHT), contraption);
        return contraption.values().stream().filter(c -> !c.directions().isEmpty()).count();
    }

    public long beam(Beam start, Table<Integer, Integer, Cell> contraption) {
        step(start, contraption);
        long result = contraption.values().stream().filter(c -> !c.directions().isEmpty()).count();
        contraption.values().forEach(cell -> cell.directions().clear());
        return result;
    }

    private void step(Beam beam, Table<Integer, Integer, Cell> contraption) {
        Cell cell = contraption.get(beam.row(), beam.col());
        if (cell.directions().contains(beam.direction())) {
            return;
        }
        cell.directions().add(beam.direction());

        List<Beam> nextBeams = switch (cell.item()) {
            case Item.EMPTY_SPACE -> emptySpace(beam);
            case Item.MIRROR_SLASH -> mirrorSlash(beam);
            case Item.MIRROR_BACKSLASH -> mirrorBackslash(beam);
            case Item.SPLITTER_HORIZONTAL -> splitterHorizontal(beam);
            case Item.SPLITTER_VERTICAL -> splitterVertical(beam);
            default -> throw new IllegalArgumentException("Unexpected value: " + cell.item());
        };
        for (Beam nextBeam : nextBeams) {
            if (contraption.contains(nextBeam.row(), nextBeam.col())) {
                step(nextBeam, contraption);
            }
        }

    }

    private List<Beam> splitterVertical(Beam beam) {
        List<Beam> nextBeam = new ArrayList<>();
        switch (beam.direction()) {
            case RIGHT, LEFT -> {
                nextBeam.add(new Beam(beam.row() - 1, beam.col(), Direction.UP));
                nextBeam.add(new Beam(beam.row() + 1, beam.col(), Direction.DOWN));
            }
            case UP -> {
                nextBeam.add(new Beam(beam.row() - 1, beam.col(), beam.direction()));
            }
            case DOWN -> {
                nextBeam.add(new Beam(beam.row() + 1, beam.col(), beam.direction()));
            }
        }
        return nextBeam;
    }

    private List<Beam> splitterHorizontal(Beam beam) {
        List<Beam> nextBeam = new ArrayList<>();
        switch (beam.direction()) {
            case RIGHT -> {
                nextBeam.add(new Beam(beam.row(), beam.col() + 1, beam.direction()));
            }
            case LEFT -> {
                nextBeam.add(new Beam(beam.row(), beam.col() - 1, beam.direction()));
            }
            case UP, DOWN -> {
                nextBeam.add(new Beam(beam.row(), beam.col() - 1, Direction.LEFT));
                nextBeam.add(new Beam(beam.row(), beam.col() + 1, Direction.RIGHT));
            }
        }
        return nextBeam;
    }

    private List<Beam> mirrorBackslash(Beam beam) {
        List<Beam> nextBeam = new ArrayList<>();
        switch (beam.direction()) {
            case RIGHT -> {
                nextBeam.add(new Beam(beam.row() + 1, beam.col(), Direction.DOWN));
            }
            case LEFT -> {
                nextBeam.add(new Beam(beam.row() - 1, beam.col(), Direction.UP));
            }
            case UP -> {
                nextBeam.add(new Beam(beam.row(), beam.col() - 1, Direction.LEFT));
            }
            case DOWN -> {
                nextBeam.add(new Beam(beam.row(), beam.col() + 1, Direction.RIGHT));
            }
        }
        return nextBeam;
    }

    private List<Beam> mirrorSlash(Beam beam) {
        List<Beam> nextBeam = new ArrayList<>();
        switch (beam.direction()) {
            case RIGHT -> {
                nextBeam.add(new Beam(beam.row() - 1, beam.col(), Direction.UP));
            }
            case LEFT -> {
                nextBeam.add(new Beam(beam.row() + 1, beam.col(), Direction.DOWN));
            }
            case UP -> {
                nextBeam.add(new Beam(beam.row(), beam.col() + 1, Direction.RIGHT));
            }
            case DOWN -> {
                nextBeam.add(new Beam(beam.row(), beam.col() - 1, Direction.LEFT));
            }
        }
        return nextBeam;
    }

    private List<Beam> emptySpace(Beam beam) {
        List<Beam> nextBeam = new ArrayList<>();
        switch (beam.direction()) {
            case RIGHT -> {
                nextBeam.add(new Beam(beam.row(), beam.col() + 1, beam.direction()));
            }
            case LEFT -> {
                nextBeam.add(new Beam(beam.row(), beam.col() - 1, beam.direction()));
            }
            case UP -> {
                nextBeam.add(new Beam(beam.row() - 1, beam.col(), beam.direction()));
            }
            case DOWN -> {
                nextBeam.add(new Beam(beam.row() + 1, beam.col(), beam.direction()));
            }
        }
        return nextBeam;
    }
}
