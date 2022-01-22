package Tests;

import Cards.Ace;
import Cards.Card;
import Cards.Jack;
import Cards.King;
import Cards.PipCard;
import Players.Player;
import blackjack.BlackJack;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BlackJack_Tests {
    
    @Test
    public void prueba_isBlackJack(){
        
        List<Card> bet = new ArrayList<>();
        
        // Añadimos a bet las cartas J y A
        bet.add(new Jack());
        bet.add(new Ace());
        
        // Comprobamos que el programa determina que existe BlackJack
        assert(BlackJack.isBlackJack(bet));
    }
    
    @Test
    public void test_caso_1() throws PipCard.BadValueException{
        
        List<Card> bet_Player1 = new ArrayList<>();
        bet_Player1.add(new Jack());
        bet_Player1.add(new Ace());
        
        List<Card> bet_Player2 = new ArrayList<>();
        bet_Player2.add(new PipCard(10));
        bet_Player2.add(new PipCard(5));
        bet_Player2.add(new PipCard(6));
        
        List<Card> bet_Player3 = new ArrayList<>();
        bet_Player3.add(new PipCard(3));
        bet_Player3.add(new PipCard(6));
        bet_Player3.add(new Ace());
        bet_Player3.add(new PipCard(3));
        bet_Player3.add(new Ace());
        bet_Player3.add(new King());
        
        List<Card> bet_Croupier = new ArrayList<>();
        bet_Croupier.add(new PipCard(9));
        bet_Croupier.add(new PipCard(7));
        
        Player player1 = new Player(bet_Player1);
        Player player2 = new Player(bet_Player2);
        Player player3 = new Player(bet_Player3);
        Player croupier = new Player(bet_Croupier);
        
        List<Card> deck = new ArrayList<>();
        deck.add(new PipCard(5));
        deck.add(new PipCard(4));
        deck.add(new King());
        deck.add(new PipCard(2));
        
        List<Player> winners = new ArrayList<>();
        winners.add(player1);
        
        List<Player> test_winners = BlackJack.getWinners(player1, player2,
                player3, croupier, deck);
        
        assertEquals(winners, test_winners);
        
    }
    
    @Test
    public void test_caso_2() throws PipCard.BadValueException{
        
        List<Card> bet_Player1 = new ArrayList<>();
        bet_Player1.add(new PipCard(10));
        bet_Player1.add(new King());
        
        List<Card> bet_Player2 = new ArrayList<>();
        bet_Player2.add(new PipCard(10));
        bet_Player2.add(new PipCard(2));
        bet_Player2.add(new PipCard(6));
        
        List<Card> bet_Player3 = new ArrayList<>();
        bet_Player3.add(new PipCard(8));
        bet_Player3.add(new PipCard(8));
        bet_Player3.add(new PipCard(5));
        
        List<Card> bet_Croupier = new ArrayList<>();
        bet_Croupier.add(new PipCard(5));
        bet_Croupier.add(new PipCard(10));
        
        Player player1 = new Player(bet_Player1);
        Player player2 = new Player(bet_Player2);
        Player player3 = new Player(bet_Player3);
        Player croupier = new Player(bet_Croupier);
        
        List<Card> deck = new ArrayList<>();
        deck.add(new Ace());
        deck.add(new PipCard(3));
        deck.add(new King());
        deck.add(new PipCard(2));
        
        List<Player> winners = new ArrayList<>();
        winners.add(player1);
        winners.add(player3);
        
        List<Player> test_winners = BlackJack.getWinners(player1, player2,
                player3, croupier, deck);
        
        assertEquals(winners, test_winners);
        
    }
    
    
    
}
