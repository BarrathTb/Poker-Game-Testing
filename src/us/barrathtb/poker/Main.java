package us.barrathtb.poker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create a sample hand
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Face.ACE, Suit.SPADES));
        hand.add(new Card(Face.KING, Suit.SPADES));
        hand.add(new Card(Face.QUEEN, Suit.SPADES));
        hand.add(new Card(Face.JACK, Suit.SPADES));
        hand.add(new Card(Face.TEN, Suit.SPADES));

        // create a game instance
        Game game = new Game(new ArrayList<>(hand));

        System.out.println("Hand Size: " + game.getHandSize());
        System.out.println("Full House: " + game.fullHouse(hand));
        System.out.println("Flush: " + game.flush(hand));
        System.out.println("Three Of A Kind: " + game.threeOfKind(hand));
        System.out.println("Four Of A Kind: " + game.fourOfKind(hand));
    }
}