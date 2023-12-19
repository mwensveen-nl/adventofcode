package nl.mwensveen.adventofcode.year_2023.day_15;

public class HashAlgorithm {

    public int calculateHash(String in) {
        int result = in.chars().reduce(0, (hash, i) -> calc(hash, i));
        return result;
    }

    private Integer calc(int hash, int i) {
        hash += i;
        hash *= 17;
        hash = hash % 256;
        return hash;
    }

}
