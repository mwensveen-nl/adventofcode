package nl.mwensveen.adventofcode.year_2024.day_03;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplyProgramTest {

    @Test
    public void testMultiply() {
        MultiplyParser multiplyParser = new MultiplyParser();
        List<Mutiply> list = multiplyParser.parseProgram("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");

        MultiplyProgram program = new MultiplyProgram();
        long result = program.multiply(list);
        assertEquals(161, result);
    }

}
