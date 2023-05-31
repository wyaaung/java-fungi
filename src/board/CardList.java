package board;

import java.util.ArrayList;

import cards.Card;

public class CardList {
    private ArrayList<Card> cardList;

    public CardList() {
        cardList = new ArrayList<Card>();
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
