package nl.mwensveen.adventofcode.year_2017.day_5;

import org.junit.Test;

import junit.framework.Assert;

public class TwistyTrampolinesStrangerTest {
	@Test
	public void testJumps() {
		TwistyTrampolinesStranger trampolines = new TwistyTrampolinesStranger("0\n" + "3\n" + "0\n" + "1\n" + "-3");
		Assert.assertEquals(10, trampolines.calculate());
	}
}