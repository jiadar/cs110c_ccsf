package linkedBag;

import java.util.logging.*;

public class LinkedBag<T> implements BagInterface<T>
{
   private static final boolean DEBUG=true;
   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   private Node head = null;
   private int size = 0;
   
   private class Node {
      public T data;
      public Node next;
   }

   public int getCurrentSize()
   {
      return size;
   }

   public boolean isEmpty()
   {
      return size==0;
   }

   public boolean add(T newEntry)
   {
      Node temp = new Node();
      temp.data = newEntry;
      temp.next = head;
      head = temp;
      ++size;
      return true;
   }

   public T remove()
   {
      if (size == 0)
         return null;

      @SuppressWarnings("unchecked") T tempBag = (T)new Object();
      tempBag = head.data;
      head=head.next;
      --size;
      return tempBag;
   }

   public boolean remove(T anEntry)
   {
      if (size == 0)
         return false;

      if (head.data.equals(anEntry))
      {
         --size;
         head=head.next;
         return true;
      }

      Node prev = head;
      Node cur = head.next; 

      while(cur != null && !cur.data.equals(anEntry)) {
         prev = prev.next;
         cur = cur.next;
      }
      
      if (cur == null)
         return false;
      else
      {
         prev.next = cur.next;
         --size;
      }
      return true;
   }

   public void clear()
   {
      head = null;
      size = 0;
   }

   public int getFrequencyOf(T anEntry)
   {
      int count=0;
      Node cur = head;
      while (cur != null)
      {
         if (cur.data == anEntry)
            ++count;
         cur = cur.next;
      }
         
      return count;
   }

   public boolean contains(T anEntry)
   {
      if (size == 0)
         return false;

      Node cur = head;

      while (cur != null && !cur.data.equals(anEntry)) 
         cur = cur.next;

      return (cur != null);
   }

   public T[] toArray()
   {
      @SuppressWarnings("unchecked") T[] tempBagAry=(T[])new Object[1];
      return tempBagAry;
   }

   public String toString() {
      if (size == 0)
         return "null";

      String rval="";
      Node cur = head;

      while (cur != null) {
         rval += cur.data.toString() + " -> ";
         cur = cur.next;
      }
      rval+="null";
      return rval;
   }

   private Node getReferenceTo(T anEntry)
   {
      Node cur = head;
      while (cur != null && !cur.data.equals(anEntry)) {
         cur = cur.next;
      }
      return cur; 
   }

   public boolean hasDuplicateEntries()
   {
      Node cur = head;
      while (cur != null) {
         if (this.getFrequencyOf(cur.data) > 1)
            return true;
         cur = cur.next;
      }
      return false;
   }


   public boolean equals(BagInterface<T> other)
   {
      return false;
   }

}
