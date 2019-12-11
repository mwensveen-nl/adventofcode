package nl.mwensveen.adventofcode.year_2019.day_11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RobotTest {
    @Mock
    private IntcodeProgram program;
    @InjectMocks
    private Robot robot;

    @Captor
    private ArgumentCaptor<Integer> input;

    @Test
    public void testEmergencyHullPainting() throws Exception {
        assertNotNull(robot);
        List<BigInteger> output1 = Arrays.asList(BigInteger.ONE, BigInteger.ZERO);
        List<BigInteger> outputLast = new ArrayList<>();
        Mockito.when(program.process(input.capture())).thenReturn(output1, outputLast);
        int result = robot.emergencyHullPainting(Color.BLACK);
        assertEquals(1, result);
    }

    @Test
    public void testEmergencyHullPainting2() throws Exception {
        assertNotNull(robot);
        List<BigInteger> output1 = Arrays.asList(BigInteger.ONE, BigInteger.ZERO);
        List<BigInteger> output2 = Arrays.asList(BigInteger.ZERO, BigInteger.ZERO);
        List<BigInteger> output3 = Arrays.asList(BigInteger.ONE, BigInteger.ZERO);
        List<BigInteger> output4 = Arrays.asList(BigInteger.ONE, BigInteger.ZERO);
        List<BigInteger> output5 = Arrays.asList(BigInteger.ZERO, BigInteger.ONE);
        List<BigInteger> output6 = Arrays.asList(BigInteger.ONE, BigInteger.ZERO);
        List<BigInteger> output7 = Arrays.asList(BigInteger.ONE, BigInteger.ZERO);
        List<BigInteger> outputLast = new ArrayList<>();
        Mockito.when(program.process(input.capture())).thenReturn(output1, output2, output3, output4, output5, output6, output7, outputLast);
        int result = robot.emergencyHullPainting(Color.BLACK);
        assertEquals(6, result);
        List<Integer> values = input.getAllValues();
        assertEquals(0, values.get(0));
        assertEquals(0, values.get(1));
        assertEquals(0, values.get(2));
        assertEquals(0, values.get(3));
        assertEquals(1, values.get(4));
    }

}
