package nl.mwensveen.adventofcode.year_2020.day_02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PasswordListCheckerTest {

    @Test
    public void testCheckList() throws Exception {
        List<String> input = Arrays.asList("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
        PasswordListChecker checker = new PasswordListChecker(input);
        assertEquals(2, checker.checkListSledRentalPlaceStyle());
    }

    @Test
    public void testCheckList2() throws Exception {
        List<String> input = Arrays.asList("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
        PasswordListChecker checker = new PasswordListChecker(input);
        assertEquals(1, checker.checkListTobogganRentalShopStyle());
    }

}
