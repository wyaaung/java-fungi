package cards;

public class Card {
    protected CardType cardType;

    protected String cardName;

    public Card (CardType cardType, String cardName){
        this.cardType = cardType;
        this.cardName = cardName;
    }

    public CardType getType(){
        return this.cardType;
    }

    public String getName(){
        return this.cardName;
    }
}
