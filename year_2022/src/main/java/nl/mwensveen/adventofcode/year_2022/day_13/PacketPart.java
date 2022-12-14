package nl.mwensveen.adventofcode.year_2022.day_13;

import com.google.common.base.MoreObjects;

public class PacketPart implements Comparable<PacketPart> {

    private final String part;
    private String numbers;

    public PacketPart(String part) {
        this.part = part;
        numbers = part.replace("10", "A");
        numbers = numbers.replace("[]", "0");
        numbers = numbers.replace(",", "");
        numbers = numbers.replace("[", "");
        numbers = numbers.replace("]", "");
    }

    @Override
    public int compareTo(PacketPart o) {
        int c = numbers.compareTo(o.numbers);
        if (c == 0) {
            c = getPart().length() - o.getPart().length();
        }
        return c;
    }

    public String getPart() {
        return part;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("part", part).add("numbers", numbers).toString();
    }

}
