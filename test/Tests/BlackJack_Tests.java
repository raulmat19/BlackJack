package Tests;

import Cards.Ace;
import Cards.Card;
import Cards.Jack;
import blackjack.BlackJack;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class BlackJack_Tests {
    
    public BlackJack_Tests() {
    }
    
    @Test
    public void prueba_isBlackJack(){
        
        List<Card> bet = new ArrayList<>();
        
        // Añadimos a bet las cartas J y A
        bet.add(new Jack());
        bet.add(new Ace());
        
        // Comprobamos que el programa determina que existe BlackJack
        assert(BlackJack.isBlackJack(bet));
    }
    
    
    
}
