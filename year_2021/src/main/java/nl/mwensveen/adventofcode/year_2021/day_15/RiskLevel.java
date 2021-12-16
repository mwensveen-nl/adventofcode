package nl.mwensveen.adventofcode.year_2021.day_15;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;

public class RiskLevel {
    private final int row;
    private final int column;
    private final int risk;
    private boolean visited = false;
    private long distance = Long.MAX_VALUE;
    private RiskLevel up;
    private RiskLevel down;
    private RiskLevel left;
    private RiskLevel right;

    public RiskLevel(int row, int column, int risk) {
        this.row = row;
        this.column = column;
        this.risk = risk;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getRisk() {
        return risk;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public RiskLevel getUp() {
        return up;
    }

    public void setUp(RiskLevel up) {
        this.up = up;
    }

    public RiskLevel getDown() {
        return down;
    }

    public void setDown(RiskLevel down) {
        this.down = down;
    }

    public RiskLevel getLeft() {
        return left;
    }

    public void setLeft(RiskLevel left) {
        this.left = left;
    }

    public RiskLevel getRight() {
        return right;
    }

    public void setRight(RiskLevel right) {
        this.right = right;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }
        if (!getClass().equals(other.getClass())) {
            return false;
        }
        RiskLevel castOther = (RiskLevel) other;
        return Objects.equal(row, castOther.row) && Objects.equal(column, castOther.column);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(row, column);
    }

    public List<RiskLevel> notVisitedAdjents() {
        List<RiskLevel> riskLevels = new ArrayList<>();
        if (isNotVisited(up)) {
            riskLevels.add(up);
        }
        if (isNotVisited(down)) {
            riskLevels.add(down);
        }
        if (isNotVisited(left)) {
            riskLevels.add(left);
        }
        if (isNotVisited(right)) {
            riskLevels.add(right);
        }
        return riskLevels;
    }

    private boolean isNotVisited(RiskLevel rl) {
        return rl != null && !rl.isVisited();
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("row", row).add("column", column).add("visited", visited).add("distance", distance).toString();
    }

}
