package nl.mwensveen.adventofcode.year_2025.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ButtonParserTest {

    @Test
    public void parse() {
        String input = "(0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4)";
        ButtonParser parser = new ButtonParser();
        List<Button> buttons = parser.parse(input);
        assertEquals(5, buttons.size());
        assertEquals(29, buttons.get(0).bits());
    }

}
