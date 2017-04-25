package bst;

public class Main {
   public static void main(String[] args)
   {
      System.out.println("Hello BST");
      Btree<Integer>  b = new Btree<Integer>();
      b.add(10);
      b.add(5);
      b.add(1);
      b.add(7);
      b.add(9);
      b.add(6);
      b.add(4);
      b.add(3);
      System.out.println(b.toString());
      System.out.print("Get entry test: ");
      System.out.println(b.getEntry(Integer.valueOf(7)));
   }
}
