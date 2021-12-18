package nl.mwensveen.adventofcode.year_2021.day_16;

import nl.mwensveen.adventofcode.year_2021.AbstractTimedSolution;
import nl.mwensveen.adventofcode.year_2021.FileReadHelper;

public class PacketDecoderSolution extends AbstractTimedSolution {

    private String input;

    @Override
    protected void init() {
        input = FileReadHelper.readLinesAsStrings("day_16.txt").get(0);
    }

    @Override
    protected void part1() {
        HexProcessor hexProcessor = new HexProcessor();
        Packet packet = hexProcessor.processPacket(input);
        VersionCounter versionCounter = new VersionCounter();
        int result = versionCounter.countVersions(packet);
        System.out.println("The result of adding up the version numbers in all packets: " + result);
    }

    @Override
    protected void part2() {
        HexProcessor hexProcessor = new HexProcessor();
        Packet packet = hexProcessor.processPacket(input);
        long result = packet.getValue();
        System.out.println("The reust of evaluating the expression represented by your hexadecimal-encoded BITS transmission: " + result);
    }

    public static void main(String[] args) {
        new PacketDecoderSolution().run();
    }

}
