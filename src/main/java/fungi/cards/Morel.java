package fungi.cards;

public class Morel extends Mushroom {
    public Morel(CardType cardType) {
        super(cardType, "morel");
        super.flavourPoints = 6;
        super.sticksPerMushroom = 4;
    }
}
