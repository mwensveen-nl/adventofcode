package nl.mwensveen.adventofcode.year_2021.day_13;

import java.util.List;
import java.util.Optional;
import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class TransparentOrigamiSolution extends AbstractTimedSolution {

    private List<String> input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_13.txt");
    }

    @Override
    protected void part1() {
        TransparentPaperFolderProcessor processor = new TransparentPaperFolderProcessor();
        int result = processor.procesPaper(input, Optional.of(1));
        System.out.println("Number of dots visible after completing just the first fold instruction on the transparent paper: " + result);
    }

    @Override
    protected void part2() {
        System.out.println("Code to use to activate the infrared thermal imaging camera system:");
        TransparentPaperFolderProcessor processor = new TransparentPaperFolderProcessor();
        int result = processor.procesPaper(input, Optional.empty());

    }

    public static void main(String[] args) {
        new TransparentOrigamiSolution().run();
    }

}
