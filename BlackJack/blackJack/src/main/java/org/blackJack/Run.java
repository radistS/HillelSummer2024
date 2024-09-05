package org.blackJack;

import java.util.List;
import java.util.Scanner;
import org.blackJack.dto.Card;
import org.blackJack.dto.Computer;
import org.blackJack.dto.GameResult;
import org.blackJack.dto.Player;
import org.blackJack.exceptions.NotEnoughtMoneyException;
import org.blackJack.service.DeckService;
import org.blackJack.service.GameService;
import org.blackJack.service.MoneyService;

public class Run {

    public static void main(String[] args) {
        System.out.println("BlackJack 2024");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please put you name ....");
        String name = scanner.next();

        System.out.println("Please put money ....");
        int amount = scanner.nextInt();

        System.out.println("Please put number of games ....");
        int games = scanner.nextInt();
        scanner.nextLine();

        Player player = new Player(name, amount);
        DeckService deckService = new DeckService();
        deckService.createDeck(1);
        GameService gameService = new GameService();
        Computer computer = new Computer(gameService);

        String nextCard = "Y";
        String nextGame = "Y";

        int game = 1;

        do {
            System.out.println("-------------->");
            System.out.println("Game " + game + " from  " + games);

            System.out.println("Please put your bet:");
            int bet = scanner.nextInt();
            scanner.nextLine();

            try {
                new MoneyService().validateAmount(player.getAmount(), bet);
            } catch (NotEnoughtMoneyException e) {
                break;
            }

            game(player, deckService, gameService, scanner);

            List<Card> computerHand = computer.getHand(deckService.getDeck());

            int cScore = gameService.calculateHandScore(computerHand);
            int pScore = gameService.calculateHandScore(player.getHand());

            // print hands and scores
            System.out.println("===========");
            System.out.println("player hand : " + player.getHand() + " >>>> score: " + pScore);
            System.out.println("computer hand : " + computerHand + " >>>> score: " + cScore);

            GameResult gameResult = gameService.getGameResult(cScore, pScore);
            System.out.println(gameResult);

            player.incrementNumberOfGames();
            if (GameResult.PLAYER.equals(gameResult)) {
                player.incrementNumberOfWins();
                player.add(bet);
            }else if (!GameResult.DRAW.equals(gameResult)) {
                player.suv(bet);
            }

            if (game++ != games){
                System.out.println("Next game ... [Y/N]");
                nextGame = scanner.nextLine();
            } else {
                break;
            }

        } while (nextGame.equals("Y"));

        System.out.println(player);

    }

    private static void game(Player player, DeckService deckService, GameService gameService,
        Scanner scanner) {
        String nextCard;
        player.clearHand();
        do {
            List<Card> hand = player.getHand();
            // first time give 2 cards
            if (player.getHand().size() == 0) {
                hand.add(deckService.getCard());
            }
            hand.add(deckService.getCard());

            int score = gameService.calculateHandScore(hand);
            System.out.println("player hand : " + hand + " >>>> score : " + score);
            if (score < 21){
                System.out.println("Next card ... [Y/N]");
                nextCard = scanner.nextLine();
            } else {
                break;
            }
        } while (nextCard.equalsIgnoreCase("y"));

    }

}
