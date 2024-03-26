package fungi.board;

import fungi.cards.Basket;
import fungi.cards.BirchBolete;
import fungi.cards.Butter;
import fungi.cards.Card;
import fungi.cards.CardType;
import fungi.cards.Chanterelle;
import fungi.cards.Cider;
import fungi.cards.HenOfWoods;
import fungi.cards.HoneyFungus;
import fungi.cards.LawyersWig;
import fungi.cards.Morel;
import fungi.cards.Pan;
import fungi.cards.Porcini;
import fungi.cards.Shiitake;
import fungi.cards.TreeEar;
import java.util.ArrayList;

public class Board {
    private static CardPile forestCardPile;
    private static CardList forest;
    private static ArrayList<Card> decayPile;

    public static void initialisePiles() {
        forestCardPile = new CardPile();
        forest = new CardList();
        decayPile = new ArrayList<>();
    }

    public static void setUpCards() {
        for (int i = 0; i < 10; i++) {
            forestCardPile.addCard(new HoneyFungus(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new HoneyFungus(CardType.NIGHTMUSHROOM));

        for (int i = 0; i < 8; i++) {
            forestCardPile.addCard(new TreeEar(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new TreeEar(CardType.NIGHTMUSHROOM));

        for (int i = 0; i < 6; i++) {
            forestCardPile.addCard(new LawyersWig(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new LawyersWig(CardType.NIGHTMUSHROOM));

        for (int i = 0; i < 5; i++) {
            forestCardPile.addCard(new Shiitake(CardType.DAYMUSHROOM));
            forestCardPile.addCard(new HenOfWoods(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new Shiitake(CardType.NIGHTMUSHROOM));
        forestCardPile.addCard(new HenOfWoods(CardType.NIGHTMUSHROOM));

        for (int i = 0; i < 4; i++) {
            forestCardPile.addCard(new BirchBolete(CardType.DAYMUSHROOM));
            forestCardPile.addCard(new Porcini(CardType.DAYMUSHROOM));
            forestCardPile.addCard(new Chanterelle(CardType.DAYMUSHROOM));
        }
        forestCardPile.addCard(new BirchBolete(CardType.NIGHTMUSHROOM));
        forestCardPile.addCard(new Porcini(CardType.NIGHTMUSHROOM));
        forestCardPile.addCard(new Chanterelle(CardType.NIGHTMUSHROOM));

        for (int i = 0; i < 3; i++) {
            forestCardPile.addCard(new Morel(CardType.DAYMUSHROOM));
            forestCardPile.addCard(new Butter());
            forestCardPile.addCard(new Cider());
        }

        for (int i = 0; i < 11; i++) {
            forestCardPile.addCard(new Pan());
        }

        for (int i = 0; i < 5; i++) {
            forestCardPile.addCard(new Basket());
        }
    }

    public static CardPile getForestCardsPile() {
        return forestCardPile;
    }

    public static CardList getForest() {
        return forest;
    }

    public static ArrayList<Card> getDecayPile() {
        return decayPile;
    }

    public static void updateDecayPile() {
        int lastIndex = forest.size() - 1;

        if (decayPile.size() >= 4) {
            decayPile.clear();
        }

        decayPile.add(forest.removeCardAt(lastIndex));
    }
}
