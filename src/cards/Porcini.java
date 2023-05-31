package cards;

public class Porcini extends Mushroom {
    public Porcini(CardType cardType) {
        super(cardType, "porcini");
        super.flavourPoints = 3;
        super.sticksPerMushroom = 3;
    }
}
