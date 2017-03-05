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
      return freeNode.next.equals(firstNode);
   }

   public void enqueue(T data)
   {
      if (isEmpty())
      {
         Node tmp = new Node();
         freeNode.data = data;
         queueNode = freeNode;
         queueNode.next = tmp;
      }
      else
      {
         Node tmp = new Node();
         freeNode.data = data;
         freeNode.next = tmp;
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
      T tmp = null;
      return tmp;
      
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
   }
}



