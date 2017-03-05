/* ===========================================================================
   $File: $
   $Date: $
   $Revision: $
   $Creator: Ross Capdeville $
   $Notice: (C) Copyright 2017 by Ross Capdeville. All Rights Reserved. $
   =========================================================================== */

public class LinkedQueue<T> implements QueueInterface<T>
{

   private Node freeNode = new Node();
   private Node firstNode = freeNode;
   freeNode.data = null;
   freeNode.next = freeNode;
      
   private class Node
   {
      public T data = null;
      public Node next = null;
   }


   public boolean isEmpty()
   {
      return free.next.equals(first);
   }

   public T dequeue()
   {
      
   }

   public void clear()
   {
      
   }

   public T getFront()
   {
      
   }
}



