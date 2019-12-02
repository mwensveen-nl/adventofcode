package nl.mwensveen.adventofcode.year_2019.day_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class IntcodeProgramTest {

	@Test
	public void testProcess() throws Exception {
		IntcodeProgram intcodeProgram = new IntcodeProgram();
		List<Integer> list = Arrays.asList(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50);
		int result = intcodeProgram.process(list);
		assertEquals(3500, result);
	}

	@Test
	public void testProcess2() throws Exception {
		IntcodeProgram intcodeProgram = new IntcodeProgram();
		List<Integer> list = Arrays.asList(1, 0, 0, 0, 99);
		int result = intcodeProgram.process(list);
		assertEquals(2, result);
	}

	@Test
	public void testProcess3() throws Exception {
		IntcodeProgram intcodeProgram = new IntcodeProgram();
		List<Integer> list = Arrays.asList(2, 3, 0, 3, 99);
		int result = intcodeProgram.process(list);
		assertEquals(2, result);
	}

	@Test
	public void testProcess4() throws Exception {
		IntcodeProgram intcodeProgram = new IntcodeProgram();
		List<Integer> list = Arrays.asList(2, 4, 4, 5, 99, 0);
		int result = intcodeProgram.process(list);
		assertEquals(2, result);
	}

	@Test
	public void testProcess5() throws Exception {
		IntcodeProgram intcodeProgram = new IntcodeProgram();
		List<Integer> list = Arrays.asList(1, 1, 1, 4, 99, 5, 6, 0, 99);
		int result = intcodeProgram.process(list);
		assertEquals(30, result);
	}

}
