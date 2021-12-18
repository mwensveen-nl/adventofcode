package nl.mwensveen.adventofcode.year_2021.day_16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HexProcessorTest {

    @Test
    public void testProcessPacketLiteral() {
        Packet result = new HexProcessor().processPacket("D2FE28");
        assertEquals(6, result.getVersion());
        assertEquals(4, result.getTypeId());
        assertEquals(2021, result.getValue());

    }

    @Test
    public void testProcessPacketOperatorZero() {
        Packet result = new HexProcessor().processPacket("38006F45291200");

        OperatorZeroPacket packet = (OperatorZeroPacket) result;
        assertEquals(1, packet.getVersion());
        assertEquals(6, packet.getTypeId());
        assertEquals(2, packet.getSubPackets().size());
    }

    @Test
    public void testProcessPacketOperatorOne() {
        Packet result = new HexProcessor().processPacket("EE00D40C823060");

        OperatorOnePacket packet = (OperatorOnePacket) result;
        assertEquals(7, packet.getVersion());
        assertEquals(3, packet.getTypeId());
        assertEquals(3, packet.getSubPackets().size());
    }

    @Test
    public void testProcessPacketOperator() {
        String input = "8A004A801A8002F478";
        Packet result = new HexProcessor().processPacket(input);

        VersionCounter versionCounter = new VersionCounter();
        int countVersions = versionCounter.countVersions(result);
        assertEquals(16, countVersions);
    }

    @Test
    public void testProcessPacketOperator2() {
        String input = "620080001611562C8802118E34";
        Packet result = new HexProcessor().processPacket(input);

        VersionCounter versionCounter = new VersionCounter();
        int countVersions = versionCounter.countVersions(result);
        assertEquals(12, countVersions);
    }

    @Test
    public void testProcessPacketOperator3() {
        String input = "A0016C880162017C3686B18A3D4780";
        Packet result = new HexProcessor().processPacket(input);

        VersionCounter versionCounter = new VersionCounter();
        int countVersions = versionCounter.countVersions(result);
        assertEquals(31, countVersions);
    }

    @Test
    public void testCalculors() {
        String input = "C200B40A82";
        Packet result = new HexProcessor().processPacket(input);
        assertEquals(3, result.getValue());
    }

    @Test
    public void testCalculors2() {
        String input = "04005AC33890";
        Packet result = new HexProcessor().processPacket(input);
        assertEquals(54, result.getValue());
    }

    @Test
    public void testCalculors3() {
        String input = "880086C3E88112";
        Packet result = new HexProcessor().processPacket(input);
        assertEquals(7, result.getValue());
    }

    @Test
    public void testCalculors4() {
        String input = "CE00C43D881120";
        Packet result = new HexProcessor().processPacket(input);
        assertEquals(9, result.getValue());
    }

    @Test
    public void testCalculors5() {
        String input = "D8005AC2A8F0";
        Packet result = new HexProcessor().processPacket(input);
        assertEquals(1, result.getValue());
    }

    @Test
    public void testCalculors6() {
        String input = "F600BC2D8F";
        Packet result = new HexProcessor().processPacket(input);
        assertEquals(0, result.getValue());
    }

    @Test
    public void testCalculors7() {
        String input = "9C0141080250320F1802104A08";
        Packet result = new HexProcessor().processPacket(input);
        assertEquals(1, result.getValue());
    }

}
