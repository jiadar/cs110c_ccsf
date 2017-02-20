package sort;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

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

   @Test
   public void testSelectionSortResult()
   {
      Integer[] a = {82, 33, 38, 25, 57, 33, 97, 17, 59, 68, 84, 30, 11, 73, 67, 31, 53, 79, 81, 84, 22, 94, 14, 54, 78, 28, 19, 94, 68, 45, 16, 33, 44, 53, 48, 66, 42, 96, 25, 44, 61, 77, 37, 53, 40, 56, 65, 50, 72, 88};
      Integer[] b = {11, 14, 16, 17, 19, 22, 25, 25, 28, 30, 31, 33, 33, 33, 37, 38, 40, 42, 44, 44, 45, 48, 50, 53, 53, 53, 54, 56, 57, 59, 61, 65, 66, 67, 68, 68, 72, 73, 77, 78, 79, 81, 82, 84, 84, 88, 94, 94, 96, 97};
      assertNotEquals(Arrays.toString(a), Arrays.toString(b));
      int swaps = Sorts.numberOfSwapsInSelectionSort(a);
      assertEquals(Arrays.toString(a), Arrays.toString(b));
   }
   
   @Test
   public void testSelectionSortSwaps()
   {
      Integer[] a = {53, 19, 19, 22, 23, 75, 50, 78, 77, 96, 23, 61, 29, 82, 93, 80, 40, 44, 87, 15, 33, 45, 69, 49, 11, 39, 13, 87, 25, 93, 85, 55, 47, 67, 33, 27, 10, 49, 76, 91, 91, 14, 14, 70, 96, 35, 88, 13, 65, 91};
      assertEquals(Sorts.numberOfSwapsInSelectionSort(a), 44);
   }

   @Test
   public void testRandomSelectionSort()
   {   
      Integer[] data1 = new Integer[10000];
      data1 = Sorts.generator(10000, 100000, 999999);
      Integer[] data2 = System.arraycopy(data1, 0, data2, 0, 10000);
      int swaps = Sorts.numberOfSwapsInSelectionSort(data);
      Arrays.sort(data2);
      assertEquals(data1, data2);
   }
}
