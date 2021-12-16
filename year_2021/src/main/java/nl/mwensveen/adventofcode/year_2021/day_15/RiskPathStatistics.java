
package nl.mwensveen.adventofcode.year_2021.day_15;

public class RiskPathStatistics {
    private long minPath = Long.MAX_VALUE;
    private int maxRow;
    private int maxColumn;

    public RiskPathStatistics(Integer rows, Integer columns) {
        maxRow = rows;
        maxColumn = columns;
    }

    public long getMinPath() {
        return minPath;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public int getMaxColumn() {
        return maxColumn;
    }

    public void setMinPath(long minPath) {
        this.minPath = minPath;
    }

}
