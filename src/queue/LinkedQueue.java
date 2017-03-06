/* ===========================================================================
   $File: $
   $Date: $
   $Revision: $
   $Creator: Ross Capdeville $
   $Notice: (C) Copyright 2017 by Ross Capdeville. All Rights Reserved. $
   =========================================================================== */


package queue;

public class LinkedQueue<T> implements QueueInterface<T>
{

   private Node freeNode = new Node();
   private Node firstNode = freeNode;

   public LinkedQueue()
   {
      freeNode.next = firstNode;
      firstNode.data = null;
   }
      
   private class Node
   {
      public T data;
      public Node next;
   }


   public boolean isEmpty()
   {
      return freeNode.equals(firstNode);
   }

   public void enqueue(T data)
   {
      if (isEmpty())
      {
         // In the empty case, put new data into firstNode
         firstNode.data = data;

         // Make a new tmp to be freeNode 
         Node tmp = new Node();

         // Link tmp to firstNode
         firstNode.next = tmp;

         // Link freeNode to tmp
         freeNode = tmp;

         // Link freenode next back to firstnode
         freeNode.next = firstNode;
         
      }
      else
      {
         // Put data into freeNode
         freeNode.data = data;

         // Make a new tmp to be freeNode
         Node newNode = new Node();

         // Link freenode to newNode 
         freeNode.next = newNode; 

         // Link new node to firstNode
         newNode.next = firstNode;

         // Move along freeNode
         freeNode = freeNode.next;          
         
      }
   }
   
   public T dequeue()
   {
      T tmp = null;
      return tmp;
   }

   public void clear()
   {
      
   }

   public T getFront()
   {
      if (isEmpty())
         throw new NullPointerException("Disallowed attempt to get element from empty queue");
      else
         return firstNode.data;
   }

   public String toString()
   {
      Node cur = firstNode;
      String rval = "";
      boolean valid = true;
      
      if (this.isEmpty())
         return "empty";

      rval = cur.data + ", ";
      cur = cur.next;
            
      while (cur != firstNode)
      {
         rval += valid ? cur.data + ", " : "free, ";
         cur = cur.next;
         valid = cur != freeNode ? true : false;
      }

      return rval.substring(0, rval.length() - 2);
   }

   public static void main(String[] args)
   {
      QueueInterface<Integer> q = new LinkedQueue<Integer>();
      q.enqueue(1);
      q.enqueue(2);
      q.enqueue(3);
      q.enqueue(4);
      System.out.println(q.toString());
                                
   }
}



