package blackjack;

import Cards.Ace;
import Cards.Card;
import Players.Player;
import java.util.ArrayList;
import java.util.List;

public class BlackJack {

    public static boolean isBlackJack(List<Card> bet){
        
        return calculateSumBet(bet) == 21 && bet.size() == 2;
    }
    
    public static int calculateSumBet(List<Card> bet) {
        
        int sum = 0;
        int numberAce = 0;
        
        for (Card card : bet) {
            sum += card.getValue();
            if (card instanceof Ace){
                numberAce++;
            }
        }
        
        while ((sum > 21) && (numberAce > 0))
        {
            sum -= 10;
            numberAce--;
        }        
        return sum;
    }
    
    public static List<Player> getWinners(Player player1, Player player2, Player player3,
                                   Player croupier, List<Card> deck){
        
        // Se completa el montón del Croupier
        while (calculateSumBet(croupier.getBet()) < 17) {
            croupier.addCard(deck.remove(0));
        }
        
        List<Player> winners = new ArrayList<>();
        Player[] players = {player1, player2, player3};
        
        // Si el Croupier tiene BlackJack, automáticamente gana él
        if (isBlackJack(croupier.getBet())) {
            return winners;
        }
        
        // Si el croupier excede 21, los jugadores con menos o igual a 21 ganan
        if (calculateSumBet(croupier.getBet()) > 21){
            for (Player player : players) {
                if (calculateSumBet(player.getBet()) <= 21) winners.add(player);
            }
            return winners;
        }
        
        // Cualquier otro caso
        for (Player player : players) {
            if (player.isWinner(croupier)) winners.add(player);
        }

        return winners;
        
    }
    
        
}
