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
   freeNode.next = firstNode;
      
   private class Node
   {
      public T data;
      public Node next;
   }


   public boolean isEmpty()
   {
//      return free.next.equals(first);
      return false;
   }

   public void enqueue(T data)
   {
      
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
      T tmp = null;
      return tmp;
      
   }
}



