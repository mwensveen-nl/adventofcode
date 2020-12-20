package nl.mwensveen.adventofcode.year_2020.day_20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.Table;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class SeamonsterTest {

    @Test
    public void testSeamonster() throws Exception {
        Seamonster seamonster = new Seamonster();
        Table<Integer, Integer, String> table = seamonster.getTable();
        assertEquals(3, table.rowKeySet().size());
        Map<Integer, String> row = table.row(0);
        assertEquals(1, row.keySet().size());
        assertEquals("#", row.get(18));

        row = table.row(1);
        assertEquals(8, row.keySet().size());
        assertEquals("#", row.get(19));

        assertEquals(3, seamonster.getRows());
        assertEquals(20, seamonster.getColumns());
    }

}
