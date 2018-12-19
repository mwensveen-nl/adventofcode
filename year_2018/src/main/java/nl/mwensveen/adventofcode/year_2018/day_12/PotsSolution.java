package nl.mwensveen.adventofcode.year_2018.day_12;

import com.google.common.io.Files;
import com.google.common.io.Resources;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class PotsSolution {
    public static void main(String[] args) throws IOException {
        URL url = Resources.getResource("Day12.txt");
        List<String> input = Files.readLines(new File(url.getFile()), Charset.defaultCharset());

        PotsCalculator potsCalculator =
                new PotsCalculator("##.#...#.#.#....###.#.#....##.#...##.##.###..#.##.###..####.#..##..#.##..#.......####.#.#..#....##.#", input);
        System.out.println("Sum of pots with plants after 20 cycles = " + potsCalculator.calculatePots(20));

        potsCalculator = new PotsCalculator("##.#...#.#.#....###.#.#....##.#...##.##.###..#.##.###..####.#..##..#.##..#.......####.#.#..#....##.#", input);
        System.out.println("Sum of pots with plants after 50000000000 cycles = " + potsCalculator.deductPots(50000000000L));

    }
}
