package us.barrathtb.poker;

import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.assertTrue;

public class GameTest {
    @Test
    public void testFullHouse() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Face.ACE, Suit.HEARTS));
        hand.add(new Card(Face.ACE, Suit.SPADES));
        hand.add(new Card(Face.ACE, Suit.DIAMONDS));
        hand.add(new Card(Face.KING, Suit.HEARTS));
        hand.add(new Card(Face.KING, Suit.CLUBS));


        assertTrue(Game.fullHouse(hand));
    }

    @Test
    public void testFlush() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Face.TWO, Suit.DIAMONDS));
        hand.add(new Card(Face.FOUR, Suit.DIAMONDS));
        hand.add(new Card(Face.SIX, Suit.DIAMONDS));
        hand.add(new Card(Face.EIGHT, Suit.DIAMONDS));
        hand.add(new Card(Face.TEN, Suit.HEARTS));


        assertTrue(Game.flush(hand));
    }

    @Test
    public void testThreeOfAKind() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Face.QUEEN, Suit.CLUBS));
        hand.add(new Card(Face.QUEEN, Suit.DIAMONDS));
        hand.add(new Card(Face.QUEEN, Suit.HEARTS));
        hand.add(new Card(Face.SEVEN, Suit.SPADES));
        hand.add(new Card(Face.NINE, Suit.HEARTS));


        assertTrue(Game.threeOfKind(hand));
    }

    @Test
    public void testFourOfAKind() {
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(Face.JACK, Suit.DIAMONDS));
        hand.add(new Card(Face.JACK, Suit.CLUBS));
        hand.add(new Card(Face.JACK, Suit.HEARTS));
        hand.add(new Card(Face.JACK, Suit.SPADES));
        hand.add(new Card(Face.TWO, Suit.DIAMONDS));


        assertTrue(Game.fourOfKind(hand));
    }
}
