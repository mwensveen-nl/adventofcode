package nl.mwensveen.adventofcode.year_2020.day_20;

import com.google.common.collect.Table;
import java.util.Map;

public class SeamonsterSearcher {

    public boolean findSeamonster(Image image) {
        Seamonster seamonster = new Seamonster();
        int imageRowSize = image.getRowSize();

        boolean foundSeamonster = false;
        for (int r = Seamonster.FIND_ROW; r < imageRowSize && !foundSeamonster; r++) {
            String row = image.getRow(r);
            int index = Seamonster.FIND_COLUMN - 1;
            while (index >= 0 && !foundSeamonster) {
                index = row.indexOf(Seamonster.FIND, index + 1);
                if (index >= 0) {
                    foundSeamonster = checkSeamonster(image, r, index, seamonster);
                }
            }
        }
        return foundSeamonster;
    }

    private boolean checkSeamonster(Image image, int r, int index, Seamonster seamonster) {
        Table<Integer, Integer, String> table = seamonster.getTable();
        boolean found = true;
        for (int sr = 0; sr < seamonster.getRows() && found; sr++) {
            Map<Integer, String> seamonsterRow = table.row(sr);
            String row = image.getRow(r + sr);
            found = seamonsterRow.keySet().stream().filter(si -> row.charAt(si + index) != '#').findAny().isEmpty();
        }
        return found;
    }

}
