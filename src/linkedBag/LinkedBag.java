/* ===========================================================================
   $File: LinkedBag.java $
   $Date: Feb 3, 2017 $
   $Revision: 1.0 $
   $Creator: Ross Capdeville $
   $Notice: (C) Copyright 2017 by Ross Capdeville. All Rights Reserved. $
   =========================================================================== */

package linkedBag;

import java.util.logging.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class LinkedBag<T> implements BagInterface<T>
{
   private static final Logger lmsg = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

   private Node head = null;
   private int size = 0;
   
   private class Node {
      public T data;
      public Node next;
   }

   public T removeLast()
   {
      T rval;

      if (head == null)
         return null;

      if (head.next == null) {
         lmsg.info("in 1 element condition");
         rval = head.data;
         head = null;
         return rval;
      }
      
      Node cur = head;
      while (cur.next.next != null)
      {
         cur = cur.next;
      }

      rval = cur.next.data;
      lmsg.info("Returning: " + rval);
      cur.next = null;
      return rval;
   }

   public T removeFirst()
   {
      T rval;
      if (head == null)
         return null;
      rval = head.data;
      head = head.next;
      return rval;         
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

      @SuppressWarnings("unchecked") T temp = (T)new Object();
      temp = head.data;
      head=head.next;
      --size;
      return temp;
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
      @SuppressWarnings("unchecked") T[] tempBagAry=(T[])new Object[size];
      Node cur = head;
      int count = 0;
      while (cur != null)
      {
         tempBagAry[count]=cur.data;
         ++count;
         cur = cur.next;
      }
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
      HashMap<T,Integer> myMap = new HashMap<T,Integer>();
      HashMap<T,Integer> otherMap = new HashMap<T,Integer>();

      // Compute my map. This is easier because we have access to
      // the private getFrequencyMap method

      myMap=this.getFrequencyMap();

      // For the other map, ready access to the data elements is not
      // available. So we will remove each element from the bag and
      // insert it into a hash map. Note the other bag will be empty
      // after this loop.

      T key = other.remove();
      while (key != null)
      {
         otherMap.put(key, otherMap.containsKey(key) ? otherMap.get(key) + 1 : 1); 
         key = other.remove();
      }

      // Recreate other from the hashmap 

      for (HashMap.Entry<T, Integer> entry : otherMap.entrySet()) {
         for(int i = 0; i < entry.getValue(); ++i) 
            other.add(entry.getKey());  
      }      

      return myMap.equals(otherMap);
   }

   public void doubleElements()
   {
      // Get a hashmap of the current bag

      HashMap<T,Integer> myMap = new HashMap<T,Integer>();
      myMap = this.getFrequencyMap();

      // Double the elements 

      for (HashMap.Entry<T, Integer> entry : myMap.entrySet()) {
         for(int i = 0; i < entry.getValue(); ++i) 
            this.add(entry.getKey());  
      }            
   }

   // Private Methods


   // Compute a Frequency Distribution Hashmap of the bag    

   private HashMap<T,Integer> getFrequencyMap()
   {
      HashMap<T,Integer> myMap = new HashMap<T,Integer>();
      Node cur = head;
      while (cur != null)
      {
         myMap.put(cur.data, this.getFrequencyOf(cur.data));
         cur = cur.next;
      }
      return myMap;
   }

}
