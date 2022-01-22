package Cards;

public class PipCard extends Card{
    
    private final int value;

    public PipCard(int value) throws BadValueException {
        
        if (value > 10 || value < 2){
            throw new BadValueException();
        }
        
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
    
    
    public static class BadValueException extends Exception {
        
        public BadValueException() {
            
            super("Valor de PipCard fuera de rango (2-10)");
        }
    }
    
    
}
