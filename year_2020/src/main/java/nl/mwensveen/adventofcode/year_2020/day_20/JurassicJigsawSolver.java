package nl.mwensveen.adventofcode.year_2020.day_20;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class JurassicJigsawSolver extends AbstractTimedSolution {
    private List<String> input;
    private Grid imageGrid;

    public static void main(String[] args) {
        new JurassicJigsawSolver().run();
    }

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("Day_20.txt");
    }

    @Override
    protected void part1() {
        InputParser inputParser = new InputParser();
        List<Image> images = inputParser.parse(input);
        ImageArranger imageArranger = new ImageArranger();
        imageGrid = imageArranger.arrange(images);
        Image image1 = imageGrid.get(imageGrid.getMinX(), imageGrid.getMinY());
        Image image2 = imageGrid.get(imageGrid.getMinX(), imageGrid.getMaxY());
        Image image3 = imageGrid.get(imageGrid.getMaxX(), imageGrid.getMaxY());
        Image image4 = imageGrid.get(imageGrid.getMaxX(), imageGrid.getMinY());
        Long id1 = Long.valueOf(image1.getId());
        Long id2 = Long.valueOf(image2.getId());
        Long id3 = Long.valueOf(image3.getId());
        Long id4 = Long.valueOf(image4.getId());
        System.out.println("multiplying together the IDs of the four corner tiles = " + id1 * id2 * id3 * id4);
    }

    @Override
    protected void part2() {
        ImageMerger imageMerger = new ImageMerger();
        Image mergedImage = imageMerger.merge(imageGrid);

        SeamonsterProcessor seamonsterProcessor = new SeamonsterProcessor();
        int result = seamonsterProcessor.processSeamonsterInImage(mergedImage);
        System.out.println("Number of # that are not part of a sea monster = " + result);

    }

}
