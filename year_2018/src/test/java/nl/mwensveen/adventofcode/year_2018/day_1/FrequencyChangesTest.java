package nl.mwensveen.adventofcode.year_2018.day_1;

import java.math.BigInteger;
import org.junit.Assert;
import org.junit.Test;

public class FrequencyChangesTest {

    @Test
    public void testCalculateResultingFrequency() throws Exception {
        FrequencyChanges frequencyChanges = new FrequencyChanges();
        BigInteger resultingFrequency = frequencyChanges.calculateResultingFrequency("+1, -2, +3, +1");
        Assert.assertEquals(BigInteger.valueOf(3), resultingFrequency);
    }

    @Test
    public void testCalculateResultingFrequencyOtherExample1() throws Exception {
        FrequencyChanges frequencyChanges = new FrequencyChanges();
        BigInteger resultingFrequency = frequencyChanges.calculateResultingFrequency("+1, +1, +1");
        Assert.assertEquals(BigInteger.valueOf(3), resultingFrequency);
    }

    @Test
    public void testCalculateResultingFrequencyOtherExample2() throws Exception {
        FrequencyChanges frequencyChanges = new FrequencyChanges();
        BigInteger resultingFrequency = frequencyChanges.calculateResultingFrequency("+1, +1, -2");
        Assert.assertEquals(BigInteger.valueOf(0), resultingFrequency);
    }

    @Test
    public void testCalculateResultingFrequencyOtherExample3() throws Exception {
        FrequencyChanges frequencyChanges = new FrequencyChanges();
        BigInteger resultingFrequency = frequencyChanges.calculateResultingFrequency("-1, -2, -3");
        Assert.assertEquals(BigInteger.valueOf(-6), resultingFrequency);
    }

    @Test
    public void testFindFrequencyReachedTwice() throws Exception {
        FrequencyChanges frequencyChanges = new FrequencyChanges();
        BigInteger resultingFrequency = frequencyChanges.findFrequencyReachedTwice("+1, -2, +3, +1");
        Assert.assertEquals(BigInteger.valueOf(2), resultingFrequency);
    }

    @Test
    public void testFindFrequencyReachedTwiceOtherExample1() throws Exception {
        FrequencyChanges frequencyChanges = new FrequencyChanges();
        BigInteger resultingFrequency = frequencyChanges.findFrequencyReachedTwice("+1, -1");
        Assert.assertEquals(BigInteger.valueOf(0), resultingFrequency);
    }

    @Test
    public void testFindFrequencyReachedTwiceOtherExample2() throws Exception {
        FrequencyChanges frequencyChanges = new FrequencyChanges();
        BigInteger resultingFrequency = frequencyChanges.findFrequencyReachedTwice("+3, +3, +4, -2, -4");
        Assert.assertEquals(BigInteger.valueOf(10), resultingFrequency);
    }

    @Test
    public void testFindFrequencyReachedTwiceOtherExample3() throws Exception {
        FrequencyChanges frequencyChanges = new FrequencyChanges();
        BigInteger resultingFrequency = frequencyChanges.findFrequencyReachedTwice("-6, +3, +8, +5, -6");
        Assert.assertEquals(BigInteger.valueOf(5), resultingFrequency);
    }

    @Test
    public void testFindFrequencyReachedTwiceOtherExample4() throws Exception {
        FrequencyChanges frequencyChanges = new FrequencyChanges();
        BigInteger resultingFrequency = frequencyChanges.findFrequencyReachedTwice("+7, +7, -2, -7, -4");
        Assert.assertEquals(BigInteger.valueOf(14), resultingFrequency);
    }

}
