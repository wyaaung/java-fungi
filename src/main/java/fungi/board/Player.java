package fungi.board;

import fungi.cards.Card;
import fungi.cards.CardType;
import fungi.cards.EdibleItem;
import fungi.cards.Mushroom;
import fungi.cards.Pan;
import fungi.cards.Stick;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Player {
    private final Hand hand;
    private final Display display;

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
        while (numOfSticks > 0) {
            this.display.add(new Stick());
            this.sticks++;
            numOfSticks--;
        }
    }

    public void removeSticks(int numOfSticks) {
        if (this.sticks < numOfSticks) {
            return;
        }

        for (int i = 0; i < this.display.size(); i++) {
            if ((this.display.getElementAt(i).getType() == CardType.STICK) && (numOfSticks > 0)) {
                this.display.removeElement(i);
                this.sticks--;
                numOfSticks--;

                i--;
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
        Card cardToTake = Board.getForest().getElementAt(index - 1);

        if (index < 1 || index > 8) {
            return false;
        }

        if (this.handLimit <= this.hand.size()) {
            return false;
        }

        int sticksNeeded = index - 2;

        if (sticksNeeded > this.getStickNumber()) {
            return false;
        }

        if (index > 2 && index < 9) {
            this.removeSticks(sticksNeeded);
        }

        this.addCardtoHand(cardToTake);

        return true;
    }

    public boolean takeFromDecay() {
        int basketCards = 0, sizeOfDecayPile = Board.getDecayPile().size();

        for (Card card : Board.getDecayPile()) {
            if (card.getType() == CardType.BASKET) {
                basketCards++;
                this.handLimit += 2;
            }
        }

        if (this.getHandLimit() - this.getHand().size() < sizeOfDecayPile - basketCards) {
            return false;
        }

        for (Card card : Board.getDecayPile()) {
            if (card.getType() == CardType.BASKET) {
                this.addCardtoDisplay(card);
            } else {
                this.addCardtoHand(card);
            }
        }
        Board.getDecayPile().clear();

        return true;
    }

    /**
     * Input ArrayList contains cards of the hand that the player has indicated.
     */
    public boolean cookMushrooms(ArrayList<Card> ingredients) {
        System.out.println(ingredients);
        Boolean nonEdible = false;
        Integer indexPanInDisplay = null, indexPanInIngredients = null;

        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).getType() == CardType.PAN) {
                indexPanInIngredients = i;
            } else if (ingredients.get(i).getType() == CardType.BASKET || ingredients.get(i).getType() == CardType.STICK) {
                nonEdible = true;
            }
        }

        if (indexPanInIngredients == null) {
            for (int i = 0; i < this.display.size(); i++) {
                if (this.display.getElementAt(i).getType() == CardType.PAN) {
                    indexPanInDisplay = i;
                }
            }
        }

        System.out.println(indexPanInDisplay);
        System.out.println(indexPanInIngredients);

        if (indexPanInDisplay == null && indexPanInIngredients == null) {
            return false;
        }

        if (nonEdible) {
            return false;
        }

        Map<String, Integer> cardCount = ingredients.stream()
                .collect(Collectors.groupingBy(
                        Card::getName,
                        Collectors.summingInt(card -> {

                            if (card.getType() == CardType.NIGHTMUSHROOM) {
                                return 2;
                            } else {
                                return 1;
                            }
                        })
                ));

        int mushroomType = cardCount.entrySet().stream()
                .filter(card -> card.getKey() != "butter" && card.getKey() != "cider" && card.getKey() != "stick" && card.getKey() != "basket" && card.getKey() != "pan")
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).size();

        if (mushroomType > 1) {
            return false;
        }

        Integer butterCount = cardCount.getOrDefault("butter", 0);
        Integer ciderCount = cardCount.getOrDefault("cider", 0);

        cardCount = cardCount.entrySet().stream()
                .filter(card -> (card.getKey() != "butter" || card.getKey() != "cider") && card.getValue() >= 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        int baseFlavorPoints = ingredients.stream()
                .filter(card -> card instanceof EdibleItem)
                .mapToInt(card -> {
                    EdibleItem sample = (EdibleItem) card;
                    return card.getType() == CardType.NIGHTMUSHROOM ? sample.getFlavourPoints() * 2 :
                            card.getType() == CardType.DAYMUSHROOM ? sample.getFlavourPoints() : 0;
                })
                .sum();

        if (cardCount.isEmpty()) {
            return false;
        }

        for (Map.Entry<String, Integer> entry : cardCount.entrySet()) {
            System.out.println(entry.getValue());
            System.out.println(butterCount * 4 + ciderCount * 5);
            if (butterCount > 0 || ciderCount > 0) {
                if (entry.getValue() < butterCount * 4 + ciderCount * 5) {
                    return false;
                }
            }


            for (int i = 0; i < this.hand.size(); i++) {
                Card tempCard = this.hand.getElementAt(i);
                if (tempCard.getName() == "butter" && butterCount > 0) {
                    this.hand.removeElement(i);
                    i--;
                    butterCount--;
                } else if (tempCard.getName() == "cider" && ciderCount > 0) {
                    this.hand.removeElement(i);
                    i--;
                    ciderCount--;
                } else if (tempCard.getName() == entry.getKey()) {
                    this.hand.removeElement(i);
                    i--;
                }
            }
        }

        this.score = this.score + baseFlavorPoints + butterCount * 3 + ciderCount * 5;

        return true;
    }

    public boolean sellMushrooms(String mushroomName, int quantity) {
        if (quantity < 2) {
            return false;
        }

        String processedMushroomName = mushroomName.toLowerCase().replaceAll("'", "").replaceAll(" ", "");

        int numberOfDayMushroom = 0, noOfNightMushroom = 0, sticksToAdd = 0;

        for (int i = 0; i < this.hand.size(); i++) {
            Card tempCard = this.hand.getElementAt(i);
            if (processedMushroomName.equals(tempCard.getName())) {
                if (tempCard.getType() == CardType.DAYMUSHROOM) {
                    numberOfDayMushroom++;
                } else if (tempCard.getType() == CardType.NIGHTMUSHROOM) {
                    noOfNightMushroom++;
                }
            }
        }

        if (numberOfDayMushroom + noOfNightMushroom <= 0) {
            return false;
        }

        if (numberOfDayMushroom + 2 * noOfNightMushroom < quantity) {
            return false;
        }

        for (int i = 0; i < this.hand.size(); i++) {
            Card tempCard = this.hand.getElementAt(i);
            if (processedMushroomName.equals(tempCard.getName()) && quantity > 0) {
                if (tempCard.getType() == CardType.DAYMUSHROOM) {
                    quantity--;
                    this.hand.removeElement(i);
                    i--;
                    Mushroom sample = (Mushroom) tempCard;
                    sticksToAdd += sample.getSticksPerMushroom();
                } else if (tempCard.getType() == CardType.NIGHTMUSHROOM) {
                    quantity -= 2;
                    this.hand.removeElement(i);
                    i--;
                    Mushroom sample = (Mushroom) tempCard;
                    sticksToAdd += sample.getSticksPerMushroom() * 2;
                }
            }
        }

        addSticks(sticksToAdd);

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
