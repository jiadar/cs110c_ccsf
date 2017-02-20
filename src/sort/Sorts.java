package sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Sorts {

   private static <T extends Comparable<? super T>> int findMin(T[] data, int idx)
   {
      if (data == null)
         return -1;

      int min = 0;
      for(int i = 1; i < data.length; ++i)
         if (data[i].compareTo(data[min]) < 0)
            min = i;

      return min;      
   }

   public static <T extends Comparable<? super T>> int numberOfSwapsInSelectionSort(T[] data)
   {
      int cur = 0;
      int min = 0;
      int count=0;
      
      T temp = null;
      
      while ( cur < data.length )
      {
         min = findMin(data, cur);
         temp = data[cur];
         data[cur]=data[min];
         data[min] = data[cur];
         ++cur;
         ++count;
      }

      return count;
   }
         
   public static <T extends Comparable<? super T>> int numberOfSwapsInShellSort(T[] data)
   {
      return 0;
   }

   public static Integer[] generator(int elts, int max)
   {
      Integer[] data = new Integer[elts];
      for(int i = 0; i < elts; ++i)
         data[i] = ThreadLocalRandom.current().nextInt(0, max-1);
      return data;
   }

   public static void main(String[] args)
   {
      Integer[] data = new Integer[100];
      data = generator(100, 100);
      System.out.println(Arrays.toString(data));
      int swaps = numberOfSwapsInSelectionSort(data);
      System.out.println(Arrays.toString(data));
   }
}


