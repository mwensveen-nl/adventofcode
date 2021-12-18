package nl.mwensveen.adventofcode.year_2021.day_16;

public class HexProcessor {

    Packet processPacket(String hex) {
        HexInputParser hexInputParser = new HexInputParser();
        String binary = hexInputParser.parseInput(hex);

        Packet packet = Packet.getPacket(binary);
        packet.parsePacket(binary);
        return packet;
    }
}
