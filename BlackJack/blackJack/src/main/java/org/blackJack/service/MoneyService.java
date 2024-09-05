package org.blackJack.service;

import java.util.Scanner;
import org.blackJack.exceptions.NotEnoughtMoneyException;

public class MoneyService {

    public int validateAmount(int amount, int bet){

        if (amount <= 0) {
            throw new NotEnoughtMoneyException("game over .. RIP");
        }

        if (bet > amount){
            try(Scanner scanner = new Scanner(System.in)) {
                System.out.printf("You can put %s $. Continue [Y/N]%n", amount);
                String input = scanner.nextLine();

                if (!input.equalsIgnoreCase("y")){
                    System.out.printf("Please put your bet less than %s $%n", amount);
                    bet = scanner.nextInt();
                    scanner.nextLine();
                    validateAmount(amount, bet);
                } else {
                    bet = amount;
                }
            }
        }
        return bet;
    }

}
