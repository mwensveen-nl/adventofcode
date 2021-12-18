package nl.mwensveen.adventofcode.year_2021.day_18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SnailfishCalculatorTest {

    @Test
    public void testCalculate() {
        List<String> input = Arrays.asList("[1,2]", "[[3,4],5]");
        SnailfishCalculator calculator = new SnailfishCalculator();
        String result = calculator.calculate(input);
        assertEquals("143", result);
    }

    @Test
    public void testCalculate2() {
        List<String> input = Arrays.asList("[[[0,[5,8]],[[1,7],[9,6]]],[[4,[1,2]],[[1,4],2]]]",
                "[[[5,[2,8]],4],[5,[[9,9],0]]]",
                "[6,[[[6,2],[5,6]],[[7,6],[4,7]]]]",
                "[[[6,[0,7]],[0,9]],[4,[9,[9,0]]]]",
                "[[[7,[6,4]],[3,[1,3]]],[[[5,5],1],9]]",
                "[[6,[[7,3],[3,2]]],[[[3,8],[5,7]],4]]",
                "[[[[5,4],[7,7]],8],[[8,3],8]]",
                "[[9,3],[[9,9],[6,[4,9]]]]",
                "[[2,[[7,7],7]],[[5,8],[[9,3],[0,2]]]]",
                "[[[[5,2],5],[8,[3,7]]],[[5,[7,5]],[4,4]]]");
        SnailfishCalculator calculator = new SnailfishCalculator();
        String result = calculator.calculate(input);
        assertEquals("4140", result);
    }

}
