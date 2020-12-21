package nl.mwensveen.adventofcode.year_2020.day_20;

import com.google.common.collect.Table;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SeamonsterReplacer {

    public List<String> replaceSeamonster(Image image) {
        List<String> newImage = new ArrayList<>();
        Seamonster seamonster = new Seamonster();
        int imageRowSize = image.getRowSize();
        for (int i = 0; i < image.getRowSize(); i++) {
            newImage.add(image.getRow(i));
        }
        String row;
        for (int r = Seamonster.FIND_ROW; r < imageRowSize; r++) {
            row = newImage.get(r);
            int index = Seamonster.FIND_COLUMN - 1;
            while (index >= 0) {
                index = row.indexOf(Seamonster.FIND, index + 1);
                if (index >= 0) {
                    boolean found = checkSeamonster(newImage, r, index, seamonster);
                    if (found) {
                        replaceSeamonster(newImage, r, index, seamonster);
                        row = newImage.get(r);
                    }
                }
            }
        }
        return newImage;
    }

    private void replaceSeamonster(List<String> newImage, int r, int index, Seamonster seamonster) {
        Table<Integer, Integer, String> table = seamonster.getTable();
        Set<Integer> seamonsterRows = seamonster.getTable().rowKeySet();
        for (Iterator<Integer> iterator = seamonsterRows.iterator(); iterator.hasNext();) {
            Integer rowKey = iterator.next();
            StringBuilder newRow = new StringBuilder();
            Map<Integer, String> seamonsterRow = table.row(rowKey);
            String row = newImage.get(r + rowKey);
            for (int c = 0; c < row.length(); c++) {
                if (seamonsterRow.containsKey(Integer.valueOf(c - index))) {
                    newRow.append("O");
                } else {
                    newRow.append(row.charAt(c));
                }
            }
            newImage.set(r + rowKey, newRow.toString());
        }
    }

    private boolean checkSeamonster(List<String> newImage, int r, int index, Seamonster seamonster) {
        Table<Integer, Integer, String> table = seamonster.getTable();
        boolean found = true;
        Set<Integer> seamonsterRows = seamonster.getTable().rowKeySet();
        for (Iterator<Integer> iterator = seamonsterRows.iterator(); iterator.hasNext() && found;) {
            Integer rowKey = iterator.next();
            Map<Integer, String> seamonsterRow = table.row(rowKey);
            String row = newImage.get(r + rowKey);
            found = seamonsterRow.keySet().stream().filter(si -> row.charAt(si + index) != '#').findAny().isEmpty();
        }
        return found;
    }
}
