package nl.mwensveen.adventofcode.year_2019.day_10;

import java.math.BigDecimal;
import java.util.Optional;

public class LineCalculator {
    private BigDecimal m;
    private BigDecimal b;
    private Point one;
    private Point two;
    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal xEnd;
    private BigDecimal yEnd;
    private boolean vertical = false;

    public LineCalculator(Point one, Point two) {
        if (one.getX() > two.getX()) {
            this.one = two;
            this.two = one;
        } else {
            this.one = one;
            this.two = two;
        }
        initLine();
        x = new BigDecimal(this.one.getX());
        xEnd = new BigDecimal(this.two.getX());
        if (one.getY() > two.getY()) {
            y = new BigDecimal(two.getY());
            yEnd = new BigDecimal(one.getY());
        } else {
            y = new BigDecimal(one.getY());
            yEnd = new BigDecimal(two.getY());
        }
    }

    private void initLine() {
        // y = mx+b
        // m = (y2-y1)/(x2-x1)
        // b = y1 - (mx1)

        int xDiff = two.getX() - one.getX();
        if (xDiff == 0) {
            vertical = true;

        } else {
            m = new BigDecimal((0.0 + two.getY() - one.getY()) / xDiff);
            b = new BigDecimal(one.getY()).subtract(m.multiply(new BigDecimal(one.getX())));
        }

        System.out.println("y = " + m + " * x + " + b);
    }

    public Optional<Point> next() {
        if (vertical) {
            y = y.add(BigDecimal.ONE);
            if (y.compareTo(yEnd) < 0) {
                return Optional.of(new Point(x.intValue(), y.intValue()));
            }
            return Optional.empty();
        }
        x = x.add(BigDecimal.ONE);
        if (x.compareTo(xEnd) < 0) {
            BigDecimal newY = m.multiply(x).add(b);
            if (isInteger(newY)) {
                return Optional.of(new Point(x.intValue(), newY.intValue()));
            } else {
                return next();
            }
        }
        return Optional.empty();
    }

    private boolean isInteger(BigDecimal number) {
        return number.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0;
    }
}
