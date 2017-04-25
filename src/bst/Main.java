package bst;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
   public static void main(String[] args)
   {
      System.out.println("Hello BST");
      Btree<Integer>  b = new Btree<Integer>();
      ArrayList<Integer> a = new ArrayList<Integer>();
      for(int i=0; i<100; i++) {
         Integer num = ThreadLocalRandom.current().nextInt(100, 999);
         a.add(num);
         b.add(num);
      }
      long startTime = System.nanoTime();
      methodToTime();
      long endTime = System.nanoTime();
      long duration = (endTime - startTime); 
      System.out.println(b.toString());
      System.out.print("Get entry test: ");
      System.out.println(b.getEntry(Integer.valueOf(6)));
   }
}
