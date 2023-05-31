package board;

import java.util.ArrayList;

import cards.Card;

public class Player {
    private Hand hand;
    private Display display;

    private int score;
    private int handLimit;
    private int sticks;

    public Player() {}

    public int getScore() {
        return this.score;
    }

    public int getHandLimit() {
        return this.handLimit;
    }

    public int getStickNumber() {
        return this.sticks;
    }

    public void addSticks(int numOfSticks) {}

    public void removeSticks(int numOfSticks) {}

    public Hand getHand() {
        return this.hand;
    }

    public Display getDisplay() {
        return this.display;
    }

    public void addCardtoHand(Card card) {}

    public void addCardtoDisplay(Card card) {}

    public boolean takeCardFromTheForest(int index) {
        return false;
    }

    public boolean takeFromDecay() {
        return false;
    }

    public boolean cookMushrooms(ArrayList<Card> mushrooms) {
        return false;
    }

    public boolean sellMushrooms(String mushroomName, int quantity) {
        return false;
    }

    public boolean putPanDown() {
        return false;
    }
}
