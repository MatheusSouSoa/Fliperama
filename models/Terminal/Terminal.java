package models.Terminal;

import models.AwardCategories.AwardCategorie;
import models.Cards.Card;

public class Terminal {


    public static void rechargeCredits(int money, Card card) {
        int creditBalance = card.getCreditCardBalance();
        card.setCreditCardBalance(creditBalance + money);
    }    

    //PASSAR FUNÇÃO DE ESCOLHER VALOR A SER CONVERTIDOS
    public static void creditsFortickets(Card card, int money) {
        card.setTicketsBalance(card.getTicketsBalance() + (money * 2));
        card.setCreditCardBalance(card.getCreditCardBalance() - money);
    }

    public static void checkBalance(Card card){
        System.out.println("\n======================CARTÃO======================");
        System.out.println("Número do cartão: "+card.getCardNumber());
        System.out.println("Saldo de créditos: R$"+card.getCreditCardBalance());
        System.out.println("Saldo de tickets: "+ card.getTicketsBalance());
    }

    public static void ticketsTranfer(Card card01, Card card02, int money){
        if(card01.getTicketsBalance() - money > 0){
            card02.setTicketsBalance(card02.getTicketsBalance() + money);
            card01.setTicketsBalance(card01.getTicketsBalance() - money);
            System.out.println("Transferência realizada com sucesso.");
            System.out.println("O saldo atual do cartão 01 é de: "+card01.getTicketsBalance());
            System.out.println("O saldo atual do cartão 02 é de: "+card02.getTicketsBalance());
        }
        else{
            System.out.println("Não há saldo suficiente para realizar a transferência.");
        }
    }

    public static void tradeTicketsForAwards(Card card, AwardCategorie award){
        if(card.getTicketsBalance() - award.getTicketsNeeded() > 0 ){
            if(award.getCategoryItems() > 0){
                System.out.println("Premio retirado com sucesso.");
                award.setCategoryItems(award.getCategoryItems() - 1);
                card.setTicketsBalance(card.getTicketsBalance() - award.getTicketsNeeded());
                System.out.println("Resta(m) "+ award.getCategoryItems()+" ainda.");
            }else{
                System.out.println("\n"+award.getNome()+ " fora de estoque.");
            }
        }else{
            System.out.println("Saldo do cartão insuficiente para a retirada do premio "+ award.getNome());
            System.out.println("É necessario "+award.getTicketsNeeded()+" tickets para retirar o premio, você tem "+card.getTicketsBalance()+" no cartão atual.");
        }
    }

    //DESENVOLVER METODE DE PASSAR CARTAO NO JOGO
}
