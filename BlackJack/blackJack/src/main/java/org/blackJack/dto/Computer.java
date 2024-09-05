package org.blackJack.dto;

import java.util.List;
import java.util.Stack;
import org.blackJack.service.GameService;

public class Computer {
    private GameService gameService;

    public Computer(GameService gameService) {
        this.gameService = gameService;
    }

    public int getHandCount(){
        return gameService.getComputerHand();
    }

    public List<Card> getHand(Stack<Card> deck){
        return gameService.generateComputerHand(deck);
    }
}
