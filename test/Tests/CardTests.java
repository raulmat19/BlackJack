package Tests;

import Cards.Ace;
import Cards.Card;
import Cards.Jack;
import Cards.PipCard;
import Cards.Queen;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CardTests {
    
    @Test
    public void test_getValue() throws PipCard.BadValueException{
        
        Card jack = new Jack();
        Card ace = new Ace();
        Card queen = new Queen();
        Card pipcard = new PipCard(3);
        
        assertEquals(10, jack.getValue());
        assertEquals(11, ace.getValue());
        assertEquals(10, queen.getValue());
        assertEquals(3, pipcard.getValue());
    }
    
    @Test(expected = PipCard.BadValueException.class)
    public void test_pipcard_value_exceed_max() throws PipCard.BadValueException{
        Card pipcard = new PipCard(12);
    }
    
    @Test(expected = PipCard.BadValueException.class)
    public void test_pipcard_value_not_exceed_min() throws PipCard.BadValueException{
        Card pipcard = new PipCard(1);
    }
}
