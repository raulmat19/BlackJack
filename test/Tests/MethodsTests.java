package Tests;

import Cards.Ace;
import Cards.Card;
import Cards.Jack;
import Cards.King;
import Cards.PipCard;
import Cards.Queen;
import blackjack.BlackJack;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MethodsTests {
    
    @Test
    public void prueba_isBlackJack() throws PipCard.BadValueException{
        
        // Añadimos a bet las cartas J y A
        List<Card> bet = new ArrayList<>();
        bet.add(new Jack());
        bet.add(new Ace());
        
        List<Card> bet2 = new ArrayList<>();
        bet2.add(new King());
        bet2.add(new Ace());
        
        List<Card> bet3 = new ArrayList<>();
        bet3.add(new Queen());
        bet3.add(new Ace());
        
        List<Card> bet4 = new ArrayList<>();
        bet4.add(new PipCard(10));
        bet4.add(new Ace());
        
        // Comprobamos que el programa determina que existe BlackJack en todos los casos
        assert(BlackJack.isBlackJack(bet));
        assert(BlackJack.isBlackJack(bet2));
        assert(BlackJack.isBlackJack(bet3));
        assert(BlackJack.isBlackJack(bet4));
    }
}
