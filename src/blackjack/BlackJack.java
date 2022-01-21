package blackjack;

import Cards.Ace;
import Cards.Card;
import java.util.List;

public class BlackJack {

    public static void main(String[] args) {
    }

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
        }        
        return sum;
    }
        
}
