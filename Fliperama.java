import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.AwardCategories.AwardCategorie;
import models.Cards.Card;
import models.Games.Game;
import models.Terminal.Terminal;

public class Fliperama {
    public static void main(String[] args){

        List<Card> cards = new ArrayList<Card>();

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        Game game = new Game(30);

        List<AwardCategorie> awards = new ArrayList<AwardCategorie>();
        
        AwardCategorie award = new AwardCategorie("Categoria 01", 15, 40);
        awards.add(award);
        AwardCategorie award01 = new AwardCategorie("Categoria 02", 40, 1);
        awards.add(award01);
        AwardCategorie award02 = new AwardCategorie("Categoria 03", 30, 40);
        awards.add(award02);
        
        
        
        while(true){
            System.out.println("\nSeja bem vindo ao fliperama. :D\n");

            System.out.println("\t\t\tMENU");
            System.out.println("1 - Gerar cartão");
            System.out.println("2 - Recarregar créditos do cartão");
            System.out.println("3 - Converter créditos em tickets");
            System.out.println("4 - Checar saldos");
            System.out.println("5 - Transferencia de tickets entre cartões");
            System.out.println("6 - Trocar tickets por premios");
            System.out.println("7 - Jogar");
            System.out.println("0 - Sair");

            switch(scanner.nextInt()){
                case 0:
                    exit = true;
                    break;
                case 1:
                    Card card = new Card();
                    cards.add(card);
                    System.out.println("\nCartão gerado com sucesso.");
                    System.out.println("Número do cartão: "+ card.getCardNumber()+"\n");
                    break;
                case 2:
                    System.out.println("Qual o valor da recarga?");  
                    int recharge = scanner.nextInt();           
                    System.out.println("Selecione o cartão ao qual deseja recarregar os créditos.");
                    for(int i = 0; i < cards.size(); i++){
                        System.out.println((i+1)+" - "+cards.get(i).getCardNumber()+" (saldo: R$"+cards.get(i).getCreditCardBalance()+")");
                    }

                    int cardR = scanner.nextInt() - 1;
                    if(cardR < cards.size()){
                        Terminal.rechargeCredits(recharge, cards.get(cardR));
                    }
                    else{
                        System.out.println("Informe um cartão valido\n");
                    }
                    //verificar se o cartao existe
                    
                    break;
                
                case 3:
                    System.out.println("Selecione o cartão ao qual deseja recarregar os tickets.");
                    for(int i = 0; i < cards.size(); i++){
                        System.out.println((i+1)+" - "+cards.get(i).getCardNumber()+" (saldo: R$"+cards.get(i).getCreditCardBalance()+")");
                    }
                    cardR = scanner.nextInt() - 1;
                    if(cardR < cards.size()){
                        System.out.println("Quantos creditos deseja transformar em tickets?");
                        int credits = scanner.nextInt();

                        if( credits <= cards.get(cardR).getCreditCardBalance()){
                            Terminal.creditsFortickets(cards.get(cardR), credits);
                        }
                        else{
                            System.out.println("Saldo insuficiente.\n");
                        }
                    }
                    else{
                        System.out.println("Informe um cartão valido");
                    }
                    break;

                case 4:
                
                    for(int i = 0; i < cards.size(); i++){
                        Terminal.checkBalance(cards.get(i));
                    }
                    break;
                case 5:
                    for(int i = 0; i < cards.size(); i++){
                        System.out.println((i+1)+" - "+cards.get(i).getCardNumber()+" (tickets: "+cards.get(i).getTicketsBalance()+")");
                    }
                    
                    System.out.println("Selecione o cartão ao qual deseja realizar a transferencia de tickets.");
                    cardR = scanner.nextInt() - 1;
                    System.out.println("Selecione o cartão que ira transferir.");
                    int card2 = scanner.nextInt();
                    
                    System.out.println("Quanto deseja transferir do cartão:\n"+cards.get(cardR).getTicketsBalance()+"\nPara o segundo cartão?\n");
                    Terminal.ticketsTranfer(cards.get(cardR), cards.get(card2),scanner.nextInt());
                    break;
                case 6:
                    System.out.println("Selecione o cartão ao qual deseja trocar os tickets por premios.");

                    for(int i = 0; i < cards.size(); i++){
                        System.out.println((i+1)+" - "+cards.get(i).getCardNumber()+" (tickets: "+cards.get(i).getTicketsBalance()+")");
                    }
                    Card card1 = cards.get(scanner.nextInt() - 1);
                    System.out.println("Qual premio gostaria de receber?");

                    for(int i = 0; i <awards.size(); i++){
                        System.out.println("=============AWARDS"+(i + 1)+"=============");
                        System.out.println("nome: "+awards.get(i).getNome());
                        System.out.println("Tickets necessarios: "+awards.get(i).getTicketsNeeded());
                        System.out.println("Itens restantes: "+awards.get(i).getCategoryItems());
                    }
                    Terminal.tradeTicketsForAwards(card1, awards.get(scanner.nextInt() - 1));
                    break;
                
                    case 7:
                    if(cards.isEmpty()){
                        System.out.println("Não há cartões para jogar.");
                        break;
                    }
                        System.out.println("Selecione o cartão ao qual deseja utilizar para jogar.");

                        for(int i = 0; i < cards.size(); i++){
                            System.out.println((i+1)+" - "+cards.get(i).getCardNumber()+" (tickets: "+cards.get(i).getTicketsBalance()+")");
                        }
                        game.playGame(cards.get(scanner.nextInt() - 1));
                    break;
                    
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
            }
            
            if(exit){
                break;
            }
        }
        scanner.close();
    }
}
