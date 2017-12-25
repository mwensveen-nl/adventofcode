package nl.mwensveen.adventofcode.year_2017.day_24;

public class ElectromagneticMoatSolution {
    private static final String INPUT = "31/13\n" +
            "34/4\n" +
            "49/49\n" +
            "23/37\n" +
            "47/45\n" +
            "32/4\n" +
            "12/35\n" +
            "37/30\n" +
            "41/48\n" +
            "0/47\n" +
            "32/30\n" +
            "12/5\n" +
            "37/31\n" +
            "7/41\n" +
            "10/28\n" +
            "35/4\n" +
            "28/35\n" +
            "20/29\n" +
            "32/20\n" +
            "31/43\n" +
            "48/14\n" +
            "10/11\n" +
            "27/6\n" +
            "9/24\n" +
            "8/28\n" +
            "45/48\n" +
            "8/1\n" +
            "16/19\n" +
            "45/45\n" +
            "0/4\n" +
            "29/33\n" +
            "2/5\n" +
            "33/9\n" +
            "11/7\n" +
            "32/10\n" +
            "44/1\n" +
            "40/32\n" +
            "2/45\n" +
            "16/16\n" +
            "1/18\n" +
            "38/36\n" +
            "34/24\n" +
            "39/44\n" +
            "32/37\n" +
            "26/46\n" +
            "25/33\n" +
            "9/10\n" +
            "0/29\n" +
            "38/8\n" +
            "33/33\n" +
            "49/19\n" +
            "18/20\n" +
            "49/39\n" +
            "18/39\n" +
            "26/13\n" +
            "19/32";

    public static void main(String[] args) {
        ElectromagneticMoat electromagneticMoat = new ElectromagneticMoat(INPUT);
        System.out.println("Part 1: " + electromagneticMoat.calculate());
    }
}
