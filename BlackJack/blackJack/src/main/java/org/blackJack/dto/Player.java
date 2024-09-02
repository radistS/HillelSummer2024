package org.blackJack.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private String name;
    private int numberOfGames = 0;
    private int numberOfWins = 0;
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }
}
