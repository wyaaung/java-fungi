package cards;

public class EdibleItem extends Card {
    protected int flavourPoints;

    public EdibleItem(CardType cardType, String cardName) {
        super(cardType, cardName);
    }

    public int getFlavourPoints() {
        return flavourPoints;
    }
}
