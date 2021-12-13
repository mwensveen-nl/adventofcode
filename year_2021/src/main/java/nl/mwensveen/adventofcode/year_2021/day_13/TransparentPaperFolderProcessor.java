package nl.mwensveen.adventofcode.year_2021.day_13;

import com.google.common.collect.Table;
import java.util.List;
import java.util.Optional;

public class TransparentPaperFolderProcessor {

    int procesPaper(List<String> input, Optional<Integer> numberOfInstructions) {
        TransparentPaperParser transparentPaperParser = new TransparentPaperParser();
        Table<Integer, Integer, Character> paper = transparentPaperParser.parsePaper(input);

        List<String> instructions = transparentPaperParser.parseInstructions(input);
        if (numberOfInstructions.isPresent()) {
            instructions = instructions.subList(0, numberOfInstructions.get());
        }

        PaperFolder paperFolder = new PaperFolder();
        for (String instruction : instructions) {
            paper = paperFolder.foldPaper(instruction, paper);
        }

        if (numberOfInstructions.isEmpty()) {
            PaperPrinter paperPrinter = new PaperPrinter();
            paperPrinter.printPaper(paper);
        }
        return paper.values().size();
    }
}
