package models.Games;

import java.util.Random;

import models.Cards.Card;

public class Game {
    
    private int creditsNeeded;
    // private Card card;

    public Game(int creditsNeeded) {
        this.creditsNeeded = creditsNeeded;
    }

    public void playGame(Card card) {

        Random random = new Random();

        if(card.getCreditCardBalance() - creditsNeeded > 0) {
            int ticketsEarned = random.nextInt(30)+1;
            card.setTicketsBalance(card.getTicketsBalance() + ticketsEarned);
            System.out.println("Número do cartão: "+card.getCardNumber());
            System.out.println("Parabéns, você ganhou "+ ticketsEarned);
            System.out.println("Total de tickets: "+card.getTicketsBalance());
        }
        else{
            System.out.println("Creditos insuficientes! :(");
        }
    }
}
