package nl.mwensveen.adventofcode.year_2021.day_20;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.List;
import java.util.stream.Collectors;

public class ImageParser {

    Table<Integer, Integer, Pixel> parseImage(List<String> input) {
        Table<Integer, Integer, Pixel> image = HashBasedTable.create();
        StreamUtils.zipWithIndex(input.stream().skip(2)).forEach(ir -> parseRow(ir, image));
        return image;
    }

    List<String> parseImageEnhancementAlgorithm(List<String> input) {
        return stringAsList(input.get(0));
    }

    private void parseRow(Indexed<String> ir, Table<Integer, Integer, Pixel> image) {
        int rowNr = (int) ir.getIndex();
        String row = ir.getValue();

        StreamUtils.zipWithIndex(stringAsList(row).stream()).forEach(ic -> parseColumn(rowNr, ic, image));
    }

    private void parseColumn(int rowNr, Indexed<String> ic, Table<Integer, Integer, Pixel> image) {
        int columnNr = (int) ic.getIndex();
        image.put(rowNr, columnNr, Pixel.find(ic.getValue()));
    }

    private List<String> stringAsList(String signal) {
        return signal.chars().mapToObj(e -> Character.toString(e)).collect(Collectors.toList());
    }
}
