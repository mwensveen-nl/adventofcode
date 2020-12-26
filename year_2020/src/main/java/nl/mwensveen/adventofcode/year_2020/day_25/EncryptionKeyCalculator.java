package nl.mwensveen.adventofcode.year_2020.day_25;

public class EncryptionKeyCalculator {

    public long calculateEncryptionKey(int doorPubKey, int cardPubKey) {
        long subject = 7;
        long value = 1L;
        long value2 = 1L;
        long subject2 = cardPubKey;
        while (value != doorPubKey) {
            value = value * subject;
            value = value % 20201227;
            value2 = value2 * subject2;
            value2 = value2 % 20201227;
        }
        return value2;
    }
}
