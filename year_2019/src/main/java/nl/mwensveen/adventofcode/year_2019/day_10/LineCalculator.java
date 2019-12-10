package nl.mwensveen.adventofcode.year_2019.day_10;

import java.util.Optional;

public class LineCalculator {
    private Point one;
    private Point two;
    private boolean vertical = false;
    private int quotients;
    private int remainder;
    private int counter = 0;
    private int xDiff;
    private int yDiff;

    public LineCalculator(Point one, Point two) {
        if (one.getX() == two.getX()) {
            vertical = true;
            setForVertical(one, two);
        } else {
            setForLine(one, two);
            initLine();
        }
    }

    private void setForVertical(Point one, Point two) {
        if (one.getY() > two.getY()) {
            this.one = two;
            this.two = one;
        } else {
            this.one = one;
            this.two = two;
        }
        yDiff = this.two.getY() - this.one.getY();
    }

    private void setForLine(Point one, Point two) {
        if (one.getX() > two.getX()) {
            this.one = two;
            this.two = one;
        } else {
            this.one = one;
            this.two = two;
        }
    }

    private void initLine() {
        xDiff = two.getX() - one.getX();
        yDiff = two.getY() - one.getY();
        quotients = yDiff / xDiff;
        remainder = yDiff % xDiff;

        // System.out.println("one " + one + " two " + two + " xdiff " + xDiff + " ydiff " + yDiff + " = q " + quotients + " r " + remainder);
    }

    public Optional<Point> next() {
        counter++;
        if (vertical) {
            if (counter < yDiff) {
                return Optional.of(new Point(one.getX(), one.getY() + counter));
            }
        }
        if (counter < xDiff) {
            int foo = counter * remainder;
            if (foo % xDiff == 0) {
                return Optional.of(new Point(one.getX() + counter, one.getY() + quotients * counter + remainder * counter / xDiff));
            } else {
                return next();
            }
        }
        return Optional.empty();

    }
}
