package fungi.cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeEarTest {

  static TreeEar ted;

  @BeforeAll
  public static void setUp() {
    ted = new TreeEar(CardType.DAYMUSHROOM);
  }

  @Test
  public void testFlavourDay() {
    assertEquals(ted.getFlavourPoints(), 1);
  }

  @Test
  public void testSticksDay() {
    assertEquals(ted.getSticksPerMushroom(), 2);
  }


}
