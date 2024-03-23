package fungi.cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BirchBoleteTest {
    static BirchBolete bbd;

    @BeforeAll
    public static void setUp() {
        bbd = new BirchBolete(CardType.DAYMUSHROOM);
    }

    @Test
    public void testFlavourDay() {
        assertEquals(bbd.getFlavourPoints(), 3);
    }

    @Test
    public void testSticksDay() {
        assertEquals(bbd.getSticksPerMushroom(), 2);
    }

}
