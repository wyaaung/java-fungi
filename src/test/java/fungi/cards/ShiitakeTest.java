package fungi.cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShiitakeTest {
  static Shiitake sd;

  @BeforeAll
  public static void setUp() {
    sd = new Shiitake(CardType.DAYMUSHROOM);
  }

  @Test
  public void testFlavourDay() {
    assertEquals(sd.getFlavourPoints(), 2);
  }

  @Test
  public void testSticksDay() {
    assertEquals(sd.getSticksPerMushroom(), 2);
  }
}
