package Tests;

import Cards.Ace;
import Cards.Card;
import Cards.Jack;
import Cards.King;
import Cards.PipCard;
import Cards.Queen;
import Players.Player;
import blackjack.BlackJack;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MethodsTests {
    
    @Test
    public void test_isBlackJack() throws PipCard.BadValueException{
        
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
    
    @Test
    public void test_calculateSumBet() throws PipCard.BadValueException{
        
        List<Card> test_bet = new ArrayList<>();
        test_bet.add(new Jack());
        test_bet.add(new PipCard(10));
        test_bet.add(new Ace());
        assertEquals(21, BlackJack.calculateSumBet(test_bet));
        
        
        test_bet.clear();
        test_bet.add(new Ace());
        test_bet.add(new Ace());
        test_bet.add(new Ace());
        assertEquals(13, BlackJack.calculateSumBet(test_bet));
        
        test_bet.clear();
        test_bet.add(new Jack());
        test_bet.add(new Queen());
        test_bet.add(new PipCard(9));
        assertEquals(29, BlackJack.calculateSumBet(test_bet));
        
    }
    
    
    @Test
    public void test_isWinner() throws PipCard.BadValueException{
        
        List<Card> test_player_bet = new ArrayList<>();
        test_player_bet.add(new PipCard(10));
        test_player_bet.add(new King());
        
        List<Card> test_croupier_bet = new ArrayList<>();
        test_croupier_bet.add(new PipCard(10));
        test_croupier_bet.add(new PipCard(2));
        test_croupier_bet.add(new PipCard(6));
        
        Player test_player = new Player(test_player_bet);
        Player test_croupier = new Player(test_croupier_bet);
        
        assert(test_player.isWinner(test_croupier));
        
        
        test_player_bet.clear();
        test_player_bet.add(new PipCard(10));
        test_player_bet.add(new King());
        
        test_croupier_bet.clear();
        test_croupier_bet.add(new PipCard(10));
        test_croupier_bet.add(new Ace());
        
        test_player = new Player(test_player_bet);
        test_croupier = new Player(test_croupier_bet);
        
        assert(!test_player.isWinner(test_croupier));
        
        test_player_bet.clear();
        test_player_bet.add(new PipCard(10));
        test_player_bet.add(new King());
        
        test_croupier_bet.clear();
        test_croupier_bet.add(new PipCard(10));
        test_croupier_bet.add(new King());
        
        test_player = new Player(test_player_bet);
        test_croupier = new Player(test_croupier_bet);
        
        assert(!test_player.isWinner(test_croupier));
        
        test_player_bet.clear();
        test_player_bet.add(new PipCard(10));
        test_player_bet.add(new King());
        test_player_bet.add(new King());
        
        test_croupier_bet.clear();
        test_croupier_bet.add(new PipCard(10));
        test_croupier_bet.add(new PipCard(3));
        
        test_player = new Player(test_player_bet);
        test_croupier = new Player(test_croupier_bet);
        
        assert(!test_player.isWinner(test_croupier));
    }
    
    
}
