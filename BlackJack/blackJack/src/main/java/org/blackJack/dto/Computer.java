package org.blackJack.dto;

import org.blackJack.service.GameService;

public class Computer {
    private GameService gameService;

    public Computer(GameService gameService) {
        this.gameService = gameService;
    }

    public int getHandCount(){
        return gameService.getComputerHand();
    }

}
