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
         if(data[i].compareTo(data[currentMin]) < 0)
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
      if(idx != min)
      {
         swapElts(data, idx, min);
         return 1;
      }
      return 0;
   }

   /*
    * The algorithm divides the input list into two parts: the sublist of items already
    * sorted, which is built up from left to right at the front (left) of the list, and
    * the sublist of items remaining to be sorted that occupy the rest of the
    * list. Initially, the sorted sublist is empty and the unsorted sublist is the
    * entire input list. The algorithm proceeds by finding the smallest (or largest,
    * depending on sorting order) element in the unsorted sublist, exchanging (swapping)
    * it with the leftmost unsorted element (putting it in sorted order), and moving the
    * sublist boundaries one element to the right.
    *
    */

   public static <T extends Comparable<? super T>> int
   numberOfSwapsInSelectionSort(T[] data)
   {
      int count=0;
      T temp = null;


      int sortedIndex=0;
      while (sortedIndex < data.length)
      {
         count += selectionSortSublist(data, sortedIndex);
         ++sortedIndex;
      }
      return count;
   }

   /*
    * Shellsort is a generalization of insertion sort that allows the exchange of items
    * that are far apart. The idea is to arrange the list of elements so that, starting
    * anywhere, considering every hth element gives a sorted list. Such a list is said
    * to be h-sorted. Equivalently, it can be thought of as h interleaved lists, each
    * individually sorted. Beginning with large values of h, this rearrangement
    * allows elements to move long distances in the original list, reducing large
    * amounts of disorder quickly, and leaving less work for smaller h-sort steps to
    * do. If the file is then k-sorted for some smaller integer k, then the file
    * remains h-sorted. Following this idea for a decreasing sequence of h values ending
    * in 1 is guaranteed to leave a sorted list in the end.
    *
    */

   public static <T extends Comparable<? super T>> int numberOfSwapsInShellSort(T[] data)
   {
      int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1, 0};
      int gapIndex=0;
      int i=0, j=0, swaps=0;
      while(data.length < gaps[gapIndex])
         ++gapIndex;

      int gap = gaps[gapIndex];

      while(gap >= 1)
      {
         for(i = gap; i < data.length; ++i)
         {
            T temp = data[i];

            for (j = i; (j >= gap) && (data[j - gap].compareTo(temp) > 0); j -= gap)
            {
               data[j] = data[j - gap];
               ++swaps;
            }
            
            data[j] = temp;
         }

         ++gapIndex;
         gap = gaps[gapIndex];
      }
      
      return swaps;
   }

   public static Integer[] generator(int elts, int min, int max)
   {
      Integer[] data = new Integer[elts];
      for(int i = 0; i < elts; ++i)
         data[i] = ThreadLocalRandom.current().nextInt(min, max-1);
      return data;
   }

   private static void testSwaps(int elts)
   {
      Integer[] data1 = new Integer[elts];
      Integer[] data2 = new Integer[elts];
      data1 = generator(elts, 0, 1000000);
      data2 = Arrays.copyOf(data1, data1.length);
      System.out.print(elts + " , " + numberOfSwapsInSelectionSort(data1));
      System.out.println(" , " + numberOfSwapsInShellSort(data2));
      
   }
   
   public static void main(String[] args)
   {
      System.out.println("Number of Elements, Selection Swaps, Shell Swaps");
      testSwaps(10);
      testSwaps(100);
      testSwaps(500);
      testSwaps(1000);
      testSwaps(2500);
      testSwaps(5000);
      testSwaps(10000);
   }
}


