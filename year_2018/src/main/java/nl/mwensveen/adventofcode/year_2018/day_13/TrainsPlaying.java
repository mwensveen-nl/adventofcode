package nl.mwensveen.adventofcode.year_2018.day_13;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class TrainsPlaying {
    Table<Integer, Integer, TrackPart> track = HashBasedTable.create();
    List<Train> trains = new ArrayList();

    public TrainsPlaying(List<String> input) {
        StreamUtils.zipWithIndex(input.stream()).forEach(i -> procesLine(i.getIndex(), i.getValue()));
    }

    public Position findCollision() {
        Optional<Train> collidingTrain = Optional.empty();
        while (!collidingTrain.isPresent()) {
            collidingTrain = trains.stream().sorted((t1, t2) -> t1.getPosition().compareTo(t2.getPosition())).filter(t -> {
                TrackPart trackPart = track.get(t.getPosition().getX(), t.getPosition().getY());
                t.move(trackPart);
                return trains.stream().filter(t2 -> t.collision(t2)).findFirst().isPresent();
            }).findFirst();
        }
        return collidingTrain.get().getPosition();
    }

    public Position findNonCollisionTrain() {
        AtomicInteger numberOfTrains = new AtomicInteger(trains.size());
        while (numberOfTrains.get() > 1) {
            trains.stream().filter(Train::isActive).sorted((t1, t2) -> t1.getPosition().compareTo(t2.getPosition())).forEach(t -> {
                TrackPart trackPart = track.get(t.getPosition().getX(), t.getPosition().getY());
                t.move(trackPart);
                trains.stream().filter(Train::isActive).forEach(t2 -> {
                    if (t.collision(t2)) {
                        t.delete();
                        t2.delete();
                        numberOfTrains.set(numberOfTrains.get() - 2);
                    }
                });
            });
        }
        return trains.stream().filter(Train::isActive).findFirst().get().getPosition();
    }

    private void procesLine(long y, String line) {
        StreamUtils.zipWithIndex(line.chars().mapToObj(c -> Character.toString((char) c))).forEach(i -> procesCoordinate(i.getIndex(), y, i.getValue()));
    }

    private void procesCoordinate(long x, long y, String value) {
        if (" ".equals(value)) {
            return;
        }
        Optional<Direction> d = Direction.valueFrom(value);
        if (d.isPresent()) {
            Direction direction = d.get();
            trains.add(new Train((int) x, (int) y, direction));
            switch (direction) {
                case UP:
                case DOWN:
                    track.put((int) x, (int) y, TrackPart.STRAIGHT_VERTICAL);
                    break;

                case LEFT:
                case RIGHT:
                    track.put((int) x, (int) y, TrackPart.STRAIGHT_HORIZONTAL);
                    break;
            }
        } else {
            track.put((int) x, (int) y, TrackPart.valueForSymbol(value));
        }
    }
}
