package sort;

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

   private static long rand(long range, long seed)
   {
      x ^= (x << 21);
      x ^= (x >>> 35);
      x ^= (x << 4);
      return x % range;
   }

   public static int[] generator(int elts)
   {
      long seed = System.nanoTime();
      int[] data = new int[elts-1];
      for(i = 0; i < elts; ++i)
         data[i] = rand(100, seed);
   }

   public static void main(String[] args)
   {
      data=generator(100);
      System.out.println(data);
   }
}


