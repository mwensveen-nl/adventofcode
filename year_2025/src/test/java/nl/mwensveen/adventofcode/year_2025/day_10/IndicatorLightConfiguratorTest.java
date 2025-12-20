package nl.mwensveen.adventofcode.year_2025.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class IndicatorLightConfiguratorTest {
    private String input = """
            [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
            [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}
            [.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}
                        """;

    @Test
    public void configure() {
        MachineParser machineParser = new MachineParser();
        List<Machine> machines = input.lines().map(s -> machineParser.parse(s)).toList();
        int resut = new IndicatorLightConfigurator().configure(machines);
        assertEquals(7, resut);
    }

}
