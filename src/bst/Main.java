package bst;

public class Main {
   public static void main(String[] args)
   {
      System.out.println("Hello BST");
      Btree<Integer>  b = new Btree<Integer>();
      System.out.println("adding 10");
      b.add(10);
      System.out.println(b.preorder());
      System.out.println("adding 5");
      b.add(5);
      System.out.println(b.preorder());
      System.out.println("adding 15");
      b.add(15);
      System.out.println(b.preorder());

   }
}
