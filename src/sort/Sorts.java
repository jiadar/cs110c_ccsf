package sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Sorts {

   private static <T extends Comparable<? super T>> int findMin(T[] data, int idx)
   {
      if (data == null)
         return -1;

      int min = idx;
      for(int i = idx; i < data.length; ++i)
      {  
         if (data[i].compareTo(data[idx]) < 0) 
         {         
            min = i;
            System.out.print("idx = " + idx + " i= " + i +  " min = " + data[min] + " ");
            System.out.println(Arrays.toString(data));
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
      if (data[idx].compareTo(data[min]) < 0)
      {
         swapElts(data, idx, min);
         return 1;
      }
      return 0;
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
         ++count;
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
      Integer[] data = new Integer[100];
      data = generator(10, 10, 99);
      System.out.println(Arrays.toString(data));
      int swaps = numberOfSwapsInSelectionSort(data);
      System.out.println(Arrays.toString(data));
   }
}


