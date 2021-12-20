package nl.mwensveen.adventofcode.year_2021.day_20;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.math.BigInteger;
import java.util.List;

public class EnhancementProcessor {

    Table<Integer, Integer, Pixel> enhance(Table<Integer, Integer, Pixel> image, ImageDimension dimension, List<String> algorithm, String out) {
        Table<Integer, Integer, Pixel> newImage = HashBasedTable.create();
        for (int r = dimension.getMinRow() - 1; r <= dimension.getMaxRow() + 1; r++) {
            for (int c = dimension.getMinColumn() - 1; c <= dimension.getMaxColumn() + 1; c++) {
                newImage.put(r, c, enhancePixel(r, c, image, algorithm, out));
            }
        }
        dimension.setMinRow(dimension.getMinRow() - 1);
        dimension.setMaxRow(dimension.getMaxRow() + 1);
        dimension.setMinColumn(dimension.getMinColumn() - 1);
        dimension.setMaxColumn(dimension.getMaxColumn() + 1);
        return newImage;
    }

    private Pixel enhancePixel(int r, int c, Table<Integer, Integer, Pixel> image, List<String> algorithm, String out) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPixel(r - 1, c - 1, image, out));
        sb.append(getPixel(r - 1, c, image, out));
        sb.append(getPixel(r - 1, c + 1, image, out));
        sb.append(getPixel(r, c - 1, image, out));
        sb.append(getPixel(r, c, image, out));
        sb.append(getPixel(r, c + 1, image, out));
        sb.append(getPixel(r + 1, c - 1, image, out));
        sb.append(getPixel(r + 1, c, image, out));
        sb.append(getPixel(r + 1, c + 1, image, out));

        BigInteger pos = new BigInteger(sb.toString(), 2);
        return Pixel.find(algorithm.get(pos.intValue()));
    }

    private String getPixel(int r, int c, Table<Integer, Integer, Pixel> image, String out) {
        if (image.contains(r, c)) {
            return image.get(r, c).getBit();
        }
        return Pixel.find(out).getBit();
    }
}
