package nl.mwensveen.adventofcode.year_2020.day_25;

import java.util.List;
import nl.mwensveen.adventofcode.year_2020.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2020.FileReadHelper;

public class ComboBreakerSolution extends AbstractTimedSolution {
    public static void main(String[] args) {
        new ComboBreakerSolution().run();
    }

    private Integer doorPublicKey;
    private Integer cardPublicKey;

    @Override
    protected void init() {
        List<Integer> input = FileReadHelper.readLinesAsIntegers("Day_25.txt");
        doorPublicKey = input.get(0);
        cardPublicKey = input.get(1);

    }

    @Override
    protected void part1() {
        EncryptionKeyCalculator encryptionKeyCalculator = new EncryptionKeyCalculator();
        long result = encryptionKeyCalculator.calculateEncryptionKey(doorPublicKey, cardPublicKey);

        System.out.println("The encryption key that the handshake is trying to establish = " + result);
    }

    @Override
    protected void part2() {
        // nothing to do
    }

}
