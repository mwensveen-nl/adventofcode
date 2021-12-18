package nl.mwensveen.adventofcode.year_2021.day_16;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class OperatorZeroPacket implements OperatorPacket {
    private int version;
    private int typeId;
    private int lengthTypeID;
    private int parsed;
    private int totalLengthInBits;
    private List<Packet> subPackets = new ArrayList<>();

    @Override
    public void parsePacket(String input) {
        String v = input.substring(0, 3);
        String ti = input.substring(3, 6);
        String lti = input.substring(6, 7);

        version = new BigInteger(v, 2).intValue();
        typeId = new BigInteger(ti, 2).intValue();
        lengthTypeID = new BigInteger(lti, 2).intValue();

        String tlib = input.substring(7, 22);
        totalLengthInBits = new BigInteger(tlib, 2).intValue();

        String subPacketsString = input.substring(22, 22 + totalLengthInBits);
        while (subPacketsString.length() > 8) {
            Packet subPacket = Packet.getPacket(subPacketsString);
            subPacket.parsePacket(subPacketsString);
            subPackets.add(subPacket);
            subPacketsString = subPacketsString.substring(subPacket.getParsed());
        }
        parsed = 22 + totalLengthInBits;

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

    /** {@inheritDoc} */
    @Override
    public List<Packet> getSubPackets() {
        return subPackets;
    }

}
