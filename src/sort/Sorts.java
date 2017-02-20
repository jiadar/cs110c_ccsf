package sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Sorts {

   public static <T extends Comparable<? super T>> int findMin(T[] data, int idx)
   {
      int min=idx;
      int currentMin = min;
      
      for(int i = idx; i<data.length; i++)
      {
         if(data[i].compareTo(data[currentMin) < 0)
         {
            min = i;
            currentMin=i;
         }
      }
      
      return min;
   }

   private static void swapElts(Object[] data, int idx1, int idx2)
   {
      Object temp = data[idx1];
      data[idx1] = data[idx2];
      data[idx2] = temp;
   }

   public static <T extends Comparable<? super T>> int
   selectionSortSublist(T[] data, int idx)
   {
      int min = findMin(data, idx);
      System.out.println("MIN = " + data[min]);
      swapElts(data, idx, min);
      System.out.println(Arrays.toString(data));
      return 1;
   }
   
   public static <T extends Comparable<? super T>> int
   numberOfSwapsInSelectionSort(T[] data)
   {
      int count=0;
      T temp = null;

// The algorithm divides the input list into two parts: the sublist of items already
// sorted, which is built up from left to right at the front (left) of the list, and the
// sublist of items remaining to be sorted that occupy the rest of the list. Initially,
// the sorted sublist is empty and the unsorted sublist is the entire input list. The
// algorithm proceeds by finding the smallest (or largest, depending on sorting order)
// element in the unsorted sublist, exchanging (swapping) it with the leftmost unsorted
// element (putting it in sorted order), and moving the sublist boundaries one element
// to the right.

      int sortedIndex=0;
      while (sortedIndex < data.length)
      {
         count += selectionSortSublist(data, sortedIndex);
         ++sortedIndex;
      }
      return count;
   }
         
   public static <T extends Comparable<? super T>> int numberOfSwapsInShellSort(T[] data)
   {
      return 0;
   }

   public static Integer[] generator(int elts, int min, int max)
   {
      Integer[] data = new Integer[elts];
      for(int i = 0; i < elts; ++i)
         data[i] = ThreadLocalRandom.current().nextInt(min, max-1);
      return data;
   }

   public static void main(String[] args)
   {
//      Integer[] data = new Integer[100];
      //    data = generator(8, 10, 99);
      Integer[] data = {63, 32, 11, 21, 75, 57, 45, 54};
      System.out.println(Arrays.toString(data));
      int swaps = numberOfSwapsInSelectionSort(data);
      System.out.println(Arrays.toString(data));
   }
}


