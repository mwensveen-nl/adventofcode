package nl.mwensveen.adventofcode.year_2017.day_5;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import junit.framework.Assert;

public class TwistyTrampolinesTest {

	@Test
	public void testJumps() {
		TwistyTrampolines trampolines = new TwistyTrampolines("0\n" + 
				"3\n" + 
				"0\n" + 
				"1\n" + 
				"-3");
		Assert.assertEquals(5	, trampolines.calculate());
	}
}
