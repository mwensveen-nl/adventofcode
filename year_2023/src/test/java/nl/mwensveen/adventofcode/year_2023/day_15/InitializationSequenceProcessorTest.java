package nl.mwensveen.adventofcode.year_2023.day_15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InitializationSequenceProcessorTest {

    @Test
    public void testProcess() {
        InitializationSequenceProcessor processor = new InitializationSequenceProcessor();
        assertEquals(1320, processor.process("rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7"));
    }

}
