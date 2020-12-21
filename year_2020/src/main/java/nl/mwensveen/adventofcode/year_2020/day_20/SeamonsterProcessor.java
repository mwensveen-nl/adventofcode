package nl.mwensveen.adventofcode.year_2020.day_20;

import java.util.List;
import java.util.stream.Collectors;

public class SeamonsterProcessor {

    public int processSeamonsterInImage(Image image) {
        SeamonsterSearcher seamonsterSearcher = new SeamonsterSearcher();
        boolean found = seamonsterSearcher.findSeamonster(image);
        ;
        boolean flip = false;
        while (!found) {
            if (flip) {
                image.flip();
            } else {
                image.rotate();
            }
            flip = !flip;
            found = seamonsterSearcher.findSeamonster(image);
        }
        SeamonsterReplacer seamonsterReplacer = new SeamonsterReplacer();
        List<String> replacedImage = seamonsterReplacer.replaceSeamonster(image);

        return replacedImage.stream().map(row -> countInRow(row)).collect(Collectors.summingInt(Integer::intValue));
    }

    private Integer countInRow(String row) {
        int count = 0;
        for (int i = 0; i < row.length(); i++) {
            if (row.charAt(i) == '#') {
                count++;
            }
        }
        return count;
    }
}
