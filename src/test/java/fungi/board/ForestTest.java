package fungi.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ForestTest {
    public Board f;

    @BeforeEach
    public void setUpForest() {
        f = new Board();
        Board.initialisePiles();
    }

    @Test
    public void numberOfDayMushroomCardsBeforeCardSetUp() {
        assertEquals(Board.getForestCardsPile().pileSize(), 0);
    }

    @Test
    public void numberOfDayMushroomCardsAfterCardSetUp() {
        Board.setUpCards();
        assertEquals(Board.getForestCardsPile().pileSize(), 79);
    }
}