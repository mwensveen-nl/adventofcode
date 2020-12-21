package nl.mwensveen.adventofcode.year_2020.day_20;

import com.google.common.base.Objects;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;

public class Image {

    private Table<Integer, Integer, String> table = HashBasedTable.create();
    private int rotated = 0;
    private boolean flipped = false;
    private final String id;
    private int rowSize = 0;
    private int columnSize = 0;

    public Image(String id) {
        super();
        this.id = id;
    }

    public void addLine(String in) {
        String[] pixels = in.split("");
        for (int i = 0; i < pixels.length; i++) {
            String p = pixels[i];
            table.put(rowSize, i, p);
        }
        rowSize++;
        columnSize = Math.max(in.length(), columnSize);
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public String getRow(int i) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> row;
        if (!flipped) {
            if (rotated == 0) {
                row = table.row(i);
                row.values().forEach(pixel -> sb.append(pixel));
            } else if (rotated == 1) {
                row = table.column(i);
                row.values().forEach(pixel -> sb.append(pixel));
                sb.reverse();
            } else if (rotated == 2) {
                row = table.row(table.rowKeySet().size() - i - 1);
                row.values().forEach(pixel -> sb.append(pixel));
                sb.reverse();
            } else if (rotated == 3) {
                row = table.column(table.columnKeySet().size() - i - 1);
                row.values().forEach(pixel -> sb.append(pixel));
            }
        } else {
            if (rotated == 0) {
                row = table.row(i);
                row.values().forEach(pixel -> sb.append(pixel));
                sb.reverse();
            } else if (rotated == 1) {
                row = table.column(table.rowKeySet().size() - i - 1);
                row.values().forEach(pixel -> sb.append(pixel));
                sb.reverse();
            } else if (rotated == 2) {
                row = table.row(table.rowKeySet().size() - i - 1);
                row.values().forEach(pixel -> sb.append(pixel));
            } else if (rotated == 3) {
                row = table.column(i);
                row.values().forEach(pixel -> sb.append(pixel));
            }
        }
        return sb.toString();
    }

    public String getColumn(int i) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> column;
        if (!flipped) {
            if (rotated == 0) {
                column = table.column(i);
                column.values().forEach(pixel -> sb.append(pixel));
            } else if (rotated == 1) {
                column = table.row(table.rowKeySet().size() - i - 1);
                column.values().forEach(pixel -> sb.append(pixel));
            } else if (rotated == 2) {
                column = table.column(table.columnKeySet().size() - i - 1);
                column.values().forEach(pixel -> sb.append(pixel));
                sb.reverse();
            } else if (rotated == 3) {
                column = table.row(i);
                column.values().forEach(pixel -> sb.append(pixel));
                sb.reverse();
            }
        } else {
            if (rotated == 0) {
                column = table.column(table.rowKeySet().size() - i - 1);
                column.values().forEach(pixel -> sb.append(pixel));
            } else if (rotated == 1) {
                column = table.row(table.rowKeySet().size() - i - 1);
                column.values().forEach(pixel -> sb.append(pixel));
                sb.reverse();
            } else if (rotated == 2) {
                column = table.column(i);
                column.values().forEach(pixel -> sb.append(pixel));
                sb.reverse();
            } else if (rotated == 3) {
                column = table.row(i);
                column.values().forEach(pixel -> sb.append(pixel));
            }
        }
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void flip() {
        flipped = !flipped;
    }

    public void rotate() {
        rotated++;
        if (rotated > 3) {
            rotated = 0;
        }
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Image)) {
            return false;
        }
        Image castOther = (Image) other;
        return Objects.equal(id, castOther.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(" ").append("r:").append(rotated).append(" ").append("t:").append(flipped);
        table.rowKeySet().forEach(r -> sb.append("\n").append(getRow(r)));
        return sb.toString();
    }

}
