package nl.mwensveen.adventofcode.year_2021.day_16;

import java.math.BigInteger;

public class LiteralValuePacket implements Packet {

    private BigInteger version;
    private BigInteger typeId;
    private BigInteger value;
    private int parsed;

    @Override
    public void parsePacket(String input) {
        String v = input.substring(0, 3);
        String ti = input.substring(3, 6);
        version = new BigInteger(v, 2);
        typeId = new BigInteger(ti, 2);

        StringBuilder number = new StringBuilder();
        int start = 6;
        boolean end = false;
        while (!end) {
            String group = input.substring(start, 5 + start);
            number.append(group.substring(1));
            start += 5;
            end = group.startsWith("0");
        }
        value = new BigInteger(number.toString(), 2);

        parsed = start;
    }

    /** {@inheritDoc} */
    @Override
    public int getVersion() {
        return version.intValue();
    }

    /** {@inheritDoc} */
    @Override
    public int getTypeId() {
        return typeId.intValue();
    }

    /** {@inheritDoc} */
    @Override
    public long getValue() {
        return value.longValue();
    }

    /** {@inheritDoc} */
    @Override
    public int getParsed() {
        return parsed;
    }
}
