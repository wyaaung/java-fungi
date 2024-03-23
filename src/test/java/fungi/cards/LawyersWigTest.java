package fungi.cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LawyersWigTest {
    static LawyersWig lwd;

    @BeforeAll
    public static void setUp() {
        lwd = new LawyersWig(CardType.DAYMUSHROOM);
    }

    @Test
    public void testFlavourDay() {
        assertEquals(lwd.getFlavourPoints(), 2);
    }

    @Test
    public void testSticksDay() {
        assertEquals(lwd.getSticksPerMushroom(), 1);
    }
}
