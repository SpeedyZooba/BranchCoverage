import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testNoSize() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(0);
    c = new Compute(mq);
    assertEquals(-1, c.countNumberOfOccurrences("size test"));
  }

  @Test
  public void testDoesNotContain() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(12);
    when(mq.contains("contain test")).thenReturn(false);
    c = new Compute(mq);
    assertEquals(0, c.countNumberOfOccurrences("contain test"));
  }

  @Test
  public void testCounterExists() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(12);
    when(mq.contains("counter test")).thenReturn(true);
    when(mq.getAt(anyInt())).thenReturn("counter test");
    c = new Compute(mq);
    assertEquals(12, c.countNumberOfOccurrences("counter test"));
  }

  @Test
  public void testCounterDoesNotExist() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(12);
    when(mq.contains("counter test")).thenReturn(true);
    when(mq.getAt(5)).thenReturn("no counter test");
    when(mq.getAt(not(eq(5)))).thenReturn("counter test");
    c = new Compute(mq);
    assertEquals(11, c.countNumberOfOccurrences("counter test"));
  }
}