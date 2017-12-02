package nl.mwensveen.adventofcode.year_2017.day_1;

import org.junit.Assert;
import org.junit.Test;

public class InverseCaptchaPartTest {
    @Test
    public void testPartOneOne() {
        InverseCaptchaPart ic = new InverseCaptchaPart("122334", 1);
        Integer calculate = ic.calculate();
        Assert.assertEquals(Integer.valueOf(5), calculate);
    }

    @Test
    public void testPartOneTwo() {
        InverseCaptchaPart ic = new InverseCaptchaPart("1122", 1);
        Integer calculate = ic.calculate();
        Assert.assertEquals(Integer.valueOf(3), calculate);
    }

    @Test
    public void testPartOneThree() {
        InverseCaptchaPart ic = new InverseCaptchaPart("1111", 1);
        Integer calculate = ic.calculate();
        Assert.assertEquals(Integer.valueOf(4), calculate);
    }

    @Test
    public void testPartOneFour() {
        InverseCaptchaPart ic = new InverseCaptchaPart("1234", 1);
        Integer calculate = ic.calculate();
        Assert.assertEquals(Integer.valueOf(0), calculate);
    }

    @Test
    public void testPartOneFive() {
        InverseCaptchaPart ic = new InverseCaptchaPart("91212129", 1);
        Integer calculate = ic.calculate();
        Assert.assertEquals(Integer.valueOf(9), calculate);
    }

    @Test
    public void testPartTwoOne() {
        String input = "1212";
        InverseCaptchaPart ic = new InverseCaptchaPart(input, input.length() / 2);
        Integer calculate = ic.calculate();
        Assert.assertEquals(Integer.valueOf(6), calculate);
    }

    @Test
    public void testPartTwoTwo() {
        String input = "1221";
        InverseCaptchaPart ic = new InverseCaptchaPart(input, input.length() / 2);
        Integer calculate = ic.calculate();
        Assert.assertEquals(Integer.valueOf(0), calculate);
    }

    @Test
    public void testPartTwoThree() {
        String input = "123425";
        InverseCaptchaPart ic = new InverseCaptchaPart(input, input.length() / 2);
        Integer calculate = ic.calculate();
        Assert.assertEquals(Integer.valueOf(4), calculate);
    }

    @Test
    public void testPartTwoFour() {
        String input = "123123";
        InverseCaptchaPart ic = new InverseCaptchaPart(input, input.length() / 2);
        Integer calculate = ic.calculate();
        Assert.assertEquals(Integer.valueOf(12), calculate);
    }

    @Test
    public void testPartTwoFive() {
        String input = "12131415";
        InverseCaptchaPart ic = new InverseCaptchaPart(input, input.length() / 2);
        Integer calculate = ic.calculate();
        Assert.assertEquals(Integer.valueOf(4), calculate);
    }

}
