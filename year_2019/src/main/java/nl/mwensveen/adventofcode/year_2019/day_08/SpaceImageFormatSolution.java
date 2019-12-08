package nl.mwensveen.adventofcode.year_2019.day_08;

import nl.mwensveen.adventofcode.year_2019.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2019.FileReadHelper;

public class SpaceImageFormatSolution extends AbstractTimedSolution {
    public static void main(String[] args) {
        SpaceImageFormatSolution solution = new SpaceImageFormatSolution();
        solution.run();
    }

    @Override
    protected void part1() {
        ImageDecoder decoder = new ImageDecoder();
        Image image = decoder.decodeImage(FileReadHelper.readStringAsIntegers("Day08.txt"), 25, 6);
        ImageChecker checker = new ImageChecker();
        int checkSum = checker.checkImage(image);
        System.out.println("Checksum part 1 = " + checkSum);
    }

    @Override
    protected void part2() {
        ImageDecoder decoder = new ImageDecoder();
        Image image = decoder.decodeImage(FileReadHelper.readStringAsIntegers("Day08.txt"), 25, 6);
        ImageRenderer imageRenderer = new ImageRenderer(image, 25, 6);
        imageRenderer.renderImage();
    }

}
