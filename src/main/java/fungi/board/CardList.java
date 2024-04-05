package fungi.board;

import fungi.cards.Card;
import java.util.ArrayList;

public class CardList {
  private final ArrayList<Card> cardList;

  public CardList() {
    cardList = new ArrayList<>();
  }

  public void add(Card card) {
    cardList.add(card);
  }

  public int size() {
    return cardList.size();
  }

  public Card getElementAt(int index) {
    return cardList.get((cardList.size() - 1) - index);
  }

  public Card removeCardAt(int index) {
    return cardList.remove(index - 1);
  }
}
