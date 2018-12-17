package nl.mwensveen.adventofcode.year_2018.day_10;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MessageCalculator {
    private static final String X_REGEXP = ".*?([-]?\\d+)";
    private static final Pattern X_PATTERN = Pattern.compile(X_REGEXP, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final String Y_REGEXP = ".*?\\d+.*?([-]?\\d+)";
    private static final Pattern Y_PATTERN = Pattern.compile(Y_REGEXP, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final String VELOCITY_X_REGEXP = ".*?\\d+.*?\\d+.*?([-]?\\d+)";
    private static final Pattern VELOCITY_X_PATTERN = Pattern.compile(VELOCITY_X_REGEXP, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private static final String VELOCITY_Y_REGEXP = ".*?\\d+.*?\\d+.*?\\d+.*?([-]?\\d+)";
    private static final Pattern VELOCITY_Y_PATTERN = Pattern.compile(VELOCITY_Y_REGEXP, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    private List<Point> sky;

    public MessageCalculator(List<String> input) {
        sky = new ArrayList<>();
        for (String line : input) {
            Integer x = Integer.valueOf(extract(line, X_PATTERN));
            Integer y = Integer.valueOf(extract(line, Y_PATTERN));
            Integer velocityX = Integer.valueOf(extract(line, VELOCITY_X_PATTERN));
            Integer velocityY = Integer.valueOf(extract(line, VELOCITY_Y_PATTERN));
            sky.add(new Point(x, y, new Velocity(velocityX, velocityY)));
        }
    }

    public int makeMessage() {
        Integer xSpread = xSpread();
        Integer ySpread = ySpread();

        List<Point> skyOld = sky;

        sky = movePointsInSky();
        Integer xSpreadNew = xSpread();
        Integer ySpreadNew = ySpread();
        int sec = 1;
        while (xSpread > xSpreadNew && ySpread > ySpreadNew) {
            sec++;
            skyOld = sky;
            xSpread = xSpreadNew;
            ySpread = ySpreadNew;
            sky = movePointsInSky();
            xSpreadNew = xSpread();
            ySpreadNew = ySpread();
        }
        sky = skyOld;
        printSky();
        return sec - 1;
    }

    private void printSky() {
        int minX = sky.stream().mapToInt(p -> p.getX()).min().getAsInt();
        int maxX = sky.stream().mapToInt(p -> p.getX()).max().getAsInt();
        int minY = sky.stream().mapToInt(p -> p.getY()).min().getAsInt();
        int maxY = sky.stream().mapToInt(p -> p.getY()).max().getAsInt();

        Table<Integer, Integer, String> print = HashBasedTable.create();
        for (Point point : sky) {
            print.put(point.getX(), point.getY(), "#");
        }
        for (int c = minY; c <= maxY; c++) {
            for (int r = minX; r <= maxX; r++) {
                if (print.contains(r, c)) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
                // System.out.println(r + " " + c);
            }
            System.out.println();

        }
    }

    private int ySpread() {
        return sky.stream().mapToInt(Point::getY).max().getAsInt() - sky.stream().mapToInt(Point::getY).min().getAsInt();
    }

    private int xSpread() {
        return sky.stream().mapToInt(Point::getX).max().getAsInt() - sky.stream().mapToInt(Point::getX).min().getAsInt();
    }

    private List<Point> movePointsInSky() {
        return sky.stream().map(p -> new Point(p.getX() + p.getVelocity().getVelocityX(), p.getY() + p.getVelocity().getVelocityY(), p.getVelocity()))
                .collect(Collectors.toList());
    }

    private String extract(String input, Pattern p) {
        Matcher m = p.matcher(input);
        if (m.find()) {
            String s = m.group(1);
            return s.trim();
        }
        return null;
    }
}
