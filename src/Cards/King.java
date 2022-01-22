package Cards;

public class King extends Card{

    private final int value;

    public King() {
        this.value = 10;
    }
    
    @Override
    public int getValue() {
        return value;
    }
    
}
