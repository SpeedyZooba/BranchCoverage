import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { 
    c = new Util(); 
  }

  @Test
  public void example() { 
    assertTrue(true); 
  }

  @Test
  public void testArgsLengthIsOne() {
    assertFalse(c.compute(1));
  }

  @Test 
  public void testArgsLengthIsEven() {
    assertFalse(c.compute(1, 2));
  }

  @Test
  public void testDivisorIsZero() {
    try {
      c.compute(0, 1, 2);
      fail("Expected exception was not thrown."); 
    }
    catch (RuntimeException e) {
      assertNotNull(e);
    }
  }

  @Test
  public void testSumIsDivisible() {
    assertTrue(c.compute(1, 1, 1));
  }

  @Test
  public void testSumIsNotDivisible() {
    assertFalse(c.compute(2, 3, 2));
  }
}