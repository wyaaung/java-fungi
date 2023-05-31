package cards;

public class Mushroom extends EdibleItem {
    protected int sticksPerMushroom;

    public Mushroom(CardType cardType, String name) {
        super(cardType, name);
    }

    public int getSticksPerMushroom() {
        return sticksPerMushroom;
    }
}
