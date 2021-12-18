package nl.mwensveen.adventofcode.year_2021.day_16;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class OperatorOnePacket implements OperatorPacket {
    private int version;
    private int typeId;
    private int lengthTypeID;
    private int parsed;
    private int numberOfSubPackets;
    private List<Packet> subPackets = new ArrayList<>();

    @Override
    public void parsePacket(String input) {
        String v = input.substring(0, 3);
        String ti = input.substring(3, 6);
        String lti = input.substring(6, 7);

        version = new BigInteger(v, 2).intValue();
        typeId = new BigInteger(ti, 2).intValue();
        lengthTypeID = new BigInteger(lti, 2).intValue();

        String nsp = input.substring(7, 18);
        numberOfSubPackets = new BigInteger(nsp, 2).intValue();
        int start = 18;
        for (int i = 0; i < numberOfSubPackets; i++) {
            String sp = input.substring(start);
            Packet packet = Packet.getPacket(sp);
            packet.parsePacket(sp);
            subPackets.add(packet);
            start += packet.getParsed();
        }

        parsed = start;
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public int getTypeId() {
        return typeId;
    }

    public int getLengthTypeID() {
        return lengthTypeID;
    }

    @Override
    public int getParsed() {
        return parsed;
    }

    public int getNumberOfSubPackets() {
        return numberOfSubPackets;
    }

    @Override
    public List<Packet> getSubPackets() {
        return subPackets;
    }

}
