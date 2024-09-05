package org.blackJack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import org.blackJack.dto.Card;
import org.blackJack.dto.GameResult;

public class GameService {

    public int getComputerHand(){
        // random value from 17 to 25
        return new Random().nextInt(25-17) + 17;
    }

    public List<Card> generateComputerHand(Stack<Card> cards){
        List<Card> hand = new ArrayList<Card>();
        Integer numberOfCards = new Random().nextInt(4) + 2;
        for (int i = 0; i < numberOfCards; i++) {
            hand.add(cards.pop());
        }
        return hand;
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

    public GameResult getGameResult(int computer, int player) {
        if (computer > 21 && player > 21) {
            return GameResult.LOSE;
        } else if (computer > 21) {
            return GameResult.PLAYER;
        } else if (player > 21) {
            return GameResult.COMPUTER;
        } else if (computer > player) {
            return GameResult.COMPUTER;
        } else if (player > computer) {
            return GameResult.PLAYER;
        } else {
            return GameResult.DRAW;
        }
    }

}
