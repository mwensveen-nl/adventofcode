package nl.mwensveen.adventofcode.year_2022.day_08;

import com.google.common.collect.Table;
import java.util.stream.IntStream;

public class VisibilityChecker {

    private int maxRow;
    private int maxColumn;

    public long checkVisibility(Table<Integer, Integer, Tree> forest) {
        maxRow = forest.rowKeySet().size() - 1;
        maxColumn = forest.columnKeySet().size() - 1;
        return IntStream.rangeClosed(0, maxRow).mapToLong(r -> IntStream.rangeClosed(0, maxColumn).mapToObj(c -> checkVisibilityForTree(forest, r, c)).filter(b -> b).count()).sum();
    }

    private boolean checkVisibilityForTree(Table<Integer, Integer, Tree> forest, int r, int c) {
        Tree tree = forest.get(r, c);
        if (r == 0 || c == 0 || r == maxRow || c == maxColumn) {
            tree.setVisible(true);
            return true;
        }

        int height = tree.getHeight();

        // left
        boolean visible = true;
        for (int c2 = 0; c2 < c && visible; c2++) {
            if (height <= forest.get(r, c2).getHeight()) {
                visible = false;
            }
        }
        if (visible == true) {
            tree.setVisible(true);
            return true;
        }

        // right
        visible = true;
        for (int c2 = c + 1; c2 <= maxColumn && visible; c2++) {
            if (height <= forest.get(r, c2).getHeight()) {
                visible = false;
            }
        }
        if (visible == true) {
            tree.setVisible(true);
            return true;
        }

        // up
        visible = true;
        for (int r2 = 0; r2 < r && visible; r2++) {
            if (height <= forest.get(r2, c).getHeight()) {
                visible = false;
            }
        }
        if (visible == true) {
            tree.setVisible(true);
            return true;
        }

        // down
        visible = true;
        for (int r2 = r + 1; r2 <= maxColumn && visible; r2++) {
            if (height <= forest.get(r2, c).getHeight()) {
                visible = false;
            }
        }
        if (visible == true) {
            tree.setVisible(true);
            return true;
        }

        tree.setVisible(false);
        return false;
    }
}
