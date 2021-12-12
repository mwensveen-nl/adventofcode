package nl.mwensveen.adventofcode.year_2021.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class EnergyProcessorTest {

    @Test
    public void testProcesEnergy() {
        List<String> input = Arrays.asList("5483143223",
                "2745854711",
                "5264556173",
                "6141336146",
                "6357385478",
                "4167524645",
                "2176841721",
                "6882881134",
                "4846848554",
                "5283751526");
        OctopusGridParser parser = new OctopusGridParser();
        Table<Integer, Integer, Octopus> grid = parser.parseGrid(input);

        EnergyProcessor energyProcessor = new EnergyProcessor();
        energyProcessor.procesEnergy(grid);

        StringBuilder sb = new StringBuilder();
        grid.row(0).values().stream().forEach(o -> sb.append(o.getEnergy()));
        assertEquals("6594254334", sb.toString());
        sb.delete(0, 10);
        grid.row(9).values().stream().forEach(o -> sb.append(o.getEnergy()));
        assertEquals("6394862637", sb.toString());

        energyProcessor.procesEnergy(grid);

        sb.delete(0, 10);
        grid.row(0).values().stream().forEach(o -> sb.append(o.getEnergy()));
        assertEquals("8807476555", sb.toString());
        sb.delete(0, 10);
        grid.row(9).values().stream().forEach(o -> sb.append(o.getEnergy()));
        assertEquals("8700006848", sb.toString());

        energyProcessor.procesEnergy(grid);

        sb.delete(0, 10);
        grid.row(0).values().stream().forEach(o -> sb.append(o.getEnergy()));
        assertEquals("0050900866", sb.toString());
        sb.delete(0, 10);
        grid.row(1).values().stream().forEach(o -> sb.append(o.getEnergy()));
        assertEquals("8500800575", sb.toString());

    }

}
