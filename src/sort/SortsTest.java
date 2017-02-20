package sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortsTest {

  @Test
  public void testMin() {
     Integer[] a = { 3, 6, 9, 12, 15};
     for (int i=0; i<a.length; i++)
     {
        assertEquals(Sorts.findMin(a, i), i);
     }
     Integer[] b = { 2, 6, 3, 7, 5 };
     assertEquals(Sorts.findMin(b, 0), 0);
     assertEquals(Sorts.findMin(b, 1), 2);
     assertEquals(Sorts.findMin(b, 2), 2);
     assertEquals(Sorts.findMin(b, 3), 4);
     assertEquals(Sorts.findMin(b, 4), 4);
     Integer[] c = {63, 32, 11, 21, 75, 57, 45, 54};
     assertEquals(Sorts.findMin(c, 0), 2);

  }
}
