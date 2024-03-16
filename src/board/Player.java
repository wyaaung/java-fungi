package board;

import java.util.ArrayList;

import cards.Card;
import cards.CardType;
import cards.Mushroom;
import cards.Pan;
import cards.Stick;

public class Player {
    private Hand hand;
    private Display display;

    private int score;
    private int handLimit;
    private int sticks;

    public Player() {
        this.score = 0;
        this.handLimit = 8;
        this.sticks = 0;

        this.hand = new Hand();
        this.display = new Display();

        // Adding Default Pan
        this.display.add(new Pan());
    }

    public int getScore() {
        return this.score;
    }

    public int getHandLimit() {
        return this.handLimit;
    }

    public int getStickNumber() {
        return this.sticks;
    }

    public void addSticks(int numOfSticks) {
        while (numOfSticks > 0){
            this.display.add(new Stick());
            numOfSticks--;
        }
    }

    public void removeSticks(int numOfSticks) {
        if (this.sticks < numOfSticks){
            return;
        }

        for (int i = 0; i < this.display.size(); i++) {
            if ((this.display.getElementAt(i).getType() == CardType.STICK) && (numOfSticks > 0)) {
                this.display.removeElement(i);
                numOfSticks--;
            }
        }
    }

    public Hand getHand() {
        return this.hand;
    }

    public Display getDisplay() {
        return this.display;
    }

    public void addCardtoHand(Card card) {
        if (card.getType() == CardType.BASKET) {
            this.display.add(card);
            this.handLimit += 2;
        } else {
            this.hand.add(card);
        }
    }

    public void addCardtoDisplay(Card card) {
        this.display.add(card);
    }

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
        if (quantity < 2) {
            return false;
        }

        String processedMushroomName = mushroomName.toLowerCase().replaceAll("'", "").replaceAll(" ", "");

        int totalInHand = 0, sticksToAdd = 0;

        for (int i = 0; i < this.hand.size(); i++) {
            Card tempCard = this.hand.getElementAt(i);
            if (processedMushroomName.equals(tempCard.getName())) {
                if (tempCard.getType() == CardType.DAYMUSHROOM) {
                    totalInHand++;
                    Mushroom sample = (Mushroom) tempCard;
                    sticksToAdd += sample.getSticksPerMushroom();
                } else if (tempCard.getType() == CardType.NIGHTMUSHROOM){
                    totalInHand += 2;
                    Mushroom sample = (Mushroom) tempCard;
                    sticksToAdd += sample.getSticksPerMushroom();
                }
            }
        }

        if (totalInHand < 0 || totalInHand < quantity) {
            return false;
        }

        addSticks(sticksToAdd);

        for (int i = 0; i < hand.size(); i++) {
            Card tempCard = this.hand.getElementAt(i);
            if (processedMushroomName.equals(tempCard.getName())) {
                hand.removeElement(i);
                i--;
            }
        }

        return true;
    }

    public boolean putPanDown() {
        for (int i = 0; i < this.hand.size(); i++) {
            Card tempCard = this.hand.getElementAt(i);
            if (tempCard.getType() == CardType.PAN) {
                this.display.add(tempCard);
                this.hand.removeElement(i);

                return true;
            }
        }

        return false;
    }
}
