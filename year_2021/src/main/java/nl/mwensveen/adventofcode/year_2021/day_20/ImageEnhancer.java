package nl.mwensveen.adventofcode.year_2021.day_20;

import com.google.common.collect.Table;
import java.util.List;

public class ImageEnhancer {

    public long enhanceImage(List<String> input, int count) {
        ImageParser imageParser = new ImageParser();
        Table<Integer, Integer, Pixel> image = imageParser.parseImage(input);
        List<String> imageEnhancementAlgorithm = imageParser.parseImageEnhancementAlgorithm(input);
        ImageDimension dimension = new ImageDimension(image);

        EnhancementProcessor enhancementProcessor = new EnhancementProcessor();
        for (int i = 0; i < count; i++) {
            int mod = i % 2;
            image = enhancementProcessor.enhance(image, dimension, imageEnhancementAlgorithm, (mod == 0) ? "." : imageEnhancementAlgorithm.get(0));
        }

        return image.values().stream().filter(p -> p.equals(Pixel.LIGHT)).count();
    }
}
