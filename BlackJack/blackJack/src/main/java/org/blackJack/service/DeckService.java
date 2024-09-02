package org.blackJack.service;

import java.util.Collections;
import java.util.Stack;
import org.blackJack.dto.Card;
import org.blackJack.dto.Rank;
import org.blackJack.dto.Suit;
import org.blackJack.exceptions.DeckException;

public class DeckService {

    private Stack<Card> deck = new Stack<>();

    public void createDeck(int decNumber){

        deck.clear();

        if (decNumber < 1 || decNumber > 8) {
            throw new DeckException("Number of deck must be between 1 and 8");
        }

        for (int i = 0; i < decNumber; i++) {
            for (Rank rank : Rank.values()) {
                for (Suit suit : Suit.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }
        Collections.shuffle(deck);
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public int getCardCount() {
        return deck.size();
    }

    public  Card getCard(){
        return deck.pop();
    }

}
