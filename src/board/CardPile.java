package board;

import java.util.Collections;
import java.util.Stack;

import cards.Card;

public class CardPile {
    private Stack<Card> cardPile;

    public CardPile() {
        cardPile = new Stack<Card>();
    }

    public void addCard(Card card) {
        cardPile.push(card);
    }

    public Card drawCard() {
        return cardPile.pop();
    }

    public void shufflePile() {
        Collections.shuffle(cardPile);
    }

    public int pileSize() {
        return cardPile.size();
    }

    public boolean isEmpty() {
        return cardPile.isEmpty();
    }
}
