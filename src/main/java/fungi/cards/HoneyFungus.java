package fungi.cards;

public class HoneyFungus extends Mushroom {
  public HoneyFungus(CardType cardType) {
    super(cardType, "honeyfungus");
    super.flavourPoints = 1;
    super.sticksPerMushroom = 1;
  }
}
