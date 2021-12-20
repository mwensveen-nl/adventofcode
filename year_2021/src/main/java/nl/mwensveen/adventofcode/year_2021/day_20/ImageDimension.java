package nl.mwensveen.adventofcode.year_2021.day_20;

import com.google.common.collect.Table;
import java.util.Comparator;

public class ImageDimension {

    private int minRow;
    private int maxRow;
    private int minColumn;
    private int maxColumn;

    public ImageDimension(Table<Integer, Integer, Pixel> image) {
        minRow = image.rowKeySet().stream().min(Comparator.comparingInt(i -> i)).get();
        maxRow = image.rowKeySet().stream().max(Comparator.comparingInt(i -> i)).get();
        minColumn = image.columnKeySet().stream().min(Comparator.comparingInt(i -> i)).get();
        maxColumn = image.columnKeySet().stream().max(Comparator.comparingInt(i -> i)).get();
    }

    public int getMinRow() {
        return minRow;
    }

    public void setMinRow(int minRow) {
        this.minRow = minRow;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(int maxRow) {
        this.maxRow = maxRow;
    }

    public int getMinColumn() {
        return minColumn;
    }

    public void setMinColumn(int minColumn) {
        this.minColumn = minColumn;
    }

    public int getMaxColumn() {
        return maxColumn;
    }

    public void setMaxColumn(int maxColumn) {
        this.maxColumn = maxColumn;
    }

}
