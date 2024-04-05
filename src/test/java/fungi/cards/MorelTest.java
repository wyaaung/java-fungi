package fungi.cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MorelTest {
  static Morel md;

  @BeforeAll
  public static void setUp() {
    md = new Morel(CardType.DAYMUSHROOM);
  }

  @Test
  public void testFlavourDay() {
    assertEquals(md.getFlavourPoints(), 6);
  }

  @Test
  public void testSticksDay() {
    assertEquals(md.getSticksPerMushroom(), 4);
  }
}
