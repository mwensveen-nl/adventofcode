package nl.mwensveen.adventofcode.year_2017.day_13;

public class PacketScannersSolution {

    public static void main(String[] args) {
        PacketScanners packetScanners = new PacketScanners("0: 3\n" +
                "1: 2\n" +
                "2: 4\n" +
                "4: 4\n" +
                "6: 5\n" +
                "8: 6\n" +
                "10: 8\n" +
                "12: 8\n" +
                "14: 6\n" +
                "16: 6\n" +
                "18: 8\n" +
                "20: 8\n" +
                "22: 6\n" +
                "24: 12\n" +
                "26: 9\n" +
                "28: 12\n" +
                "30: 8\n" +
                "32: 14\n" +
                "34: 12\n" +
                "36: 8\n" +
                "38: 14\n" +
                "40: 12\n" +
                "42: 12\n" +
                "44: 12\n" +
                "46: 14\n" +
                "48: 12\n" +
                "50: 14\n" +
                "52: 12\n" +
                "54: 10\n" +
                "56: 14\n" +
                "58: 12\n" +
                "60: 14\n" +
                "62: 14\n" +
                "66: 10\n" +
                "68: 14\n" +
                "74: 14\n" +
                "76: 12\n" +
                "78: 14\n" +
                "80: 20\n" +
                "86: 18\n" +
                "92: 14\n" +
                "94: 20\n" +
                "96: 18\n" +
                "98: 17");
        System.out.println("Part 1: " + packetScanners.calculate());
        System.out.println("Part 2: " + packetScanners.calculateDelay());
    }

}
