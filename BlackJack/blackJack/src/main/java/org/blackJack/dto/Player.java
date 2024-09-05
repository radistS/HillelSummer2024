package org.blackJack.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player {

    private String name;
    private int numberOfGames = 0;
    private int numberOfWins = 0;
    private int amount;
    @ToString.Exclude
    private List<Card> hand = new ArrayList<>();

    public Player(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public void incrementNumberOfGames() {
        numberOfGames++;
    }

    public void incrementNumberOfWins() {
        numberOfWins++;
    }

    public void clearHand() {
        hand.clear();
    }

    public void add(int value) {
        amount += value;
    }

    public void suv(int value) {
        amount -= value;
    }
}
