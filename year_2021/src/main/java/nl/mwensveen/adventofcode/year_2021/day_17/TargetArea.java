package nl.mwensveen.adventofcode.year_2021.day_17;

public class TargetArea {
    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    boolean isBeyond(int x, int y) {
        return x > xMax || y < yMin;
    }

    boolean isInArea(int x, int y) {
        return x >= xMin && x <= xMax && y >= yMin && y <= yMax;
    }

    boolean isXInArea(int x) {
        return x >= xMin && x <= xMax;
    }

    static TargetArea parse(String input) {
        TargetArea targetArea = new TargetArea();

        String area = input.split(":")[1].trim();
        String[] xy = area.split(",");
        String x = xy[0].trim();
        String y = xy[1].trim();

        String[] val = x.split("=");
        val = val[1].split("\\.\\.");

        targetArea.xMin = Math.min(Integer.parseInt(val[0]), Integer.parseInt(val[1]));
        targetArea.xMax = Math.max(Integer.parseInt(val[0]), Integer.parseInt(val[1]));

        val = y.split("=");
        val = val[1].split("\\.\\.");
        targetArea.yMin = Math.min(Integer.parseInt(val[0]), Integer.parseInt(val[1]));
        targetArea.yMax = Math.max(Integer.parseInt(val[0]), Integer.parseInt(val[1]));

        return targetArea;
    }

    public int getxMin() {
        return xMin;
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMin() {
        return yMin;
    }

    public int getyMax() {
        return yMax;
    }
}
