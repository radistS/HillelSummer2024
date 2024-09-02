package org.blackJack.service;

import java.util.List;
import java.util.Random;
import org.blackJack.dto.Card;

public class GameService {

    public int getComputerHand(){
        // random value from 17 to 25
        return new Random().nextInt(25-17) + 17;
    }

    public void printHand(List<Card> hand) {
        hand.forEach((e -> System.out.print(e + " ")));
    }

    public int calculateHandScore(List<Card> hand) {
        int score = 0;
        for (Card card : hand) {
            score += card.getCost();
        }

        // Check if the hand is a blackjack (only if it contains exactly 2 cards)
        if (hand.size() == 2 && isBlackJack(score)) {
            return 21;
        }

        return score;
    }

    private boolean isBlackJack(int score) {
        return score == 22;
    }



}
