package fungi.board;

import fungi.cards.Card;
import java.util.Collections;
import java.util.Stack;

public class CardPile {
    private final Stack<Card> cardPile;

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
