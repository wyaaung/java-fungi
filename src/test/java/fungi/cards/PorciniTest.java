package fungi.cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PorciniTest {
  static Porcini pd;

  @BeforeAll
  public static void setUp() {
    pd = new Porcini(CardType.DAYMUSHROOM);
  }

  @Test
  public void testFlavourDay() {
    assertEquals(pd.getFlavourPoints(), 3);
  }

  @Test
  public void testSticksDay() {
    assertEquals(pd.getSticksPerMushroom(), 3);
  }
}
