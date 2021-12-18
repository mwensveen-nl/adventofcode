package nl.mwensveen.adventofcode.year_2021.day_16;

import java.math.BigInteger;

public interface Packet {
    public static final BigInteger FOUR = new BigInteger("4");

    int getVersion();

    int getTypeId();

    long getValue();

    int getParsed();

    void parsePacket(String input);

    static Packet getPacket(String binary) {
        BigInteger typeId = new BigInteger(binary.substring(3, 6), 2);
        if (typeId.equals(FOUR)) {
            return new LiteralValuePacket();
        } else {
            String lti = binary.substring(6, 7);
            if (lti.equals("0")) {
                return new OperatorZeroPacket();
            } else {
                return new OperatorOnePacket();
            }
        }
    }
}