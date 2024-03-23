package fungi.cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoneyFungusTest {

    static HoneyFungus hfd;

    @BeforeAll
    public static void setUp() {
        hfd = new HoneyFungus(CardType.DAYMUSHROOM);
    }

    @Test
    public void testFlavourDay() {
        assertEquals(hfd.getFlavourPoints(), 1);
    }

    @Test
    public void testSticksDay() {
        assertEquals(hfd.getSticksPerMushroom(), 1);
    }

}
