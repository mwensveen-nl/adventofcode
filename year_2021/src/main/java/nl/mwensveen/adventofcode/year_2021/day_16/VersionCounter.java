package nl.mwensveen.adventofcode.year_2021.day_16;

import java.util.List;

public class VersionCounter {

    int countVersions(Packet packet) {
        return addVersion(packet);
    }

    private int addVersion(Packet packet) {
        int version = packet.getVersion();
        if (packet instanceof OperatorPacket) {
            OperatorPacket op = (OperatorPacket) packet;
            List<Packet> subPackets = op.getSubPackets();
            for (Packet subpacket : subPackets) {
                version += addVersion(subpacket);
            }
        }
        return version;
    }
}
