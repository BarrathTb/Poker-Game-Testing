package us.barrathtb.poker;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    /**
     * Creates an instance of Game with a given hand. Hand must have exactly five cards.
     *
     * @param hand An ArrayList of Card objects representing the player's hand.
     */
    public Game(ArrayList<Card> hand) {
        if (hand.size() != 5) {
            throw new IllegalArgumentException("Hand must have exactly five cards");
        }
        this.hand = new ArrayList<>(hand);
    }

    //create array list of cards called hand
    private final List<Card> hand;

    /**
     * Gets the size of the current hand.
     *
     * @return The number of cards in the current hand.
     */
    public int getHandSize() {
        return hand.size();
    }

    /**
     * Checks for a full house in a given hand.
     *
     * @param hand A List of Cards.
     * @return True if the hand has a full house, and False otherwise.
     */
    public static boolean fullHouse(List<Card> hand){
        return hasFullHouse(hand);
    }

    /**
     * Checks for a flush in a given hand.
     *
     * @param hand A List of Cards.
     * @return True if the hand has a flush, and False otherwise.
     */
    public static boolean flush(List<Card> hand){
        return checkForFlush(hand);
    }

    /**
     * Checks for a three of a kind in a given hand.
     *
     * @param hand A List of Cards.
     * @return True if the hand has a three of a kind, and False otherwise.
     */
    public static boolean threeOfKind(List<Card> hand){
        return checkForMatchingKind(hand);
    }

    /**
     * Checks for a four of a kind in a given hand.
     *
     * @param hand A List of Cards.
     * @return True if the hand has a four of a kind, and False otherwise.
     */
    public static boolean fourOfKind(List<Card> hand){
        return checkForMatchingKind(hand);
    }

    /**
     * Private helper function to check for 3 or 4 matching pairs of Cards
     *
     * @param hand A List of Cards.
     * @return True if the hand has 3 or 4 matching pairs of Cards, and False otherwise.
     */
    private static boolean checkForMatchingKind(List<Card> hand) {
        hand.sort(Comparator.comparing(Card::getSuit));
        hand.sort(Comparator.comparing(Card::getFace));
        int numberOfMatches = 0;
        for(int i = numberOfMatches; i < hand.size() - 1; i++){
            if(hand.get(i).getFace().equals(hand.get(i+2).getFace()) || hand.get(i).getFace().equals(hand.get(i+3).getFace())){
                return true;
            }
            if(hand.get(i).getSuit().equals(hand.get(i+2).getSuit()) || hand.get(i).getSuit().equals(hand.get(i+3).getSuit())){
                return true;
            }
        }
        return false;
    }

    /**
     * Private helper function to check for a full house in a given hand.
     *
     * @param hand A List of Cards.
     * @return True if the hand has a full house, and False otherwise.
     */
    private static boolean hasFullHouse(List<Card> hand){
        HashMap<Face, Integer> faceMatches = new HashMap<>();
        for(Card card : hand){
            faceMatches.put(card.getFace(), faceMatches.getOrDefault(card.getFace(), 0) + 1);
        }
        boolean hasThreeOfKind = false;
        boolean hasPair = false;
        for(int count : faceMatches.values()){
            if(count == 3){
                if(hasThreeOfKind){
                    return false;
                }
                hasThreeOfKind = true;
            }else if(count == 2){
                if(hasPair){
                    return false;
                }
                hasPair = true;
            }else{
                return false;
            }
        }
        //if loop gets to this point, we have a full house
        return true;
    }

    /**
     * Private helper function to check for a flush in a given hand.
     *
     * @param hand A List of Cards.
     * @return True if the hand has a flush, and False otherwise.
     */
    private static boolean checkForFlush(List<Card> hand){
        Suit suit = hand.get(0).getSuit();
        for(int i = 1; i < hand.size(); i++){
            if(!hand.get(i).getSuit().equals(suit)){
                return false;
            }
        }
        return true;
    }
}