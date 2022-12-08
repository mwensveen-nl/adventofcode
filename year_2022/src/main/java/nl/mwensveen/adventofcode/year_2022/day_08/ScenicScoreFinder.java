package nl.mwensveen.adventofcode.year_2022.day_08;

import com.google.common.collect.Table;
import java.util.stream.IntStream;

public class ScenicScoreFinder {

    private int maxRow;
    private int maxColumn;

    public int findScenicScore(Table<Integer, Integer, Tree> forest) {
        maxRow = forest.rowKeySet().size() - 1;
        maxColumn = forest.columnKeySet().size() - 1;
        return IntStream.range(1, maxRow).map(r -> IntStream.range(1, maxColumn).map(c -> calculateScenicScore(forest, r, c)).max().getAsInt()).max().getAsInt();
    }

    private int calculateScenicScore(Table<Integer, Integer, Tree> forest, int r, int c) {
        Tree tree = forest.get(r, c);

        int height = tree.getHeight();
        // left
        int i = c - 1;
        boolean visible = true;
        while (visible) {
            if (i == 0 || height <= forest.get(r, i).getHeight()) {
                visible = false;
            } else {
                i--;
            }
        }
        int left = c - i;

        // right
        visible = true;
        i = c + 1;
        while (visible) {
            if (i == maxColumn || height <= forest.get(r, i).getHeight()) {
                visible = false;
            } else {
                i++;
            }
        }
        int right = i - c;

        // up
        visible = true;
        i = r - 1;
        while (visible) {
            if (i == 0 || height <= forest.get(i, c).getHeight()) {
                visible = false;
            } else {
                i--;
            }
        }
        int up = r - i;

        // down
        visible = true;
        i = r + 1;
        while (visible) {
            if (i == maxRow || height <= forest.get(i, c).getHeight()) {
                visible = false;
            } else {
                i++;
            }
        }
        int down = i - r;

        return left * right * up * down;
    }
}
