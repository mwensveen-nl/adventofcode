package nl.mwensveen.adventofcode.year_2018.day_17;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class GroundWater {

    private List<String> input;
    private Table<Integer, Integer, Type> ground = HashBasedTable.create();

    private AtomicInteger minX = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger maxX = new AtomicInteger(Integer.MIN_VALUE);
    private AtomicInteger minY = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger maxY = new AtomicInteger(Integer.MIN_VALUE);

    private static final String REGEX = ".*?(\\d+).*?(\\d+).*?(\\d+)";
    private static final Pattern PATTERN = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

    public GroundWater(List<String> input) {
        this.input = input;
        Coordinate spring = new Coordinate(500, 0);
        setGround(spring, Type.SPRING);
        input.stream().forEach(s -> {
            if (s.startsWith("x")) {
                processWall(s);
            } else {
                processFloor(s);
            }
        });
        maxX.incrementAndGet();
        minX.decrementAndGet();
        printGround();
    }

    public long flowWater() {
        Coordinate start = new Coordinate(500, 0);
        flowWater(start);
        System.out.println();
        printGround();
        return countWater();
    }

    private long countWater() {
        long count = 0;
        for (int x = minX.get(); x <= maxX.get(); x++) {
            for (int y = minY.get(); y <= maxY.get(); y++) {
                Type t = ground.get(x, y);
                if (t == Type.WATER || t == Type.SAND_WATER) {
                    count++;
                }
            }
        }
        return count;
        // return ground.rowKeySet().stream().filter(i -> i >= minY.get() && i <= maxY.get()).map(ground::row).map(Map::values).flatMap(x -> x.stream())
        // .filter(t -> t == Type.WATER || t == Type.SAND_WATER).count();
    }

    private void flowWater(Coordinate c) {
        flowWaterDown(c);
        flowWaterHorizontal(c);
    }

    private void flowWaterHorizontal(Coordinate c) {
        // System.out.println("\nHorizontal " + c);
        boolean isWallLeft = isWallLeft(c);
        boolean isWallRight = isWallRight(c);
        if (isWallLeft && isWallRight) {
            setToWallLeft(c, Type.WATER);
            setToWallRight(c, Type.WATER);
            setGround(c, Type.WATER);
        } else if (isWallLeft && !isWallRight) {
            setToWallLeft(c, Type.SAND_WATER);
            setToWallDownRight(c);
        } else if (isWallRight && !isWallLeft) {
            setToWallRight(c, Type.SAND_WATER);
            setToWallDownLeft(c);
        } else if (!isWallRight && !isWallLeft) {
            setToWallDownRight(c);
            setToWallDownLeft(c);
        }
        // printGround();
    }

    private void setToWallDownLeft(Coordinate c) {
        Coordinate left = c.left();
        Optional<Type> groundLeftOpt = getGround(left);
        if (groundLeftOpt.isPresent() && groundLeftOpt.get() == Type.SAND) {
            Optional<Type> groundLeftDownOpt = getGround(left.down());
            if (!groundLeftDownOpt.isPresent()) {
                return;
            }
            Type groundH = groundLeftDownOpt.get();
            while (groundH == Type.WATER || groundH == Type.CLAY) {
                setGround(left, Type.SAND_WATER);
                left = left.left();
                groundLeftDownOpt = getGround(left.down());
                if (!groundLeftDownOpt.isPresent()) {
                    return;
                }
                groundH = groundLeftDownOpt.get();
            }
            Optional<Type> groundRD = getGround(left.right().down());
            if (groundRD.isPresent() && groundRD.get() == Type.CLAY) {
                setGround(left, Type.SAND_WATER);
                flowWater(left);
            }
        }
    }

    private void setToWallDownRight(Coordinate c) {
        Coordinate right = c.right();
        Optional<Type> groundRightOpt = getGround(right);
        if (groundRightOpt.isPresent() && groundRightOpt.get() == Type.SAND) {
            Optional<Type> groundRightDownOpt = getGround(right.down());
            if (!groundRightDownOpt.isPresent()) {
                return;
            }
            Type groundRightDown = groundRightDownOpt.get();

            while (groundRightDown == Type.WATER || groundRightDown == Type.CLAY) {
                setGround(right, Type.SAND_WATER);
                right = right.right();
                groundRightDownOpt = getGround(right.down());
                if (!groundRightDownOpt.isPresent()) {
                    return;
                }
                groundRightDown = groundRightDownOpt.get();
            }
            Optional<Type> groundDown = getGround(right.left().down());
            if (groundDown.isPresent() && groundDown.get() == Type.CLAY) {
                setGround(right, Type.SAND_WATER);
                flowWater(right);
            }
        }
    }

    private void setToWallRight(Coordinate c, Type type) {
        Coordinate right = c.right();
        Optional<Type> groundRightOpt = getGround(right);
        while (groundRightOpt.isPresent() && groundRightOpt.get() != Type.CLAY) {
            setGround(right, type);
            right = right.right();
            groundRightOpt = getGround(right);
        }
    }

    private void setToWallLeft(Coordinate c, Type type) {
        Coordinate left = c.left();
        Optional<Type> groundLeftOpt = getGround(left);
        while (groundLeftOpt.isPresent() && groundLeftOpt.get() != Type.CLAY) {
            setGround(left, type);
            left = left.left();
            groundLeftOpt = getGround(left);
        }
    }

    private boolean isWallRight(Coordinate c) {
        boolean isWall = true;
        Coordinate right = c.right();
        while (isWall) {
            Type groundRight = getGround(right).get();
            if (groundRight == Type.CLAY) {
                break;
            }
            Optional<Type> groundRightDown = getGround(right.down());
            if (groundRightDown.isPresent() && (groundRightDown.get() == Type.CLAY || groundRightDown.get() == Type.WATER)) {
                right = right.right();
            } else {
                isWall = false;
            }
        }
        return isWall;
    }

    private boolean isWallLeft(Coordinate c) {
        boolean isWall = true;
        Coordinate left = c.left();
        while (isWall) {
            if (getGround(left).get() == Type.CLAY) {
                break;
            }
            Optional<Type> groundLeftDown = getGround(left.down());
            if (groundLeftDown.isPresent() && (groundLeftDown.get() == Type.CLAY || groundLeftDown.get() == Type.WATER)) {
                left = left.left();
            } else {
                isWall = false;
            }

        }
        return isWall;
    }

    private void flowWaterDown(Coordinate c) {
        // System.out.println("\nDown " + c);
        Coordinate down = c.down();
        Optional<Type> groundDown = getGround(down);
        if (groundDown.isPresent()) {
            switch (groundDown.get()) {
                case SAND:
                    setGround(down, Type.SAND_WATER);
                    flowWater(down);
                    break;
                default:
                    break;
            }
        }
        // printGround();
    }

    private void setGround(Coordinate c, Type type) {
        ground.put(c.getX(), c.getY(), type);
    }

    private Optional<Type> getGround(Coordinate c) {
        if (c.getY() <= maxY.get()) {
            Type type = ground.get(c.getX(), c.getY());
            if (type == null) {
                setGround(c, Type.SAND);
                return Optional.of(Type.SAND);
            }
            return Optional.of(type);
        }
        return Optional.empty();
    }

    private void printGround() {
        IntStream.rangeClosed(minY.get(), maxY.get()).forEach(this::printRow);
    }

    private void printRow(int y) {
        IntStream.rangeClosed(minX.get(), maxX.get()).forEach(x -> printCoordinate(x, y));
        System.out.println("  " + y);
    }

    private void printCoordinate(int x, int y) {
        Type type = ground.get(x, y);
        if (type != null) {
            switch (type) {
                case SPRING:
                    System.out.print("x");
                    break;
                case CLAY:
                    System.out.print("#");
                    break;
                case SAND:
                    System.out.print(".");
                    break;
                case SAND_WATER:
                    System.out.print("|");
                    break;
                case WATER:
                    System.out.print("~");
                    break;
            }
        } else {
            System.out.print(".");
        }
    }

    private void processFloor(String s) {
        List<Integer> coordinates = extract(s, PATTERN);
        int y = coordinates.get(0);
        minY(y);
        maxY(y);
        int xStart = coordinates.get(1);
        int xEnd = coordinates.get(2);
        minX(xStart);
        maxX(xEnd);
        IntStream.rangeClosed(xStart, xEnd).forEach(i -> ground.put(i, y, Type.CLAY));
    }

    private void processWall(String s) {
        List<Integer> coordinates = extract(s, PATTERN);
        int x = coordinates.get(0);
        minX(x);
        maxX(x);
        int yStart = coordinates.get(1);
        int yEnd = coordinates.get(2);
        minY(yStart);
        maxY(yEnd);
        IntStream.rangeClosed(yStart, yEnd).forEach(i -> ground.put(x, i, Type.CLAY));

    }

    private void maxX(int x) {
        maxX.set(Math.max(maxX.get(), x));
    }

    private void minX(int x) {
        minX.set(Math.min(minX.get(), x));
    }

    private void maxY(int y) {
        maxY.set(Math.max(maxY.get(), y));
    }

    private void minY(int y) {
        minY.set(Math.min(minY.get(), y));
    }

    private List<Integer> extract(String input, Pattern p) {
        Matcher m = p.matcher(input);
        if (m.find()) {
            Integer i0 = Integer.parseInt(m.group(1));
            Integer i1 = Integer.parseInt(m.group(2));
            Integer i2 = Integer.parseInt(m.group(3));
            return Arrays.asList(i0, i1, i2);
        }
        return null;
    }

    public long OnlyWater() {
        long count = 0;
        for (int x = minX.get(); x <= maxX.get(); x++) {
            for (int y = minY.get(); y <= maxY.get(); y++) {
                Type t = ground.get(x, y);
                if (t == Type.WATER) {
                    count++;
                }
            }
        }
        return count;
        // return ground.rowKeySet().stream().filter(i -> i >= minY.get() && i <= maxY.get()).map(ground::row).map(Map::values).flatMap(x -> x.stream())
        // .filter(t -> t == Type.WATER || t == Type.SAND_WATER).count();
    }
}
