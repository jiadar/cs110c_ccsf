package bst;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
   public static void main(String[] args)
   {
      int SIZE=10000;
      long startTime, endTime, duration;
      System.out.println("Hello BST!");
      Btree<Integer>  b = new Btree<Integer>();
      ArrayList<Integer> a = new ArrayList<Integer>();

      System.out.println("Generating...");
      for(int i=0; i<SIZE; i++) {
         Integer num = ThreadLocalRandom.current().nextInt(1, SIZE*16);
         a.add(num);
         b.add(num);
      }
      System.out.println(a.toString());

      System.out.println("Searching BST...");
      startTime = System.nanoTime();
      for(int i=0; i<1000; i++) {
         b.contains(i);
      }
      endTime = System.nanoTime();
      System.out.println("Binary Tree Search: " + (endTime - startTime)/1000000 + " ms");
      //      System.out.println(b.toString());

      System.out.println("Searching Array List...");
      startTime = System.nanoTime();
      for(int i=0; i<1000; i++) {
         a.contains(i);  
      }      
      endTime = System.nanoTime();
      System.out.println("Array List Search: " + (endTime - startTime)/1000000 + " ms");
   }
}
