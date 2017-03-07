/* ===========================================================================
   $File: $
   $Date: $
   $Revision: $
   $Creator: Ross Capdeville $
   $Notice: (C) Copyright 2017 by Ross Capdeville. All Rights Reserved. $
   =========================================================================== */


package queue;

// Implement a circular linked chain queue

public class LinkedQueue<T> implements QueueInterface<T>
{

   private Node freeNode = new Node();
   private Node firstNode = freeNode;
   private int nodeNumber = 0;
   
   public LinkedQueue()
   {
      clear();
   }
      
   private class Node
   {
      public Node()
      {
         ++number;
         this.number = number;
      }
      public T data;
      public Node next;
      public int number;
   }


   public boolean isEmpty()
   {
      // want the same exact reference, not 2 different nodes with the same data
      // so use == vs .equals
      return freeNode == firstNode; 
   }

   public boolean isFull()
   {
      // want the same exact reference, not 2 different nodes with the same data
      // so use == vs .equals
      return freeNode.next == firstNode;
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
      else if (isFull()) // make a new node
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
      else // use existing capacity
      {
         // Put data into freeNode
         freeNode.data = data;

         // Move along freeNode
         freeNode = freeNode.next;                   
      }
         
   }
   
   public T dequeue()
   {
      T tmp = getFront();
      firstNode.data = null;
      firstNode = firstNode.next; 
      return tmp;
   }

   public void clear()
   {
      // reset the state to the same as a new LinkedQueue object
      freeNode = new Node();
      firstNode = freeNode;
      freeNode.next = firstNode;
      firstNode.data = null;
   }

   public T getFront()
   {
      if (isEmpty())
         throw new IllegalStateException("Disallowed attempt to get element from empty queue");
      else
         return firstNode.data;
   }

   public String toStringDetail()
   {
      // print number with the node
      return "";
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
         valid = cur != freeNode ? true : false;
         rval += valid ? cur.data != null ? cur.data + ", " : "free, " : "next, ";
         cur = cur.next;
      }

      return rval.substring(0, rval.length() - 2);
   }

   public void splice(QueueInterface<T> q)
   {
      // O(n) if we can not access the memory / references directly
      while(! q.isEmpty())
         this.enqueue(q.dequeue());
   }

   public void splice2(LinkedQueue<T> q)
   {
      // O(1) if we can just splice the two linked chains
      if (this.isEmpty())
      {
         // In the case our instance is empty, just copy the instance variables
         // from the parameter queue
         firstNode.next = q.firstNode;
         freeNode.next = q.freeNode;         
      }
      else
      {
         // In the case where our instance has nodes, just splice in the parameter
         // queue into free node

         freeNode=q.firstNode;
         q.freeNode=firstNode;
         firstNode=q.freeNode;

      }
   }

   public static void main(String[] args)
   {
      // can make loops to exercise the nodes randomly
      boolean verdad = true;
   }
}



