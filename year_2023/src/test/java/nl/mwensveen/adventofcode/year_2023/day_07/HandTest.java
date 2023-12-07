package nl.mwensveen.adventofcode.year_2023.day_07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HandTest {

    @Test
    public void testParseOnePair() {
        Hand hand = Hand.parse("32T3K");
        assertEquals(Type.OnePair, hand.type());
        assertEquals(5, hand.cards().size());
        assertEquals("3", hand.cards().get(0));
        assertEquals("2", hand.cards().get(1));
    }

    @Test
    public void testParseTwoPair() {
        Hand hand = Hand.parse("3223K");
        assertEquals(Type.TwoPair, hand.type());
        assertEquals(5, hand.cards().size());
        assertEquals("3", hand.cards().get(0));
        assertEquals("2", hand.cards().get(1));
    }

    @Test
    public void testParseThreeOfAKind() {
        Hand hand = Hand.parse("3233K");
        assertEquals(Type.ThreeOfAKind, hand.type());
        assertEquals(5, hand.cards().size());
        assertEquals("3", hand.cards().get(0));
        assertEquals("2", hand.cards().get(1));
    }

    @Test
    public void testParseFullHouse() {
        Hand hand = Hand.parse("32332");
        assertEquals(Type.FullHouse, hand.type());
        assertEquals(5, hand.cards().size());
        assertEquals("3", hand.cards().get(0));
        assertEquals("2", hand.cards().get(1));
    }

    @Test
    public void testParseHighCard() {
        Hand hand = Hand.parse("34567");
        assertEquals(Type.HighCard, hand.type());
        assertEquals(5, hand.cards().size());
        assertEquals("3", hand.cards().get(0));
        assertEquals("4", hand.cards().get(1));
    }

    @Test
    public void testParseFiveOfAKind() {
        Hand hand = Hand.parse("33333");
        assertEquals(Type.FiveOfAKind, hand.type());
        assertEquals(5, hand.cards().size());
        assertEquals("3", hand.cards().get(0));
        assertEquals("3", hand.cards().get(1));
    }

    @Test
    public void testCompare() {
        assertTrue(Hand.compare(Hand.parse("33333"), Hand.parse("44444")) < 0);
    }

}
