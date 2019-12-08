package nl.mwensveen.adventofcode.year_2019.day_08;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private int wide;
    private int tall;

    private List<List<Integer>> rows = new ArrayList<>();
    private List<Integer> row;

    public Layer(int wide, int tall) {
        super();
        this.wide = wide;
        this.tall = tall;
        newRow();
    }

    private void newRow() {
        row = new ArrayList<>();
        rows.add(row);
    }

    public void addPixel(Integer pixel) {
        if (row.size() == wide) {
            if (rows.size() == tall) {
                throw new RuntimeException("This layer is full");
            }
            newRow();
        }
        row.add(pixel);
    }

    public boolean isFull() {
        return row.size() == wide && rows.size() == tall;
    }

    public int countPixelsOfColor(int c) {
        int n = 0;
        for (int i = 0; i < rows.size(); i++) {
            List<Integer> rowFromLayer = rows.get(i);
            for (int j = 0; j < rowFromLayer.size(); j++) {
                if (c == rowFromLayer.get(j)) {
                    n++;
                }
            }

        }
        return n;
    }
}
