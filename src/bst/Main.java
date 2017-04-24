package bst;

public class Main {
   public static void main(String[] args)
   {
      System.out.println("Hello BST");
      Btree<Integer>  b = new Btree<Integer>();
      System.out.println("adding 10");
      b.add(10);
      b.printTree();
      System.out.println("adding 5");
      b.printTree();
      b.add(5);
      b.printTree();
      System.out.println("adding 15");
      b.printTree();
      b.add(15);
      b.printTree();

   }
}
