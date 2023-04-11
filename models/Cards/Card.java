package models.Cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {

    private static int cardsCount = 0;
    private static List<String> cards = new ArrayList<String>();
    private int thisCardId;
    private String cardNumber;
    private int creditCardBalance;
    private int ticketsBalance;
    
    public Card() {
        cardsCount++;
        this.thisCardId = cardsCount;
        this.cardNumber = generatedCardNumber();
        this.creditCardBalance = 0;
        this.ticketsBalance = 0;
        cards.add(this.cardNumber);
    }

    public String generatedCardNumber(){

        //List<String> cardNumbers = new ArrayList<String>();
        Random random = new Random();
        String cardNumbers = "";
        
        for(int i = 0; i < 4; i++){
            cardNumbers += ""+ (random.nextInt(8999) + 1000);
            cardNumbers += " ";
        }
        
        if(!cards.contains(cardNumbers)){
            return cardNumbers;
        }
        else{
            return generatedCardNumber();
        }
        
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getThisCardId() {
        return thisCardId;
    }
   
    public int getCreditCardBalance() {
        return creditCardBalance;
    }
    public void setCreditCardBalance(int money) {
        this.creditCardBalance = money;
    }
    public int getTicketsBalance() {
        return ticketsBalance;
    }
    public void setTicketsBalance(int ticketsBalance) {
        this.ticketsBalance = ticketsBalance;
    }

    
    // //.Nenhum desses saldos pode ser negativo 
    // Os cartões individuais não conseguem fazer cálculos, nem somas simples, nem perceber que os saldos estão ficando negativos.

    
    
}
