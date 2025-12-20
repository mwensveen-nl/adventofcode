package nl.mwensveen.adventofcode.year_2025.day_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ButtonTest {

    @Test
    public void Button() {
        var b = new Button("3");
        assertEquals(8, b.bits());

        b = new Button("1,3");

        b = new Button("2");

        b = new Button("2,3");

        b = new Button("0,2");
        assertEquals(5, b.bits());
    }

}
