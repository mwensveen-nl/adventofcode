package nl.mwensveen.adventofcode.year_2024.day_09;

public class FileSpec {
    private int count;
    private int number;

    public FileSpec(int count, int number) {
        this.count = count;
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "[" + count + ", " + (number == Integer.MIN_VALUE ? "." : number) + "]";
    }

}
