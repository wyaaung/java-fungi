package fungi.board;

import fungi.cards.Card;

public interface Displayable {
  void add(Card card);

  int size();

  Card getElementAt(int index);

  Card removeElement(int index);
}
